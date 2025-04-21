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
        <input type="text" name="linkimg" id="linkimg"> <br>

        <button type="submit" name="cetak">Cetak</button> <br><br>
    </form>
    
    <?php 
    if(isset($_POST['cetak'])) {
        $tinggi = $_POST['tinggi'];
        $linkimg = $_POST['linkimg'];
        $i=0;
        while ($i < $tinggi) {
            $j=0;
            while($j < $i) {
                echo "&nbsp &nbsp &nbsp";
                $j++;
            }
            $j=0;
            while ( $j < $tinggi - $i) {
                echo "<img src='$linkimg' width=20 alt=''>";
                $j++;
            }
        $i++;
        echo " </br>";
        }
    }
    ?>
</body>
</html>