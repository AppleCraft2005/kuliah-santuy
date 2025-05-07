<?php 
require '../Model.php';
$query = getData("SELECT * FROM peminjaman p JOIN member m ON m.id_member = p.nama_member JOIN buku b ON p.judul_buku = b.id_buku");

// untuk hapus member
if(isset($_GET['id_peminjaman'])) {
    deleteData("peminjaman", "id_peminjaman", $_GET['id_peminjaman']);
    header("Location: Peminjaman.php");
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
    <h1>Halaman Peminjaman</h1>
    <a href="FormPeminjaman.php">Tambah Peminjaman</a>

    <table border="1" cellspacing="0" cellpadding="5">
        <tr>
            <th>ID Peminjaman</th>
            <th>Aksi</th>
            <th>Nama Peminjam</th>
            <th>Judul Buku</th>
            <th>Tanggal Peminjaman</th>
            <th>Tanggal Pengembalian</th>
        </tr>

        <?php foreach($query as $q): ?>
            <tr>
                <td><?= $q["id_peminjaman"] ?></td>
                <td>
                    <a href="FormPeminjaman.php?id_peminjaman=<?= $q['id_peminjaman'] ?>">Edit</a> | <a href="Peminjaman.php?id_peminjaman=<?= $q['id_peminjaman'] ?>">Hapus</a>
                </td>
                <td><?= $q["nama_member"] ?></td>
                <td><?= $q["judul_buku"] ?></td>
                <td><?= $q["tgl_pinjam"] ?></td>
                <td><?= $q["tgl_kembali"] ?></td> 
            </tr>
        <?php endforeach; ?>
    </table>
</body>
</html>