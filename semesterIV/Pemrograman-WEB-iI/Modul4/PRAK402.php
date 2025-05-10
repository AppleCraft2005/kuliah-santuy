<?php 
    $mhs1 = ["Nama"=>"Andi", "NIM"=>"2101001", "Nilai UTS"=>"87", "Nilai UAS"=>"65"];
    $mhs2 = ["Nama"=>"Budi", "NIM"=>"2101002", "Nilai UTS"=>"76", "Nilai UAS"=>"79"];
    $mhs3 = ["Nama"=>"Tono", "NIM"=>"2101003", "Nilai UTS"=>"50", "Nilai UAS"=>"41"];
    $mhs4 = ["Nama"=>"Jessica", "NIM"=>"2101004", "Nilai UTS"=>"60", "Nilai UAS"=>"75"];

    $Mahasiswa = [$mhs1, $mhs2, $mhs3, $mhs4];
    
    foreach($Mahasiswa as $i => $mhs) {
        $Mahasiswa[$i]["Nilai Akhir"] = $mhs["Nilai UTS"]*40/100 + $mhs["Nilai UAS"]*60/100;
        $Mahasiswa[$i]["Huruf"] = cekHuruf($Mahasiswa[$i]["Nilai Akhir"]);
    }

    function cekHuruf($nilai) {
        if($nilai >= 80) {return "A";}
        elseif($nilai >= 70 && $nilai <= 79) {return "B";}
        elseif($nilai >= 60 && $nilai <= 69) {return "C";}
        elseif($nilai >= 50 && $nilai <= 59) {return "D";}
        elseif($nilai <= 50) {return "E";}
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
            <?php foreach($Mahasiswa[1] as $key => $value) {echo "<th style='background-color: lightgray'>$key </th>";} ?>
        </tr>

        <?php foreach($Mahasiswa as $mhs ) : ?>
            <tr>
                <?php foreach($mhs as $key => $value) :?>
                    <td><?= $value; ?></td>
                <?php endforeach; ?>
            </tr>
        <?php endforeach; ?>
    </table>
</body>
</html>