<?php 
namespace app\Models;

class TimModel {
    protected $data = [
        ['nama' => 'Jovan', 'posisi' => 'CEO'],
        ['nama' => 'Randy', 'posisi' => 'Manager'],
        ['nama' => 'Amay', 'posisi' => 'IT Programmer'],
    ];

    public function getAll() {
        return $this -> data;
    }
};
?>
