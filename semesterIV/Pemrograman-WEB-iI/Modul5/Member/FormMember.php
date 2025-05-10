<?php 
    require '../Model.php';

    $Member = [
        'id_member' => '',
        'nama_member' => '',
        'nomor_member' => '',
        'alamat' => '',
    ];

    if(isset($_GET['id_member'])) {
        $idMember = $_GET['id_member'];
        $Member = getData("SELECT * FROM member WHERE id_member = $idMember")[0];
    }

    if(isset($_POST["submit"])) {
        if(isset($_GET['id_member'])) {
            editData("member", "id_member", $_GET['id_member'], $_POST);
        }
        else {
            insertData("member", $_POST);
        }
        header("Location: Member.php");
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
        <h1><?= isset($_GET['id_member']) ? 'Edit' : 'Form Tambah' ?> Member</h1>
        <form action="" method="post">
    
            <?php if(isset($_GET['id_member'])): ?>
                <input type="hidden"  name="id_member" value="<?= $Member['id_member'] ?>"> 
            <?php endif; ?>
    
            <label for="nama_member">Nama: </label>
            <input type="text" id="nama_member" name="nama_member" value="<?= $Member['nama_member'] ?>"> <br>
    
            <label for="nomor_member">Nomor: </label>
            <input type="text" id="nomor_member" name="nomor_member" value="<?= $Member['nomor_member'] ?>"> <br>
    
            <label for="alamat">alamat: </label>
            <input type="text" id="alamat" name="alamat" value="<?= $Member['alamat'] ?>"> <br>
    
            <button name="submit">Submit</button>
        </form>
    </div>
 </body>
 </html>