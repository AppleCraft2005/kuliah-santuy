<?php 
    $mahasiswa1 = ["Nama"=>"Andi", "NIM"=>"2101001", "Nilai UTS"=>"87", "Nilai UAS"=>"65"];
    $mahasiswa2 = ["Nama"=>"Budi", "NIM"=>"2101002", "Nilai UTS"=>"76", "Nilai UAS"=>"79"];
    $mahasiswa3 = ["Nama"=>"Tono", "NIM"=>"2101003", "Nilai UTS"=>"50", "Nilai UAS"=>"41"];
    $mahasiswa4 = ["Nama"=>"Jessica", "NIM"=>"2101004", "Nilai UTS"=>"60", "Nilai UAS"=>"75"];

    $mahasiswa1["Nilai Akhir"] = $mahasiswa1["Nilai UTS"]*40/100 + $mahasiswa1["Nilai UAS"]*60/100;
    $mahasiswa1["Huruf"] = cekHuruf($mahasiswa1["Nilai Akhir"]);

    $mahasiswa2["Nilai Akhir"] = $mahasiswa2["Nilai UTS"]*40/100 + $mahasiswa2["Nilai UAS"]*60/100;
    $mahasiswa2["Huruf"] = cekHuruf($mahasiswa2["Nilai Akhir"]);

    $mahasiswa3["Nilai Akhir"] = $mahasiswa3["Nilai UTS"]*40/100 + $mahasiswa3["Nilai UAS"]*60/100;
    $mahasiswa3["Huruf"] = cekHuruf($mahasiswa3["Nilai Akhir"]);

    $mahasiswa4["Nilai Akhir"] = $mahasiswa4["Nilai UTS"]*40/100 + $mahasiswa4["Nilai UAS"]*60/100;
    $mahasiswa4["Huruf"] = cekHuruf($mahasiswa4["Nilai Akhir"]);

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
        <tr><?php foreach($mahasiswa1 as $key => $value) {echo "<th style='background-color: lightgray'>$key </th>";} ?></tr>
        <tr><?php foreach($mahasiswa1 as $key => $value) {echo "<td>$value </td>";} ?></tr>
        <tr><?php foreach($mahasiswa2 as $key => $value) {echo "<td>$value </td>";} ?></tr>
        <tr><?php foreach($mahasiswa3 as $key => $value) {echo "<td>$value </td>";} ?></tr>
        <tr><?php foreach($mahasiswa4 as $key => $value) {echo "<td>$value </td>";} ?></tr>
    </table>
</body>
</html>