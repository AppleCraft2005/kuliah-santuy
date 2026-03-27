<?php 
require 'functions.php';

// ambil Id berdasarkan yang dipilih
$id = $_GET["Id"];
// query untuk ambil data berdasarkan id
$mhs = query("SELECT * FROM mahasiswa WHERE Id = $id")[0];
// cek submit btn dan kirim post ke functions.php
if(isset($_POST["submit"])) {
    if(editData($_POST) > 0) {
        echo "
            <script>
                document.location.href = 'index.php'
                alert('Data berhasil diubah');
            </script>";
    } 
    else{
        echo "
        <script>
            alert('Data gagal diubah');
        </script>";
    }
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
    <h1>Edit Data</h1>

    <a href="index.php">kembali</a>
    <form action="" method="post">
        <input type="hidden" name="Id" value="<?= $mhs["Id"] ?>">
        <ul>
            <li>
                <label for="nama">Nama: </label>
                <input type="text" name="nama" id="nama" required value="<?= $mhs["nama"] ?>">
            </li>
            <li>
                <label for="nim">NIM: </label>
                <input type="text" name="nim" id="nim" required value="<?= $mhs["nim"] ?>">
            </li>
            <li>          
                <label for="email">E-Mail: </label>
                <input type="text" name="email" id="email" required value="<?= $mhs["email"] ?>">
            </li>   
            <li>        
                <label for="jurusan">Jurusan: </label>
                <input type="text" name="jurusan" id="jurusan" required value="<?= $mhs["jurusan"] ?>">
            </li>
        </ul>

        <button type="submit" name="submit">Ubah Data</button>
    </form>
</body>
</html>