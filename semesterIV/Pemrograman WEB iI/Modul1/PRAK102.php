<?php 
    $Jari_jari = 4.2;
    $Tinggi = 5.4;
    $Panjang = 8.9;
    $Lebar = 14.7;
    $Sisi = 7.9;

    $NIM = 2310817310002;
    $AkhirNIM = $NIM % 10;

    $Kerucut = round(1/3 * pi() * pow($Jari_jari,2) * $Tinggi, 3); 
    echo "$Kerucut m3";   
?>