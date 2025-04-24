<?php 
$mhs1 = ["No"=>"1", "Nama"=>"Ridho", "Mata Kuliah diambil"=>["Pemrograman I", "Praktikum Pemrograman I", "Pengatar Lingkungan Lahan Basah", "Arsitektur Komputer"], "SKS"=>["2", "1", "2", "3"]];



function cekKeterangan($totalSks) {
    if($totalSks > 7) {return "Tidak Revisi";}
    else{return  "Revisi";}
}

$jumlahMatkul = count($mhs1["Mata Kuliah diambil"]);

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
        <?php foreach($mhs1 as $key => $value) : ?>
            <th><?= $key; ?></th>
        <?php endforeach; ?>
    </tr>
    
    <?php foreach($mhs1["Mata Kuliah diambil"] as $i => $matkul) : ?>
        <tr>
            <?php if($i == 0) :?>
                <td rowspan="$jumlahMatkul"><?php $mhs1["No"] ?></td>
                <td rowspan="$jumlahMatkul"><?php $mhs1["Nama"] ?></td>
            <?php endif; ?>
            <td><?= $matkul; ?></td>
            <td><?= $mhs1["SKS"][$i]; ?></td>
            <?php if($i == 0) :?>
                <td rowspan="$jumlahMatkul"><?php $mhs1["Total SKS"] = array_sum($mhs1["SKS"]);?></td>
                <td rowspan="$jumlahMatkul"><?php $mhs1["Keterangan"] =  cekKeterangan($mhs1["Total SKS"]);?></td>
            <?php endif; ?>
        </tr>
    <?php endforeach; ?>
    </table>
</body>
</html>