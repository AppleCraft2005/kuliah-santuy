<?php 
namespace App\Controllers\Admin; 

use App\Controllers\BaseController;
use App\Models\DosenModel;
use App\Models\MatkulModel;
use App\Models\PeminjamanModel;
use App\Models\RuangModel;
use App\Models\UserModel;

class Peminjaman extends BaseController {
    protected $peminjamanModel;
    protected $dosenModel;
    protected $matkulModel;
    protected $ruanganModel;
    protected $usersModel;

    public function __construct() {
        $this->peminjamanModel = new PeminjamanModel();
        $this->dosenModel = new DosenModel();
        $this->matkulModel = new MatkulModel();
        $this->ruanganModel = new RuangModel();       
        $this->usersModel = new UserModel(); 
    }

    public function edit($id) {
        // melakukan edit peminjaman di form
        $data = [
            'dosen' => $this->dosenModel->findAll(),
            'matkul' => $this->matkulModel->findAll(),
            'ruangan' => $this->ruanganModel->findAll(),
            'peminjaman' => $this->peminjamanModel->find($id),
        ];

        return view('form/form_peminjaman_vw',$data);
    }

    public function delete($id) {
        // menghapus peminjaman
        $this->peminjamanModel->delete($id);

        return redirect()->to(route_to('admin_dashboard'));
    }

    public function save() {
        // menyimpan perubahan
        $idPeminjaman = $this->request->getPost('id_peminjaman');

        if($idPeminjaman) {
            $existingName = $this->peminjamanModel->find($idPeminjaman);
            $idPengguna = $existingName['id_pengguna'];
        }
        else {$idPengguna = session()->get('id_user');}
        
        $nomorTeleponUser = $this->usersModel->select('nomor_telepon')->where('id_pengguna',$idPengguna)->first();
        $namaPeminjam = $this->usersModel->select('username')->where('id_pengguna',$idPengguna)->first();

        $data = [
            'id_pengguna' => $idPengguna,
            'id_dosen' => $this->request->getPost('id_dosen'),
            'id_matkul' => $this->request->getPost('id_matkul'),
            'waktu_mulai' => $this->request->getPost('waktu_mulai'),
            'waktu_selesai' => $this->request->getPost('waktu_selesai'),
            'id_ruangan' => $this->request->getPost('id_ruangan'),
            'sarana' => $this->request->getPost('sarana'),
            'status_peminjaman' => $this->request->getPost('status_peminjaman'),
            'komentar' => $this->request->getPost('komentar'),
        ];

        if($idPeminjaman) {
            // API Fonnte
            helper('fonnte');
            $pesan = "Halo " . $namaPeminjam['username']. "\n";
            $pesan .= "Peminjaman Ruang Kamu dengan Id:" . $idPeminjaman . "\n";
            $pesan .= "telah " . $data['status_peminjaman'] . "\n";
            $pesan .= "Dengan Komentar dari admin: " . $data['komentar']. "\n\n";
            $pesan .= "Jika ada yang ingin ditanyakan ke admin, kamu bisa menghubungi lewat nomor ini";
            sendWhatsAppFonnte($nomorTeleponUser, $pesan);   

            //save untuk update data
            $this->peminjamanModel->update($idPeminjaman, $data);
            session()->setFlashdata('success', 'Peminjaman Berhasil Diperbarui.');
        }

        return redirect()->to(route_to('admin_dashboard'));
    }
}