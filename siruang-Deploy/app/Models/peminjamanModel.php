<?php 
namespace App\Models;

use CodeIgniter\Model;

class PeminjamanModel extends Model {
    protected $table = 'peminjaman_ruang';
    protected $primaryKey = 'id_peminjaman';
    protected $allowedFields = [
        'id_pengguna',
        'id_dosen',
        'id_matkul',
        'waktu_mulai',
        'waktu_selesai',
        'id_ruangan',
        'sarana',
        'status_peminjaman', 
        'komentar',          
    ];

    public function getPeminjamanBaseQuery() {
        return $this->select('peminjaman_ruang.*, dosen.nama_dosen, mata_kuliah.nama_matkul, ruangan.nama_ruang, users.username')
                    ->join('dosen', 'dosen.id_dosen = peminjaman_ruang.id_dosen')
                    ->join('mata_kuliah','mata_kuliah.id_matkul = peminjaman_ruang.id_matkul')
                    ->join('ruangan','ruangan.id_ruangan = peminjaman_ruang.id_ruangan')
                    ->join('users', 'users.id_pengguna = peminjaman_ruang.id_pengguna');
    }
}