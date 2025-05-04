<?php 
require '../Model.php';
$query = getData("SELECT * FROM member");

// untuk hapus member
if(isset($_GET['id_member'])) {
    deleteData("member", "id_member",$_GET['id_member']);
    header("Location: Member.php");
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
    <h1>Halaman Member</h1>
    <a href="FormMember.php">Tambah Member</a>

    <table border="1" cellspacing="0" cellpadding="5">
        <tr>
            <th>ID Member</th>
            <th>Aksi</th>
            <th>Nama Member</th>
            <th>Nomor Member</th>
            <th>Alamat</th>
            <th>Tanggal Mendaftar</th>
            <th>Tanggal Terakhir Bayar</th>
        </tr>

        <?php foreach($query as $q): ?>
            <tr>
                <td><?= $q["id_member"] ?></td>
                <td>
                    <a href="FormMember.php?id_member=<?= $q['id_member'] ?>">Edit</a> | <a href="Member.php?id_member=<?= $q['id_member'] ?>">Hapus</a>
                </td>
                <td><?= $q["nama_member"] ?></td>
                <td><?= $q["nomor_member"] ?></td>
                <td><?= $q["alamat"] ?></td>
                <td><?= $q["tgl_mendaftar"] ?></td>
                <td><?= $q["tgl_terakhir_bayar"] ?></td> 
            </tr>
        <?php endforeach; ?>
    </table>
</body>
</html>