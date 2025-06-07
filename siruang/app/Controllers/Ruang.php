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
        $searchTanggal = $this->request->getGet('tanggal');
        $query = $this->peminjamanModel->getPeminjamanBaseQuery();

        if(!empty($searchRuangan)) {$query->where('pinjam_ruang.nama_ruang', $searchRuangan);}
        if(!empty($searchTanggal)) {
            $startOfDay = $searchTanggal . ' 00:00:00';
            $endOfDay = $searchTanggal . ' 23:59:59';

            $query->where('pinjam_ruang.mulai >=', $startOfDay);
            $query->where('pinjam_ruang.mulai <=', $endOfDay);
        }
        $query->orderBy('pinjam_ruang.id_peminjaman', 'DESC');

        $peminjamanData = $query->paginate(10, 'peminjaman_list', $this->request->getVar('page_peminjaman_list'));
        $pager = $this->peminjamanModel->pager;

        $data = [
            'pinjam' => $peminjamanData,
            'pager' => $pager,
            'ruangan_list' => $this->ruanganModel->findAll(),
            'search_params' => [
                'ruangan' => $searchRuangan,
                'tanggal' => $searchTanggal
                ]
        ];

        return view('ListPeminjamanRuang_vw', $data);
    }
}