<?php 

namespace App\Models;

use CodeIgniter\Model;

class UserModel extends Model {
    protected $table = 'users';
    protected $primaryKey = 'id_pengguna';
    protected $allowedFields = ['username', 'password', 'email', 'nomor_telepon', 'role', 'token', 'token_exp'];
}