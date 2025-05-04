<?php 
require '../Model.php';
$query = getData("SELECT * FROM peminjaman");

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
            <th>Tanggal Peminjaman</th>
            <th>Tanggal Pengembalian</th>
        </tr>

        <?php foreach($query as $q): ?>
            <tr>
                <td><?= $q["id_peminjaman"] ?></td>
                <td>
                    <a href="FormPeminjaman.php?id_peminjaman=<?= $q['id_peminjaman'] ?>">Edit</a> | <a href="Peminjaman.php?id_peminjaman=<?= $q['id_peminjaman'] ?>">Hapus</a>
                </td>
                <td><?= $q["tgl_pinjam"] ?></td>
                <td><?= $q["tgl_kembali"] ?></td> 
            </tr>
        <?php endforeach; ?>
    </table>
</body>
</html>