<?php 
    $errNama = $errNim = $errJk = $nama = $nim = $jk = " ";

        if(isset($_POST['submit'])) {
            $nama = $_POST['nama'];
            $nim = $_POST['nim'];
            $jk = isset($_POST['jk']) ? $_POST['jk'] : "";

            if(empty($nama)) {$errNama = "nama tidak boleh kosong";}
            if(empty($nim)) {$errNim = "nim tidak boleh kosong";}
            if(empty($jk)) {$errJk = "jenis kelamin tidak boleh kosong";}
        }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .asterisk::after {
            content: " *";
            color: red;
        }
        .error {color: red;}
    </style>
</head>
<body>
    <form action="" method="post">
        <label for="nama" >Nama: </label>
        <span class="asterisk"> 
            <input type="text" id="nama" name="nama">  
        </span>
        <?php if($errNama) :?><span class="error"><?= $errNama; ?></span><?php endif; ?> <br>

        <label for="nim" >Nim: </label>
        <span class="asterisk"> 
            <input type="text" id="nim" name="nim"> 
        </span> 
        <?php if($errNim) :?><span class="error"><?= $errNim; ?></span><?php endif; ?> <br>

        <label class="asterisk" >Jenis Kelamin: </label> 
        <?php if($errJk) :?><span class="error"><?= $errJk; ?></span><?php endif; ?> <br>
        
        <input type="radio" id="laki" name="jk" value="Laki-Laki"> 
        <label for="laki">Laki-Laki </label>  <br>
        <input type="radio" id="perempuan" name="jk" value="Perempuan"> 
        <label for="perempuan">Perempuan </label> <br>

        <button type="submit" name="submit">Submit</button>
    </form>
    
    <?php if(isset($_POST['submit']) && !empty($nama) && !empty($nim) && !empty($jk)) : ?>
        <h2>Output: </h2>
        <span><?= $nama; ?></span> <br>
        <span><?= $nim; ?></span> <br>
        <span><?= $jk; ?></span>
    <?php endif; ?>
</body>
</html>