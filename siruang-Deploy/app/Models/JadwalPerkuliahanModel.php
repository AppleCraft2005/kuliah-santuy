<?php 

namespace App\Models;

use CodeIgniter\Model;

class JadwalPerkuliahanModel extends Model {
    protected $table = 'jadwal_perkuliahan';
    protected $primaryKey = 'id_jadwal';
    protected $allowedFields = ['nama_dosen', 'nama_matkul', 'nama_ruangan', 'hari', 'waktu_mulai', 'waktu_selesai'];

    public function getJadwalBaseQuery() {
        return $this->select('jadwal_perkuliahan.*, dosen.nama_dosen, mata_kuliah.nama_matkul, ruangan.nama_ruang')
                ->join('dosen', 'dosen.id_dosen = jadwal_perkuliahan.id_dosen')
                ->join('mata_kuliah','mata_kuliah.id_matkul = jadwal_perkuliahan.id_matkul')
                ->join('ruangan','ruangan.id_ruangan = jadwal_perkuliahan.id_ruangan');
    }
}

