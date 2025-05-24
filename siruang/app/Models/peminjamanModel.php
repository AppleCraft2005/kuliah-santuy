<?php 
namespace App\Models;

use CodeIgniter\Model;

class PeminjamanModel extends Model {
    protected $table = 'pinjam_ruang';
    protected $primaryKey = '$id_peminjaman';
}