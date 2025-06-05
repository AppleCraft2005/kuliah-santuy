<?php 
namespace App\Models;

use CodeIgniter\Model;

class PeminjamanModel extends Model {
    protected $table = 'pinjam_ruang';
    protected $primaryKey = 'id_peminjaman';
    protected $allowedFields = [
        'nama_peminjam',
        'nama_dosen',
        'nama_matkul',
        'mulai',
        'selesai',
        'nama_ruang',
        'sarana',
        'status_peminjaman', 
        'komentar',          
    ];

    public function getPeminjamanBaseQuery() {
        return $this->select('pinjam_ruang.*, dosen.nama_dosen, mata_kuliah.nama_matkul, ruangan.nama_ruang')
                    ->join('dosen', 'dosen.id_dosen = pinjam_ruang.nama_dosen')
                    ->join('mata_kuliah','mata_kuliah.id_matkul = pinjam_ruang.nama_matkul')
                    ->join('ruangan','ruangan.id_ruangan = pinjam_ruang.nama_ruang');
    }
}