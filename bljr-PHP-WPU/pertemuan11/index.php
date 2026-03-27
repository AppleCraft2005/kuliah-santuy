<?php 
require 'functions.php';
$query = query("SELECT * FROM mahasiswa");
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Daftar Mahasiswa</h1>

    <a href="tambah.php">Tambah Data</a>

    <table border="1" cellpadding="10"  >
        <tr>
            <th>No.</th>
            <th>Aksi</th>
            <th>Nama</th>
            <th>NIM</th>
            <th>Email</th>
            <th>Jurusan</th>
        </tr>

        <?php $no = 1; ?>
        <?php foreach($query as $mhs): ?>
        <tr>
            <td><?php echo $no ?></td>
            <td>
                <a href="edit.php?Id=<?=$mhs["Id"]?>;">Edit</a> | <a href="hapus.php?Id=<?=$mhs["Id"]?>;" onclick="return confirm('Yakin ingin menghapus data?');">Hapus</a> 
            </td>
            <td><?php echo $mhs["nama"] ?></td>
            <td><?php echo $mhs["nim"] ?></td>
            <td><?php echo $mhs["email"] ?></td>
            <td><?php echo $mhs["jurusan"] ?></td>
        </tr>
        <?php $no++; ?>
        <?php endforeach ?>
    </table>
</body>
</html>