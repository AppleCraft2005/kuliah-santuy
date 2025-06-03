<?php
namespace App\Controllers;
use App\Controllers\BaseController;

class Form extends BaseController {

    public function index() {
        return view('formPeminjaman_vw');
    }
}