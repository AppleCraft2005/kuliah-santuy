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
        // menampilkan halaman form 
        $data = [
            'dosen' => $this->dosenModel->findAll(),
            'matkul' => $this->matkulModel->findAll(),
            'ruangan' => $this->ruanganModel->findAll(),
        ];
        return view('formPeminjaman_vw', $data);
    }

    public function edit($id) {
        // melakukan edit peminjaman
        $data = [
            'dosen' => $this->dosenModel->findAll(),
            'matkul' => $this->matkulModel->findAll(),
            'ruangan' => $this->ruanganModel->findAll(),
            'peminjaman' => $this->peminjamanModel->find($id),
        ];

        return view('formPeminjaman_vw',$data);
    }

    public function delete($id) {
        // menghapus peminjaman
        $this->peminjamanModel->delete($id);

        return redirect()->to('/user/dashboard');
    }

    public function save() {
        // menyimpan prubahan yang dilakukan
        $idPeminjaman = $this->request->getPost('id_peminjaman');
        $idUser = session()->get('id_user');

        $data = [
            'id_pengguna' => $idUser,
            'id_dosen' => $this->request->getPost('id_dosen'),
            'id_matkul' => $this->request->getPost('id_matkul'),
            'waktu_mulai' => $this->request->getPost('waktu_mulai'),
            'waktu_selesai' => $this->request->getPost('waktu_selesai'),
            'id_ruangan' => $this->request->getPost('id_ruangan'),
            'sarana' => $this->request->getPost('sarana'),
            'status_peminjaman' => 'Menunggu🔄',
            'komentar' => '',
        ];
        if($idPeminjaman) {
            $this->peminjamanModel->update($idPeminjaman, $data);
            session()->setFlashdata('success', 'Peminjaman Berhasil Diperbarui.');
        }
        else {
            $this->peminjamanModel->insert($data);
            session()->setFlashdata('success', 'Peminjaman Berhasil Diajukan.');
        }

        return redirect()->to('/user/dashboard');
    }
}