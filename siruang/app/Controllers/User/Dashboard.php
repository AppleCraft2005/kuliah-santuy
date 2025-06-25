<?php 
namespace App\Controllers\User;

use App\Controllers\BaseController;
use App\Models\PeminjamanModel;
use App\Models\RuangModel;

class Dashboard extends BaseController {
    protected $peminjamanModel;
    protected $ruanganModel;

    public function __construct() {
        $this->peminjamanModel = new PeminjamanModel();
        $this->ruanganModel = new RuangModel(); 
    }

    public function index() {
        // search ruangan & tanggal
        $searchRuangan = $this->request->getGet('ruangan');
        $searchTanggal = $this->request->getGet('tanggal');
        $query = $this->peminjamanModel->getPeminjamanBaseQuery();

        if(!empty($searchRuangan)) {$query->where('peminjaman_ruang.id_ruangan', $searchRuangan);}
        if(!empty($searchTanggal)) {
            $startOfDay = $searchTanggal . ' 00:00:00';
            $endOfDay = $searchTanggal . ' 23:59:59';

            $query->where('peminjaman_ruang.waktu_mulai >=', $startOfDay);
            $query->where('peminjaman_ruang.waktu_mulai <=', $endOfDay);
        }
        $query->orderBy('peminjaman_ruang.id_peminjaman', 'DESC');

        // pagination
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

        return view('dashboards/dashboard_user_vw', $data);
    }
}