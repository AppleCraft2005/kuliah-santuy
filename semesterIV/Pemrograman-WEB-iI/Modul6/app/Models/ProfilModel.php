<?php 
namespace app\Models;

class ProfilModel {
    protected $data = ['nama' => 'Jovan Gilbert Natamasindah', 'nim' => '2310817310002', 'prodi' => 'Teknologi Informasi', 'hobi' => 'main game', 'skill' => 'bisa ngoding dikit'];

    public function getProfil() {return $this -> data;}
}
?>