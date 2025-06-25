<?php 

namespace App\Models;

use CodeIgniter\Model;

class RuanganFasilitasModel extends Model {
    protected $table = 'ruangan_fasilitas';
    protected $primaryKey = 'id_ruangan_fasilitas';
    protected $allowedFields = ['id_ruangan','id_fasilitas','jumlah_fasilitas'];

    public function getRuanganFasilitasBaseQuery() {
        return $this->select('ruangan_fasilitas.*, ruangan.nama_ruang, ruangan.url_foto, fasilitas.nama_fasilitas, ruangan.kapasitas')
                    ->join('ruangan', 'ruangan.id_ruangan = ruangan_fasilitas.id_ruangan')
                    ->join('fasilitas', 'fasilitas.id_fasilitas = ruangan_fasilitas.id_fasilitas');    
    }
}