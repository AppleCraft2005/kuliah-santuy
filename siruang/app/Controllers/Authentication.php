<?php

namespace App\Controllers;

use App\Models\UserModel;

class Authentication extends BaseController
{

    public function login() {
        return view('Login_vw');
    }

    public function loginauth() {
        $username = $this->request->getPost('username');
        $password = $this->request->getPost('password');
            
        $Usermodel = new UserModel();
        $user = $Usermodel->where('username', $username)->first();
    
        if($user) {
            if(password_verify($password, $user['password'])) {
                session()->set([
                    'username' => $user['username'], 
                    'isLoggedIn' => true,
                    'role' => $user['role']
                ]);
                if($user['role'] == 'admin') return redirect()->to('/admin/dashboard');
                else {return redirect()->to('/user/dashboard');}
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
        return view('Register_vw');
    }

    public function registerauth() {
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
                'rules'=>'regex_match[/^[\w.+-]+@(mhs\.ulm\.ac\.id|ulm\.ac\.id)$/]|is_unique[users.email]',
                'errors'=>[
                    'regex_match' => 'Email yang Dimasukkan Bukan Email ULM!',
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
        ];
        
    
        $userModel = new UserModel();
        $userModel->insert($userData);
    
        return redirect()->to('/login')->with('success', "Berhasil Melakukan Register");
        
    }
    public function logout() {
        session()->destroy();
        return redirect()->to('/');
    }

}
