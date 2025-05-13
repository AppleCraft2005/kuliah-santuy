<?php 
namespace app\Models;

class ProfilModel {
    protected $data = ['nama' => 'Jovan Gilbert Natamasindah', 'nim' => '2310817310002', 'prodi' => 'Teknologi Informasi', 'hobi' => 'Badminton, Baca Manga, Main Game', 'skill' => 'Editing Video'];

    public function getProfil() {return $this -> data;}
}
?>