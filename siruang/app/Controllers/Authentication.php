<?php

namespace App\Controllers;

use App\Models\UserModel;

class Authentication extends BaseController
{
    protected $userModel;

    public function __construct(){
        $this->userModel = new UserModel();
    }

    public function login() {
        // menampilkan halaman login
        return view('Login_vw');
    }

    public function loginauth() {
        // authentikasi login
        $username = $this->request->getPost('username');
        $password = $this->request->getPost('password');
            
        $user = $this->userModel->where('username', $username)->first();
    
        if($user) {
            if(password_verify($password, $user['password'])) {
                session()->set([
                    'username' => $user['username'], 
                    'id_user' => $user['id_pengguna'],
                    'isLoggedIn' => true,
                    'role' => $user['role']
                ]);
                if($user['role'] == 'admin') return redirect()->to('/admin/dashboard')->with('success', 'Anda Berhasil Login!');
                else {return redirect()->to('/user/dashboard')->with('success', 'Anda Berhasil Login!');}
            }
            else {
                return redirect()->back()->with('error', 'Password yang anda masukkan salah!');
            }
        }
        else {
            return redirect()->back()->with('error', 'username Anda Tidak Ditemukan');
        }
        
    }

    public function register() {
        // menampilkan halaman register
        return view('Register_vw');
    }

    public function registerauth() {
        // authentikasi register
        $validateRules = [
            'username' => [
                'rules' => 'is_unique[users.username]',
                'errors' => [
                    'is_unique' => 'Username sudah digunakan!'
                ]
            ],
            'confirm_password' => [
                'rules'=>'matches[password]',
                'errors' => [
                    'matches' => 'Konfirmasi password tidak sama dengan password!'
                ]
            ],
            'email' => [
                'rules'=>'regex_match[/^[\w.+-]+@(mhs\.ulm\.ac\.id)$/]|is_unique[users.email]',
                'errors'=>[
                    'regex_match' => 'Email yang Dimasukkan Bukan Email Mahasiswa ULM!',
                    'is_unique' => 'Email sudah digunakan!'
                ]
            ]
        ];
        if(!$this->validate($validateRules)) {
            return redirect()->back()->with('validation', $this->validator);
        }

        $userData = [
            'username' => $this->request->getPost('username'),
            'password' => password_hash($this->request->getPost('password'), PASSWORD_DEFAULT),
            'email' => $this->request->getPost('email'),
            'nomor_telepon' => $this->request->getPost('nomor_telepon'),
        ];
        
        $this->userModel->insert($userData);
    
        return redirect()->to('/login')->with('success', "Berhasil Melakukan Register");
        
    }

    public function forgotPwdForm() {
        return view('forgot_pwd_form_vw', ['validation' => session('validation')]);
    }

    public function sendResetLink() {
        $email = $this->request->getPost('email');

        $validationRules = [
            'email' => [
                'rules' => 'required|valid_email',
                'errors' => [
                    'required' => 'Email wajib diisi.',
                    'valid_email' => 'Format email tidak valid.'
                ]
            ]
        ];

        if (!$this->validate($validationRules)) {
            return redirect()->back()->withInput()->with('validation', $this->validator);
        }

        $user = $this->userModel->where('email', $email)->first();

        if(empty($user)) {
            session()->setFlashdata('info', 'Jika Email sesuai, maka anda akan mendapat link reset password');
            return redirect()->to(route_to('forgot_password'));
        }

        $tokenresetPwd = bin2hex(random_bytes(32));
        $tokenExp = date('Y-m-d H:i:s', strtotime('+1 hour'));

        $this->userModel->update($user['id_pengguna'], [
            'token' => $tokenresetPwd,
            'token_exp' => $tokenExp,
        ]);
        
        // untuk kirim email ke user
        $emailService = service('email');
        $emailService->setTo($user['email']);
        $emailService->setSubject('Reset Password Anda');

        // buat link reset pwd
        $resetLink = route_to('reset_pwd') . '?token=' . $tokenresetPwd;

        $message = view('email/reset_password_email', ['resetLink' => $resetLink, 'username' => $user['username']]);
        $emailService->setMessage($message);

        if($emailService->send()) {
            session()->setFlashdata('error', 'Link reset password gagal terkirim, coba beberapa saat lagi');
        }

        return redirect()->to(route_to('forgot_pwd'));
    }

    public function resetPwdForm() {
        $token = $this->request->getGet('token');

        if(empty($token)) {
            return redirect()->to(route_to('login'))->with('error', 'Token reset password tidak valid atau hilang.');
        }

        $user = $this->userModel->where('token', $token)->first();

        if(empty($user) || $user['token_exp'] < date('Y-m-d H:i:s')) {
            return redirect()->to(route_to('login'))->with('error', 'Token reset password tidak valid atau sudah kadaluarsa.');
        }

        $data = [
            'token' => $token,
            'validation' => session('validation')
        ];

        return view('reset_pwd_form_vw', $data);
    }

    public function updatePwd() {
        $token = $this->request->getPost('token');
        $newPassword = $this->request->getPost('password');
        $confirmPassword = $this->request->getPost('confirm_password');
        
        // $rules = [
        //     'token' => 'required', // Pastikan token ada
        //     'password' => [
        //         'rules' => 'required|min_length[6]',
        //         'errors' => [
        //             'required' => 'Password baru wajib diisi.',
        //             'min_length' => 'Password minimal 6 karakter.'
        //         ]
        //     ],
        //     'confirm_password' => [
        //         'rules' => 'required|matches[password]',
        //         'errors' => [
        //             'required' => 'Konfirmasi password wajib diisi.',
        //             'matches' => 'Konfirmasi password tidak cocok dengan password baru.'
        //         ]
        //     ],
        // ];

        // if (!$this->validate($rules)) {
        //     return redirect()->back()->withInput()->with('validation', $this->validator);
        // }

        $user = $this->userModel->where('token', $token)->first();

        if (empty($user) || $user['reset_token_expires_at'] < date('Y-m-d H:i:s')) {
            session()->setFlashdata('error', 'Token reset password tidak valid atau sudah kadaluarsa.');
            return redirect()->to(route_to('login'));
        }

        $this->userModel->update($user['id_pengguna'], [
            'password' => password_hash($newPassword, PASSWORD_DEFAULT),
            'token' => null,
            'token_exp' => null,
        ]);

        session()->setFlashdata('success', 'Password Anda berhasil diubah. Silakan login dengan password baru.');
        return redirect()->to(route_to('login'));  
    }

    public function logout() {
        // melakukan logout
        session()->destroy();
        return redirect()->to('/');
    }

}
