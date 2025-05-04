<?php 
require '../Model.php';
$query = getData("SELECT * FROM buku");

// untuk hapus member
if(isset($_GET['id_buku'])) {
    deleteData("buku", "id_buku", $_GET['id_buku']);
    header("Location: Buku.php");
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
    <h1>Halaman Buku</h1>
    <a href="FormBuku.php">Tambah Buku</a>

    <table border="1" cellspacing="0" cellpadding="5">
        <tr>
            <th>ID Buku</th>
            <th>Aksi</th>
            <th>Judul Buku</th>
            <th>Penulis</th>
            <th>Penerbit</th>
            <th>Tahun Terbit</th>
        </tr>

        <?php foreach($query as $q): ?>
            <tr>
                <td><?= $q["id_buku"] ?></td>
                <td>
                    <a href="FormBuku.php?id_buku=<?= $q['id_buku'] ?>">Edit</a> | <a href="Buku.php?id_buku=<?= $q['id_buku'] ?>">Hapus</a>
                </td>
                <td><?= $q["judul_buku"] ?></td>
                <td><?= $q["penulis"] ?></td>
                <td><?= $q["penerbit"] ?></td>
                <td><?= $q["tahun_terbit"] ?></td> 
            </tr>
        <?php endforeach; ?>
    </table>
</body>
</html>