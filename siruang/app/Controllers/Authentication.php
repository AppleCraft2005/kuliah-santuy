<?php

namespace App\Controllers;

use App\Models\UserModel;

class Authentication extends BaseController
{

    public function login() {
        // menampilkan halaman login
        return view('Login_vw');
    }

    public function loginauth() {
        // authentikasi login
        $username = $this->request->getPost('username');
        $password = $this->request->getPost('password');
            
        $Usermodel = new UserModel();
        $user = $Usermodel->where('username', $username)->first();
    
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
        
    
        $userModel = new UserModel();
        $userModel->insert($userData);
    
        return redirect()->to('/login')->with('success', "Berhasil Melakukan Register");
        
    }
    public function logout() {
        // melakukan logout
        session()->destroy();
        return redirect()->to('/');
    }

}
