<?php 
namespace App\Controllers;

use App\Models\UserModel;

class Login extends BaseController {
    public function index() {
        return view('login/form');
    }
    public function Auth() {

        $username = $this->request->getPost('username');
        $password = $this->request->getPost('password');

        $userModel = new UserModel();
        $user = $userModel->where('username', $username)->first();

        if($user) {
            if($password == $user['password']) {
                session()->set(['logged_in' => true]);
                return redirect()->to('/buku');
            }
            else {return redirect()->back()->with('error', 'password yang anda masukkan salah!');}
        } 
        else {return redirect()->back()->with('error', 'username tidak ditemukan!');}
    }
}