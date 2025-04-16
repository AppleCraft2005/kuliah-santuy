<?php 
require 'functions.php';
$query = query("SELECT * FROM pinjam_ruang");
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>list peminjaman ruangan</h1>
    <table border="1" cellpadding="10">
        <tr>
            <th>No.</th>
            <th>Nama Dosen</th>
            <th>Mata Kuliah</th>
            <th>waktu Mulai</th>
            <th>Waktu Selesai</th>
            <th>Ruangan</th>
            <th>Sarana</th>
        </tr>

        <?php foreach($query as $q): ?>
            <tr>
                <td><?= $q['id']; ?></td>
                <td><?= $q['nama_dosen']; ?></td>
                <td><?= $q['nama_matkul']; ?></td>
                <td><?= $q['mulai']; ?></td>
                <td><?= $q['selesai']; ?></td>
                <td><?= $q['ruangan']; ?></td>
                <td><?= $q['sarana']; ?></td>
            </tr>
        <?php endforeach; ?>

    </table>
</body>
</html>