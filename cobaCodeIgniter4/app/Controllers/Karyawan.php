<?php

namespace App\Controllers;

use App\Models\TimModel;

class Karyawan extends BaseController
{
    public function index()
    {
        return "ini halaman karyawan";
    }
    public function daftarkaryawan() {
        $model = new TimModel();
        $data['tim'] = $model -> getAll();
        return view('DaftarTim', $data);
    }
}
