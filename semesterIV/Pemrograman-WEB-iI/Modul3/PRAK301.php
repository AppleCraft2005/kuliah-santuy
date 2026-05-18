<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="" method="post">
        <label for="nilai">Jumlah Peserta : </label>
        <input type="text" name="nilai" id="nilai"> <br>
        <button type="submit" name="cetak">cetak</button>
    </form>

    <?php 
    if(isset($_POST['cetak'])) {
        $nilai = $_POST['nilai'];
        $i = 1;
        while($i < $nilai + 1) {
            if($i % 2 == 0) {echo "<h2 style='color:green'>Peserta ke-$i</h2>"; }
            elseif($i % 2 == 1) {echo "<h2 style='color:red'>Peserta ke-$i</h2>"; }
            $i++;
        } 
    }
    ?>
</body>
</html>