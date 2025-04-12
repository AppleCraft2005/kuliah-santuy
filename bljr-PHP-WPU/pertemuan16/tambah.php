<?php 
session_start();
//cek session
if(!isset($_SESSION['login'])) {
    header("Location: login.php");
    exit;
}
require 'functions.php';

// cek submit btn dan kirim post ke functions.php
if(isset($_POST["submit"])) {
    if(insertData($_POST) > 0) {
        echo "
            <script>
                document.location.href = 'index.php'
                alert('Data berhasil ditambahkan');
            </script>";
    } 
    else{
        echo "
        <script>
            alert('Data gagal ditambahkan');
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
    <h1>Tambah Data</h1>

    <a href="index.php">kembali</a>
    <form action="" method="post" enctype="multipart/form-data">
        <ul>
            <li>
                <label for="nama">Nama: </label>
                <input type="text" name="nama" id="nama" required>
            </li>
            <li>
                <label for="nim">NIM: </label>
                <input type="text" name="nim" id="nim" required>
            </li>
            <li>          
                <label for="email">E-Mail: </label>
                <input type="text" name="email" id="email" required>
            </li>   
            <li>        
                <label for="jurusan">Jurusan: </label>
                <input type="text" name="jurusan" id="jurusan" required>
            </li>
            <li>
                <label for="gambar">Upload Gambar: </label>
                <input type="file" name="gambar" id="gambar">
            </li>
        </ul>

        <button type="submit" name="submit">Kirim Data</button>
    </form>
</body>
</html>