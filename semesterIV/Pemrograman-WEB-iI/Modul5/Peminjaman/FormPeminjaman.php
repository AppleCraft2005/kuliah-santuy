<?php 
    require '../Model.php';

    $Peminjaman = [
        'nama_member' => '',
        'judul_buku' => '',
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

    $Buku = getData("SELECT * FROM buku");
    $Member = getData("SELECT * FROM member");

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
        <h1><?= isset($_GET['id_peminjaman']) ? 'Edit' : 'Form Tambah' ?> Peminjaman</h1>
        <form action="" method="post">
    
            <?php if(isset($_GET['id_peminjaman'])): ?>
                <input type="hidden"  name="id_peminjaman" value="<?= $Peminjaman['id_peminjaman'] ?> "> 
            <?php endif; ?>
            
            <label for="nama_member">Nama Member: </label>
            <select name="nama_member" id="nama_member">
                <option value="">--Pilih Member--</option>
                <?php foreach($Member as $m): ?>
                    <option value="<?= $m['id_member'] ?>" <?= ($Peminjaman['nama_member'] == $m['id_member']) ? 'selected' : '' ?>><?= $m['nama_member'] ?></option>
                <?php endforeach; ?>
            </select> <br> 
    
            <label for="nama_buku">Nama Buku: </label>
            <select name="judul_buku" id="nama_buku">
                <option value="">--Pilih buku--</option>
                <?php foreach($Buku as $b): ?>
                    <option value="<?= $b['id_buku'] ?>" <?= ($Peminjaman['judul_buku'] == $b['id_buku']) ? 'selected' : '' ?>><?= $b['judul_buku'] ?> </option>
                <?php endforeach; ?>
            </select> <br>
    
            <label for="tgl_pinjam">Tanggal Peminjaman: </label>
            <input type="date" id="tgl_pinjam" name="tgl_pinjam" value="<?= $Peminjaman['tgl_pinjam'] ?>"> <br>        
    
            <label for="tgl_kembali">Tanggal Pengembalian: </label>
            <input type="date" id="tgl_kembali" name="tgl_kembali" value="<?= $Peminjaman['tgl_kembali'] ?>"> <br>
    
            <button name="submit">Submit</button>
        </form>
    </div>
 </body>
 </html>