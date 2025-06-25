<?php
namespace App\Controllers;

use App\Models\RuanganFasilitasModel;
use App\Models\RuangModel;

class ListFasilitasRuangan extends BaseController {
    protected $ruanganFasilitasModel;
    protected $ruanganModel;

    public function __construct(){
        $this->ruanganFasilitasModel = new RuanganFasilitasModel();
        $this->ruanganModel = new RuangModel();
    }

    public function index() {
        $data = [
            'ruanganFasilitas' => $this->ruanganFasilitasModel->getRuanganFasilitasBaseQuery()->findAll(),
            'ruangan' => $this->ruanganModel->findAll(),
        ];

        return view('list/list_fasilitas_ruangan_vw', $data);
    }
}