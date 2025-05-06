<?php 
session_start();

if(isset($_POST['reset'])) {session_destroy();}


if(!isset($_SESSION['inputCount'])) {
    $_SESSION['inputCount'] = 1;
}

if(isset($_POST['tambah'])) {$_SESSION['inputCount']++;}

if(isset($_POST['hapus'])) {$_SESSION['inputCount']--;}

if(isset($_POST['submit'])) {
    $Namalist = $_POST['nama'];
    $Gambarlist = $_FILES['gambar'];

    if (!isset($_SESSION['data'])) {
        $_SESSION['data'] = [];
    }

    for($i = 0; $i < count($Namalist); $i++) {
        $Nama = $Namalist[$i];
        $Gambar = $Gambarlist['name'][$i];
        $Gambartmp = $Gambarlist['tmp_name'][$i];

        $folderGambar = "img/". $Gambar;
        move_uploaded_file($Gambartmp, $folderGambar);

        $_SESSION['data'][] = ['Nama' => $Nama, 'Gambar' => $folderGambar];

    }
    $_SESSION['inputCount'] = 1;
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
    <h1>Form Dinamis: Nama & Gambar</h1>

    <form action="" method="post" enctype="multipart/form-data">

        <?php for($i = 0; $i < $_SESSION['inputCount']; $i++): ?>
        <div style="display: flex; gap: 20px;">
            <div>
                <label for="nama">Nama: </label> <br>
                <input type="text" id="nama" name="nama[]" required> <br>
            </div>
    
            <div>
                <label for="gambar">Gambar: </label> <br> 
                <input type="file" id="gambar" name="gambar[]" accept="image/jpg,image/png" required> <br>
            </div>
            <?php if($_SESSION['inputCount'] > 1): ?>
                <button name="hapus" formnovalidate>Hapus</button>
            <?php endif; ?>
        </div>
        <?php endfor; ?>

        <br>

        <button name="tambah" formnovalidate>Tambah input</button> <br> <br>
        <button name="submit">Submit</button> <br><br>
        <button name="reset" formnovalidate>Reset Data</button>
    </form>

    <br>

    <a href="TabelData.php">Lihat Tabel Data</a>
</body>
</html>