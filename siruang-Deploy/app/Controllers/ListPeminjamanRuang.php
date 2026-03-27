<?php
namespace App\Controllers;
use App\Models\PeminjamanModel;
use App\Models\RuangModel;

class ListPeminjamanRuang extends BaseController{
    protected $peminjamanModel;
    protected $ruanganModel;

    public function __construct() {
        $this->peminjamanModel = new PeminjamanModel();
        $this->ruanganModel = new RuangModel(); 
    }

    public function index() {
        // Search ruangan & tanggal
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

        // login button dynamic
        $loginBtnUrl = base_url('/login');
        $loginBtnTxt = 'LOGIN';

        if(session()->get('isLoggedIn')) {
            $loginBtnUrl = session()->get('role') == 'admin' ? base_url('/admin/dashboard') : base_url('/user/dashboard');
            $loginBtnTxt = 'Dashboard';
        }

        $data = [
            'pinjam' => $peminjamanData,
            'pager' => $pager,
            'ruangan_list' => $this->ruanganModel->findAll(),
            'loginbtnurl' => $loginBtnUrl,
            'loginbtntxt' => $loginBtnTxt,
            'search_params' => [
                'ruangan' => $searchRuangan,
                'tanggal' => $searchTanggal
                ]
        ];
        return view('ListPeminjamanRuang_vw', $data);
    }
}