<?php 

namespace App\Models;

use CodeIgniter\Model;

class RuangModel extends Model {
    protected $table = 'ruangan';
    protected $primaryKey = 'id_ruangan';
    protected $allowedFields = ['nama_ruang', 'kapasitas'];
}