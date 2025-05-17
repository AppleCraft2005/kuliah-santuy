<?php

namespace App\COntrollers;

use App\Controllers\BaseController;
use App\Models\BukuModel;

class Buku extends BaseController {
    public function index() {
        $bukuModel = new BukuModel();
        $data['buku'] = $bukuModel->findAll();

        return view('buku/index', $data);
    }
    public function tambah() {
        return view('buku/form', ['buku' => null]);
    }
    public function edit($id) {
        $bukuModel = new BukuModel();
        $data['buku'] = $bukuModel->find($id);

        return view('buku/form', $data);
    }
    public function hapus($id) {
        $bukuModel = new BukuModel();
        $bukuModel->delete($id);
        
        return redirect()->to('/buku');
    }
    public function simpan() {
        $bukuModel = new BukuModel();
        $id = $this->request->getPost('id');
        $data = [
            'judul' => $this->request->getPost('judul'),
            'penulis' => $this->request->getPost('penulis'),
            'penerbit' => $this->request->getPost('penerbit'),
            'tahun_terbit' => $this->request->getPost('tahun_terbit'),
        ];
        if($id) {$bukuModel->update($id, $data);}
        else {$bukuModel->insert($data);}

        return redirect()->to('/buku');
    }
}