<?php
namespace App\Controllers\Admin; 

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
        $searchRuangan = $this->request->getGet('ruangan');
        $query = $this->peminjamanModel->getPeminjamanLengkap();

        if(!empty($searchRuangan)) {$query->where('pinjam_ruang.nama_ruang', $searchRuangan);}

        $data = [
            'pinjam' => $query->findAll(),
            'ruangan_list' => $this->ruanganModel->findAll(),
            'search_params' => ['ruangan' => $searchRuangan]
        ];

        return view('dashboard_admin_vw', $data);
    }
}