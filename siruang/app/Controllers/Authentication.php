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
                session()->set(['username' => $user['username'], 'isLoggedIn' => true]);
                return redirect()->to('/tes');
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
            'confirm_password' => [
                'rules'=>'matches[password]',
                'errors' =>[
                    'matches[password]' => 'Konfirmasi password tidak sama dengan password!'
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

}
