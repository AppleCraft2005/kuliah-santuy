<?php
$jumlah = 0;

    if (isset($_POST['jumlah'])) {
        $jumlah = $_POST['jumlah'];
    }

    if (isset($_POST['tambah'])) {
        $jumlah++;
    }

    if (isset($_POST['kurang'])) {
        $jumlah--;
        if ($jumlah < 0) $jumlah = 0; 
    }

    if (isset($_POST['submit'])) {
        $jumlah_input = $_POST['jumlah_input'];
        $jumlah = $jumlah_input;
        
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
    <form action="" method="post">
        <input type="hidden" name="jumlah" value="<?php echo $jumlah; ?>">

        <label for="jumlah_input">Jumlah bintang </label> 
        <input type="text" name="jumlah_input" id="jumlah_input" value="<?php echo $jumlah; ?>"> <br>

        <button type="submit" name="submit">Submit</button> <br><br>

        <?php for ($i = 0; $i < $jumlah; $i++): ?>
            <img src='img/star-images-9441.png' width=80 alt=''>
        <?php endfor; ?>

        <br><br>

        <button type='submit' name='tambah'>Tambah</button>
        <button type='submit' name='kurang'>Kurang</button>
    </form>



</body>
</html>