<?php
namespace App\Controllers\User;

use App\Controllers\BaseController;
use App\Models\DosenModel;
use App\Models\MatkulModel;
use App\Models\PeminjamanModel;
use App\Models\RuangModel;
use DateTime;

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
        return view('form/form_peminjaman_vw', $data);
    }

    public function edit($id) {
        // melakukan edit peminjaman
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

        return redirect()->to(route_to('user_dashboard'));
    }

    public function save() {
        // menyimpan prubahan yang dilakukan
        $idPeminjaman = $this->request->getPost('id_peminjaman');
        $idUser = session()->get('id_user');
        $idRuangan = $this->request->getPost('id_ruangan');
        $waktuMulai = DateTime::createFromFormat('Y-m-d\TH:i', $this->request->getPost('waktu_mulai'));
        $waktuSelesai = DateTime::createFromFormat('Y-m-d\TH:i', $this->request->getPost('waktu_selesai'));
        $waktuSaatIni = new DateTime();
        $waktuSaatIni->setTime($waktuSaatIni->format('H'), $waktuSaatIni->format('i'),0,0);

        // validasi untuk waktuMulai dan waktuSelesai
        if($waktuMulai > $waktuSelesai) {return redirect()->back()->withInput()->with('error', 'Waktu mulai tidak boleh melebihi waktu selesai!');} 
        else if($waktuMulai == $waktuSelesai) {return redirect()->back()->withInput()->with('error', 'Waktu mulai tidak boleh sama dengan waktu selesai!');}
        else if($waktuMulai < $waktuSaatIni) {return redirect()->back()->withInput()->with('error', 'Waktu mulai tidak boleh kurang dari waktu saat ini!');}
        
        $conflictQuery = $this->peminjamanModel->builder()
                                               ->where('id_ruangan', $idRuangan)
                                               ->where('waktu_mulai <', $waktuSelesai->format('Y-m-d H:i:s'))
                                               ->where('waktu_selesai >', $waktuMulai->format('Y-m-d H:i:s'))
                                               ->groupStart()
                                                    ->where('status_peminjaman', 'Menunggu🔄')
                                                    ->orWhere('status_peminjaman', 'Disetujui✅')
                                                ->groupEnd();

        $conflictPeminjaman = $conflictQuery->get()->getResultArray();

        if(!empty($conflictPeminjaman)) {
            return redirect()->back()->withInput()->with('error', 'Ruangan ini sudah dipinjam, silahkan pilih waktu atau ruangan lain!');
        }

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
            //save untuk update data
            $this->peminjamanModel->update($idPeminjaman, $data);
            session()->setFlashdata('success', 'Peminjaman Berhasil Diperbarui.');
        }
        else {
            // save untuk insert data
            $this->peminjamanModel->insert($data);
            session()->setFlashdata('success', 'Peminjaman Berhasil Diajukan.');
        }

        return redirect()->to(route_to('user_dashboard'));
    }
}