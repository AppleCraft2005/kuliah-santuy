<?php 
$mhs1 = ["No"=>"1", "Nama"=>"Ridho", "Mata Kuliah diambil"=>["Pemrograman I", "Praktikum Pemrograman I", "Pengatar Lingkungan Lahan Basah", "Arsitektur Komputer"], "SKS"=>["2", "1", "2", "3"]];
$mhs2 = ["No"=>"2", "Nama"=>"Ratna", "Mata Kuliah diambil"=>["Basis Data I", "Praktikum Basis Data I", "Kalkulus"], "SKS"=>["2", "1", "3"]];
$mhs3 = ["No"=>"3", "Nama"=>"Tono", "Mata Kuliah diambil"=>["Rekayasa Perangkat Lunak", "Analisis Perancangan Sistem", "Komputasi Awan", "Kecerdasan Bisnis"], "SKS"=>["3", "3", "3", "3"]];

$Mahasiswa = [$mhs1,$mhs2,$mhs3];



foreach($Mahasiswa as $i => $Mhs) {
    $totalSKS = array_sum($Mhs["SKS"]);
    $Mahasiswa[$i]["Total SKS"] = $totalSKS;
    $Mahasiswa[$i]["Keterangan"] = cekKeterangan($totalSKS);
}

function cekKeterangan($totalSks) {
    if($totalSks > 7) {return "Tidak Revisi";}
    else{return  "Revisi"; }
}

function giveColor($data, $i) {
    if($i == 0) {
        if($data > 7) {
            return "green";
        }
        else {
            return "red";
        }
    }
    var_dump($data);
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table border='1' cellpadding='5' cellspacing='0'>
    <tr>
        <?php foreach($Mahasiswa[0] as $key => $value) : ?>
            <th><?= $key; ?></th>
        <?php endforeach; ?>
    </tr>
    
    <?php foreach($Mahasiswa as $mhs) : ?>
        <?php foreach($mhs["Mata Kuliah diambil"] as $i => $matkul) : ?>
            <tr>
                <td><?= $i == 0 ? $mhs["No"] : " " ?></td>
                <td><?= $i == 0 ? $mhs["Nama"] : " " ?></td>
                <td><?= $matkul; ?></td>
                <td><?= $mhs["SKS"][$i] ?></td>
                <td><?= $i == 0 ? $mhs["Total SKS"] : " " ?></td>
                <td style="background-color: <?= giveColor($mhs["Total SKS"], $i)?>;"><?= $i == 0 ? $mhs["Keterangan"] : " "?></td>
            </tr>
        <?php endforeach; ?>
    <?php endforeach; ?>

    </table>
</body>
</html>