<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="" method="post">
        <label for="bawah">Batas Bawah : </label> 
        <input type="text" name="bawah" id="bawah"> <br>

        <label for="atas">Batas Atas : </label> 
        <input type="text" name="atas" id="atas"> <br>

        <button type="submit" name="cetak">Cetak</button> <br><br>
    </form>
</body>

<?php 
    if(isset($_POST['cetak'])) {
        $atas = $_POST['atas'];
        $bawah = $_POST['bawah'];

        do{
            if(($bawah + 7) % 5 === 0) {echo "<img src='img/star-images-9441.png' width=20 alt=''>";}
            else{echo "$bawah ";}
            $bawah++;
        }while($bawah <= $atas);
    }
?>
</html>