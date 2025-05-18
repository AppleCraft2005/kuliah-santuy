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
        $validateRules = [
            'judul'=>[
                'rules'=>'required|alpha_space', 
                'errors'=>[
                    'required'=>'Judul wajib diisi!',
                    'alpha_space'=>'Judul harus berupa huruf!'
                ]
            ],
            'penulis'=>[
                'rules'=>'required|alpha_space', 
                'errors'=>[
                    'required'=>'Penulis wajib diisi!',
                    'alpha_space'=>'Penulis harus berupa huruf!'
                ]
            ],
            'penerbit'=>[
                'rules'=>'required|alpha_space', 
                'errors'=>[
                    'required'=>'Penerbit wajib diisi!',
                    'alpha_space'=>'Penerbit harus berupa huruf!'
                ]
            ],
            'tahun_terbit'=>[
                'rules'=>'required|integer|greater_than[1800]|less_than[2024]', 
                'errors'=>[
                    'required'=>'Tahun Terbit wajib diisi!',
                    'integer'=>'Tahun Terbit harus berupa angka!',
                    'greater_than'=>'Tahun Terbit harus lebih dari 1800!',
                    'less_than'=>'Tahun Terbit harus kurang dari 2024!',
                ]
            ],
        ];

        if(!$this->validate($validateRules)) {
            return redirect()->back()->with('validation', $this->validator);
        }

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