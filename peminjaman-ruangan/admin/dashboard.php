<?php 
session_start();
//cek session (sudah login atau belum)
if(!isset($_SESSION['login'])) {
    header("Location: ../src/login.php");
    exit;
}
$usernameLogin = $_SESSION['username'];
require '../src/functions.php';

$ruang = query("SELECT * FROM ruangan");

$where = [];
if (!empty($_GET['ruangan'])) {
    $ruangan = $_GET['ruangan'];
    $where[] = "pr.id_ruangan = '$ruangan'";
}

if (!empty($_GET['hari'])) {
    $hari = $_GET['hari']; 
    $where[] = "DAYNAME(pr.mulai) = '$hari'";
}

$filterSql = '';
if (!empty($where)) {
    $filterSql = 'WHERE ' . implode(' AND ', $where);
}
$query = query("SELECT * FROM pinjam_ruang pr JOIN ruangan r ON pr.id_ruangan = r.id_ruangan JOIN dosen d ON pr.nama_dosen = d.id_dosen JOIN mata_kuliah m ON pr.nama_matkul = m.id_matkul $filterSql");
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>list peminjaman ruangan (admin)</h1>

    <h2>Haloo, selamat datang <?= $usernameLogin; ?></h2>
    <?php if(!isset($_SESSION['login'])): ?>
        <a href="../src/login.php">Pinjam Ruang</a>
    <?php else: ?>
        <a href="../src/formpinjamedit.php">Pinjam Ruang</a>
    <?php endif; ?>

    <?php include '../comp/searchBar.php' ?>
    
    <table border="1" cellpadding="10">
        <tr>
            <th>No.</th>
            <th>Aksi</th>
            <th>Nama Peminjam</th>
            <th>Nama Dosen</th>
            <th>Mata Kuliah</th>
            <th>waktu Mulai</th>
            <th>Waktu Selesai</th>
            <th>Ruangan</th>
            <th>Sarana</th>
            <th>Status Peminjaman</th>
            <th>Komentar</th>
        </tr>

        <?php foreach($query as $q): ?>
            <tr>
                <td><?= $q['id_peminjaman']; ?></td>
                <td>
                    <a href="../src/formpinjamedit.php?id_peminjaman=<?=$q['id_peminjaman'];?>">Edit</a> | <a href="../src/hapus.php?id_peminjaman=<?= $q['id_peminjaman'] ?>;" onclick="return confirm('Yakin ingin menghapus peminjaman?')">Hapus</a>
                </td>
                <td><?= $q['nama_peminjam']; ?></td>
                <td><?= $q['nama_dosen']; ?></td>
                <td><?= $q['nama_matkul']; ?></td>
                <td><?= $q['mulai']; ?></td>
                <td><?= $q['selesai']; ?></td>
                <td><?= $q['nama_ruang']; ?></td> <!--dari db ruangan--> 
                <td><?= $q['sarana']; ?></td>
                <td><?= $q['status_peminjaman']; ?></td>
                <td><?= $q['komentar']; ?></td>
            </tr>
        <?php endforeach; ?>

    </table>
    <a href="../src/logout.php">Log Out</a>
</body>
</html>