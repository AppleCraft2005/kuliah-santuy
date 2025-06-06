<?php 
namespace App\Controllers\Admin; 

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
            'isAdmin' => true,
        ];
        return view('formPeminjaman_vw', $data);
    }

    public function edit($id) {
        $data = [
            'dosen' => $this->dosenModel->findAll(),
            'matkul' => $this->matkulModel->findAll(),
            'ruangan' => $this->ruanganModel->findAll(),
            'peminjaman' => $this->peminjamanModel->find($id),
            'isAdmin' => true,
        ];

        return view('formPeminjaman_vw',$data);
    }

    public function delete($id) {
        $this->peminjamanModel->delete($id);

        return redirect()->to('/admin/dashboard');
    }

    public function save() {
        $idPeminjaman = $this->request->getPost('id_peminjaman');

        if($idPeminjaman) {
            $existingName = $this->peminjamanModel->find($idPeminjaman);
            $namaPeminjam = $existingName['nama_peminjam'];
        }
        else {$namaPeminjam = session()->get('username');}

        $data = [
            'nama_peminjam' => $namaPeminjam,
            'nama_dosen' => $this->request->getPost('nama_dosen'),
            'nama_matkul' => $this->request->getPost('nama_matkul'),
            'mulai' => $this->request->getPost('mulai'),
            'selesai' => $this->request->getPost('selesai'),
            'nama_ruang' => $this->request->getPost('nama_ruang'),
            'sarana' => $this->request->getPost('sarana'),
            'status_peminjaman' => $this->request->getPost('status_peminjaman'),
            'komentar' => $this->request->getPost('komentar'),
        ];

        if($idPeminjaman) {
            helper('fonnte');
            $noWA = '082352043533';
            $pesan = "Halo " . $data['nama_peminjam']. "\n";
            $pesan .= "Peminjaman Ruang Kamu dengan Id:" . $idPeminjaman . "\n";
            $pesan .= "telah " . $data['status_peminjaman'] . "\n";
            $pesan .= "Dengan Komentar dari admin: " . $data['komentar'];
            sendWhatsAppFonnte($noWA, $pesan);   

            $this->peminjamanModel->update($idPeminjaman, $data);
            session()->setFlashdata('success', 'Peminjaman Berhasil Diperbarui.');
        }
        else {
            $this->peminjamanModel->insert($data);
            session()->setFlashdata('success', 'Peminjaman Berhasil Diajukan.');
        }

        return redirect()->to('/admin/dashboard');
    }
}