<?php

namespace App\Controllers;

use App\Models\UserModel;
use CodeIgniter\Email\Email;

class Authentication extends BaseController
{
    protected $userModel;

    public function __construct(){
        $this->userModel = new UserModel();
    }

    public function login() {
        // menampilkan halaman login
        return view('authentications/login_vw');
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
                if($user['role'] == 'admin') {return redirect()->to(route_to('admin_dashboard'))->with('success', 'Anda Berhasil Login!');}
                else {return redirect()->to(route_to('user_dashboard'))->with('success', 'Anda Berhasil Login!');}
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
        return view('authentications/register_vw');
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
            'password' => [
                'rules' => 'min_length[6]',
                'errors' => [
                    'min_length' => 'Password minimal memiliki panjang 6 karakter!'
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
            return redirect()->back()->withInput()->with('validation', $this->validator);
        }

        $userData = [
            'username' => $this->request->getPost('username'),
            'password' => password_hash($this->request->getPost('password'), PASSWORD_DEFAULT),
            'email' => $this->request->getPost('email'),
            'role' => 'user',
            'nomor_telepon' => $this->request->getPost('nomor_telepon'),
        ];
        
        $this->userModel->insert($userData);
    
        return redirect()->to(route_to('login'))->with('success', "Berhasil Melakukan Register");
        
    }

    public function forgotPwdForm() {
        // menampilkan halaman forgot password
        return view('authentications/forgot_pwd_form_vw', ['validation' => session('validation')]);
    }

    public function sendResetLink() {
        // mengirimkan link reset password
        $email = $this->request->getPost('email');

        $validationRules = [
            'email' => [
                'rules' => 'valid_email',
                'errors' => [
                    'valid_email' => 'Format email tidak valid.'
                ]
            ]
        ];

        if(!$this->validate($validationRules)) {return redirect()->back()->withInput()->with('validation', $this->validator);}

        $user = $this->userModel->where('email', $email)->first();

        if(empty($user)) {return redirect()->back()->with('error', 'Email Tidak Ditemukan!');}

        $tokenresetPwd = bin2hex(random_bytes(32));
        $tokenExp = date('Y-m-d H:i:s', strtotime('+1 hour'));

        $this->userModel->update($user['id_pengguna'], [
            'token' => $tokenresetPwd,
            'token_exp' => $tokenExp,
        ]);
        
        // untuk kirim email ke user
        $emailService = service('email');
        $emailService->setTo($user['email']);
        $emailService->setSubject('Reset Password Akun SIRUANG Anda');

        // buat link reset pwd
        $resetLink = url_to('reset_password_form') . '?token=' . $tokenresetPwd;
        $message = view('email/reset_pwd_email_vw', ['resetLink' => $resetLink, 'username' => $user['username']]);
        $emailService->setMessage($message);

        if($emailService->send()) {session()->setFlashdata('success', 'Link reset password telah terkirim');}
        else {session()->setFlashdata('error', 'Link reset password gagal terkirim, coba beberapa saat lagi');}

        return redirect()->to(route_to('forgot_password'));
    }

    public function resetPwdForm() {
        // menampilkan form untuk update password
        $token = $this->request->getGet('token');
        $user = $this->userModel->where('token', $token)->first();

        if(empty($token)) {
            return redirect()->to(route_to('login'))->with('error', 'Token reset password tidak valid atau hilang.');
        }

        if(empty($user) || $user['token_exp'] < date('Y-m-d H:i:s')) {
            return redirect()->to(route_to('login'))->with('error', 'Token reset password tidak valid atau sudah kadaluarsa.');
        }

        $data = [
            'token' => $token,
            'validation' => session('validation')
        ];

        return view('authentications/reset_pwd_form_vw', $data);
    }

    public function updatePwd() {
        // memperbarui password di database
        $token = $this->request->getPost('token');
        $newPassword = $this->request->getPost('password');
        
        $validationRules = [
            'token' => 'required', 
            'password' => [
                'rules' => 'min_length[6]',
                'errors' => [
                    'min_length' => 'Password minimal memiliki 6 karakter.'
                ]
            ],
            'confirm_password' => [
                'rules' => 'matches[password]',
                'errors' => [
                    'matches' => 'Konfirmasi password tidak cocok dengan password baru.'
                ]
            ],
        ];

        if (!$this->validate($validationRules)) {
            return redirect()->back()->with('validation', $this->validator);
        }

        $user = $this->userModel->where('token', $token)->first();

        if (empty($user) || $user['token_exp'] < date('Y-m-d H:i:s')) {
            return redirect()->to(route_to('login'))->with('error', 'Token reset password tidak valid atau sudah kadaluarsa.');
        }

        $this->userModel->update($user['id_pengguna'], [
            'password' => password_hash($newPassword, PASSWORD_DEFAULT),
            'token' => null,
            'token_exp' => null,
        ]);

        return redirect()->to(route_to('login'))->with('success', 'Password Anda berhasil diubah. Silakan login dengan password baru.');  
    }

    public function logout() {
        // melakukan logout
        session()->destroy();

        return redirect()->to('/');
    }

}
