<?php

namespace App\Controllers;

use App\Models\HomeModel;
use App\Models\ProfilModel;

class Home extends BaseController
{
    public function index(): string
    {
        $model = new HomeModel();
        $data = $model -> getPraktikan();
        return view('home', $data);
    }
    public function profil(): string
    {
        $model = new ProfilModel();
        $data = $model -> getProfil();
        return view('profile', $data);
    }
}
    
