<?php 
session_start();
require 'src/functions.php';
$query = query("SELECT * FROM pinjam_ruang pr JOIN ruangan r ON pr.id_ruangan = r.id_ruangan JOIN dosen d ON pr.nama_dosen = d.id_dosen JOIN mata_kuliah m ON pr.nama_matkul = m.id_matkul");
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

    <?php if(!isset($_SESSION['login'])): ?>
        <a href="src/login.php">Pinjam Ruang</a>
    <?php else: ?>
        <a href="src/form-peminjaman.php">Pinjam Ruang</a>
    <?php endif; ?>
    
    <table border="1" cellpadding="10">
        <tr>
            <th>No.</th>
            <th>Nama Peminjam</th>
            <th>Nama Dosen</th>
            <th>Mata Kuliah</th>
            <th>waktu Mulai</th>
            <th>Waktu Selesai</th>
            <th>Ruangan</th>
            <th>Sarana</th>
        </tr>

        <?php foreach($query as $q): ?>
            <tr>
                <td><?= $q['id_peminjaman']; ?></td>
                <td><?= $q['nama_peminjam']; ?></td>
                <td><?= $q['nama_dosen']; ?></td>
                <td><?= $q['nama_matkul']; ?></td>
                <td><?= $q['mulai']; ?></td>
                <td><?= $q['selesai']; ?></td>
                <td><?= $q['nama_ruang']; ?></td> <!--dari db ruangan--> 
                <td><?= $q['sarana']; ?></td>
            </tr>
        <?php endforeach; ?>

    </table>
    <a href="src/logout.php">Log Out</a>
</body>
</html>