<?php
namespace App\Controllers\User;

use App\Controllers\BaseController;
use App\Models\DosenModel;
use App\Models\MatkulModel;
use App\Models\PeminjamanModel;
use App\Models\RuangModel;

class Peminjaman extends BaseController {
    protected $peminjamanModel;
    protected $dosenModel;
    protected $matkulModel;
    protected $ruanganModel;

    public function __construct() {
        $this->peminjamanModel = new PeminjamanModel();
        $this->dosenModel = new DosenModel();
        $this->matkulModel = new MatkulModel();
        $this->ruanganModel = new RuangModel();        
    }

    public function index() {
        $data = [
            'dosen' => $this->dosenModel->findAll(),
            'matkul' => $this->matkulModel->findAll(),
            'ruangan' => $this->ruanganModel->findAll(),
            'isAdmin' => false,
        ];
        return view('formPeminjaman_vw', $data);
    }

    public function edit($id) {
        $data = [
            'dosen' => $this->dosenModel->findAll(),
            'matkul' => $this->matkulModel->findAll(),
            'ruangan' => $this->ruanganModel->findAll(),
            'peminjaman' => $this->peminjamanModel->find($id),
            'isAdmin' => false,
        ];

        return view('formPeminjaman_vw',$data);
    }

    public function delete($id) {
        $this->peminjamanModel->delete($id);

        return redirect()->to('/user/dashboard');
    }

    public function save() {
        $idPeminjaman = $this->request->getPost('id_peminjaman');
        $namaPeminjam = session()->get('username');
        $data = [
            'nama_peminjam' => $namaPeminjam,
            'nama_dosen' => $this->request->getPost('nama_dosen'),
            'nama_matkul' => $this->request->getPost('nama_matkul'),
            'mulai' => $this->request->getPost('mulai'),
            'selesai' => $this->request->getPost('selesai'),
            'nama_ruang' => $this->request->getPost('nama_ruang'),
            'sarana' => $this->request->getPost('sarana'),
            'status_peminjaman' => 'Menunggu🔄',
            'komentar' => '',
        ];
        if($idPeminjaman) {$this->peminjamanModel->update($idPeminjaman, $data);}
        else {$this->peminjamanModel->insert($data);}

        return redirect()->to('/user/dashboard');
    }
}