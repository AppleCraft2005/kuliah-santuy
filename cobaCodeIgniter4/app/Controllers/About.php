<?php
 namespace App\Controllers;

 class About extends BaseController 
 {
    public function index(): String {
        return view('TentangSaya');
    }
    public function tim($nama = "Seseorang", $jabatan = "karyawan") {
        return view('TentangTim', ['nama' => $nama, 'jabatan' => $jabatan]);
    }
 }