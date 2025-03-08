<?php 
    $Jari_jari = 4.2;
    $Tinggi = 5.4;
    $Panjang = 8.9;
    $Lebar = 14.7;
    $Sisi = 7.9;

    $NIM = 2310817310002;
    $AkhirNIM = $NIM % 10;
    // switch ($NIM % 10) {
    //     case 0:
    //         $Tabung = round(pi() * pow($Jari_jari,2) * $Tinggi, 3); 
    //         echo "$Tabung m3";
    //         break;
    //     case 1:
    //         $Tabung = round(pi() * pow($Jari_jari,2) * $Tinggi, 3); 
    //         echo "$Tabung m3";
    //         break;
    //     case 2:
    //         # code...
    //         break;
    //     case 3:
    //         # code...
    //         break;
    //     case 4:
    //         # code...
    //         break;
    //     case 5:
    //         # code...
    //         break;
    //     case 6:
    //         # code...
    //         break;
    //     case 7:
    //         # code...
    //         break; 
    //     case 8:
    //         # code...
    //         break;
    //     case 9:
    //         # code...
    //         break;              
    //     default:
    //         # code...
    //         break;
    // }

    if($AkhirNIM == 0 or $AkhirNIM == 1) {
        $Tabung = round(pi() * pow($Jari_jari,2) * $Tinggi, 3); 
        echo "$Tabung m3";    
    }
    elseif ($AkhirNIM == 2 or $AkhirNIM == 3) {
        $Kerucut = round(1/3 * pi() * pow($Jari_jari,2) * $Tinggi, 3); 
        echo "$Kerucut m3";   
    }
    elseif ($AkhirNIM == 4 or $AkhirNIM == 5) {
        $Bola = round(4/3 * pi() * pow($Jari_jari,3), 3); 
        echo "$Bola m3";   
    }
    elseif ($AkhirNIM == 6 or $AkhirNIM == 7) {
        $PrismaSegitiga = round((1/2 * $Panjang * $Tinggi) * $Tinggi, 3); 
        echo "$PrismaSegitiga m3";   
    }
    elseif ($AkhirNIM == 8 or $AkhirNIM == 9) {
        $LimasPPanjang = round(1/3 * ($Panjang * $Lebar) * $Tinggi, 3); 
        echo "$LimasPPanjang m3";   
    }
?>