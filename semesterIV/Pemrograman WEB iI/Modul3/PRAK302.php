<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="" method="post">
        <label for="tinggi">Tinggi : </label> 
        <input type="text" name="tinggi" id="tinggi"> <br>

        <label for="linkimg">Alamat Gambar : </label> 
        <input type="text" name="linkimg" id="linkimg">

        <button type="submit" name="cetak">Cetak</button>
    </form>
    
    <?php 
    if(isset($_POST['cetak'])) {
        $tinggi = $_POST['tinggi'];
        $linkimg = $_POST['linkimg'];
        $i=1;
        while ($i <= 2) {
            $j=$i;
            while ( $j<= 3) {
                $j++;
                echo "*";
            }
        $i++;
        echo " </br>";
        }
    }
    ?>
</body>
</html>