<?php 
namespace app\Models;

class HomeModel {
    protected $data = ['nama' => 'Jovan Gilbert Natamasindah', 'nim' => '2310817310002'];

    public function getPraktikan() {return $this -> data;}
}
?>