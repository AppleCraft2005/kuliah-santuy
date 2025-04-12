<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="" method="post">
        <input type="text" name="nilai">
        <button type="submit" name="submit">submit</button>
    </form>

    <?php 
        if(isset($_POST["submit"])) {
            $nilai = $_POST['nilai'];

            $hasil = strlen($nilai);

            if($nilai == 0){echo "Nol";}
            else if($nilai >= 10 && $nilai <= 19){echo "Belasan";}
            else if($nilai >= 20 && $nilai <= 99){echo "Puluhan";}
            else if($hasil == 3){echo "Ratusan";}
            else if($hasil == 4){echo "Anda Menginput Melebihi Limit Bilangan";}
            else if($hasil == 1){echo "Satuan";}
        }
    ?>
</body>
</html>