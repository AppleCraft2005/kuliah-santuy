<?php
namespace App\Controllers;
use App\Models\PeminjamanModel;
use App\Models\RuangModel;

class Ruang extends BaseController{
    protected $peminjamanModel;
    protected $ruanganModel;

    public function __construct() {
        $this->peminjamanModel = new PeminjamanModel();
        $this->ruanganModel = new RuangModel(); 
    }

    public function index() {
        $searchRuangan = $this->request->getGet('ruangan');
        $query = $this->peminjamanModel->getPeminjamanBaseQuery();

        if(!empty($searchRuangan)) {$query->where('pinjam_ruang.nama_ruang', $searchRuangan);}

        $query->orderBy('pinjam_ruang.id_peminjaman', 'DESC');

        $peminjamanData = $query->paginate(10, 'peminjaman_list', $this->request->getVar('page_peminjaman_list'));
        $pager = $this->peminjamanModel->pager;

        $data = [
            'pinjam' => $peminjamanData,
            'pager' => $pager,
            'ruangan_list' => $this->ruanganModel->findAll(),
            'search_params' => ['ruangan' => $searchRuangan]
        ];

        return view('ListPeminjamanRuang_vw', $data);
    }
}