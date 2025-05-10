<?php

namespace App\Controllers;

use App\Models\ProfilModel;

class Profil extends BaseController
{
    public function index(): string
    {
        $model = new ProfilModel();
        $data = $model -> getProfil();
        return view('profile', $data);
    }
}
