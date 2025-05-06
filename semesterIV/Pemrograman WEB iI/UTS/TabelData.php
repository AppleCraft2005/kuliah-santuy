<?php 
// require 'Function.php';
// $Data = getData("SELECT * FROM user")
session_start();

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Data yang Disimpan</h1>
    <?php if(!empty($_SESSION['data'])): ?>
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th>No</th>
                <th>Nama</th>
                <th>Gambar</th>
            </tr>
            <?php $No = 1 ?>
            <?php foreach($_SESSION['data'] as $item): ?>
                <tr>
                    <td><?= $No++; ?></td>
                    <td><?= $item['Nama']; ?></td>
                    <td><img src="<?= $item['Gambar'] ?>" alt="" width="200"></td>
                </tr>
            <?php endforeach; ?>
        </table>
    <?php else: ?>
        <p>Belum ada Data</p>
    <?php endif; ?>
    
    <a href="FormInput.php">Kembali ke Form</a>
</body>
</html>