<?php
namespace App\Controllers;
use App\Models\PeminjamanModel;

class Ruang extends BaseController{
    public function index() {

        $model = new PeminjamanModel();
        $data['pinjam'] = $model->findAll();

        return view('ListPeminjamanRuang_vw', $data);
    }
}