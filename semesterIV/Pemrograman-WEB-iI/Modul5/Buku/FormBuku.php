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
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f4f6;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            background-color: #ffffff;
            padding: 30px 40px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            width: 100%;
            max-width: 400px;
        }

        h1 {
            text-align: center;
            margin-bottom: 24px;
            color: #2c3e50;
        }

        label {
            display: block;
            margin-bottom: 6px;
            color: #555;
        }

        input,
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        button {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
 </head>
 <body>
    <div class="form-container">
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
    </div>
 </body>
 </html>