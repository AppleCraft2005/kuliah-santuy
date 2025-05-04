<?php 
    require '../Model.php';

    $Peminjaman = [
        'id_peminjaman' => '',
        'tgl_pinjam' => '',
        'tgl_kembali' => '',
    ];

    if(isset($_GET['id_peminjaman'])) {
        $idPeminjaman = $_GET['id_peminjaman'];
        $Peminjaman = getData("SELECT * FROM peminjaman WHERE id_peminjaman = $idPeminjaman")[0];
    }

    if(isset($_POST["submit"])) {
        if(isset($_GET['id_peminjaman'])) {
            editData("peminjaman", "id_peminjaman", $_GET['id_peminjaman'], $_POST);
        }
        else {
            insertData("peminjaman", $_POST);
        }
        header("Location: peminjaman.php");
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
    <h1><?= isset($_GET['id_peminjaman']) ? 'Edit' : 'Form Tambah' ?> Peminjaman</h1>
    <form action="" method="post">

        <?php if(isset($_GET['id_peminjaman'])): ?>
            <input type="hidden"  name="id_peminjaman" value="<?= $Peminjaman['id_peminjaman'] ?>"> 
        <?php endif; ?>

        <label for="tgl_pinjam">Tanggal Peminjaman: </label>
        <input type="date" id="tgl_pinjam" name="tgl_pinjam" value="<?= $Peminjaman['tgl_pinjam'] ?>"> <br>

        <label for="tgl_kembali">Tanggal Pengembalian: </label>
        <input type="date" id="tgl_kembali" name="tgl_kembali" value="<?= $Peminjaman['tgl_kembali'] ?>"> <br>

        <button name="submit">Submit</button>
    </form>
 </body>
 </html>