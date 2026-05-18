<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="" method="post">
        <label for="nilai">Nilai: </label>
        <input type="text" name="nilai" id="nilai"> <br>
        <button type="submit" name="submit">Konversi</button>
    </form>

    <?php 
        if(isset($_POST["submit"])) {
            $nilai = $_POST['nilai'];

            $hasil = strlen($nilai);

            if($nilai == 0){echo "<h1>Hasil: Nol</h1>";}
            else if($nilai >= 10 && $nilai <= 19){echo "<h1>Hasil: Belasan</h1>";}
            else if($nilai >= 20 && $nilai <= 99){echo "<h1>Hasil: Puluhan</h1>";}
            else if($hasil == 3){echo "<h1>Hasil: Ratusan</h1>";}
            else if($hasil == 4){echo "<h1>Hasil: Anda Menginput Melebihi Limit Bilangan</h1>";}
            else if($hasil == 1){echo "<h1>Hasil: Satuan</h1>";}
        }
    ?>
</body>
</html>