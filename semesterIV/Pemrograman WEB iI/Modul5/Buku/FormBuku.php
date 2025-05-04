<?php 
    require '../Model.php';

    $Buku = [
        'id_buku' => '',
        'judul_buku' => '',
        'penulis' => '',
        'penerbit' => '',
        'tahun_terbit' => ''
    ];

    if(isset($_GET['id_buku'])) {
        $idBuku = $_GET['id_buku'];
        $Buku = getData("SELECT * FROM buku WHERE id_buku = $idBuku")[0];
    }

    if(isset($_POST["submit"])) {
        if(isset($_GET['id_buku'])) {
            editData("buku", "id_buku", $_GET['id_buku'], $_POST);
        }
        else {
            insertData("buku", $_POST);
        }
        header("Location: buku.php");
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
    <h1><?= isset($_GET['id_buku']) ? 'Edit' : 'Form Tambah' ?> Buku</h1>
    <form action="" method="post">

        <?php if(isset($_GET['id_buku'])): ?>
            <input type="hidden"  name="id_buku" value="<?= $Buku['id_buku'] ?>"> 
        <?php endif; ?>

        <label for="judul_buku">Judul Buku: </label>
        <input type="text" id="judul_buku" name="judul_buku" value="<?= $Buku['judul_buku'] ?>"> <br>

        <label for="penulis">Penulis: </label>
        <input type="text" id="penulis" name="penulis" value="<?= $Buku['penulis'] ?>"> <br>

        <label for="penerbit">Penerbit: </label>
        <input type="text" id="penerbit" name="penerbit" value="<?= $Buku['penerbit'] ?>"> <br>

        <label for="tahun_terbit">Tahun Terbit: </label>
        <input type="text" id="tahun_terbit" name="tahun_terbit" value="<?= $Buku['tahun_terbit'] ?>"> <br>

        <button name="submit">Submit</button>
    </form>
 </body>
 </html>