<?php

namespace App\Controllers;

use App\Models\PraktikanModel;

class Home extends BaseController
{
    public function index(): string
    {
        $model = new PraktikanModel();
        $data = $model -> getPraktikan();
        return view('berandahome', $data);
    }
}
