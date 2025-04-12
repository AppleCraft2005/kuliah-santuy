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
    </style>
</head>
<body>
    <form action="" method="post">
        <label for="nama" >Nama: </label>
        <span class="asterisk"> 
            <input type="text" id="nama" name="nama" required>  
        </span> <br>

        <label for="nim" >Nim: </label>
        <span class="asterisk"> 
            <input type="text" id="nim" name="nim"  required> 
        </span> <br>

        <label class="asterisk" >Jenis Kelamin: </label> <br>
        <input type="radio" id="laki" name="jk" value="Laki-Laki" required> 
        <label for="laki">Laki-Laki </label>  <br>
        <input type="radio" id="perempuan" name="jk" value="Perempuan" required> 
        <label for="perempuan">Perempuan </label> <br>

        <button type="submit" name="submit">Submit</button>
    </form>

    <?php 
        if(isset($_POST['submit'])) {

            echo "<h2>Output: </h2>";

            $arr = [$_POST['nama'], $_POST['nim'], $_POST['jk']];

            foreach($arr as $a) {echo "$a <br>";}
            

        }
    ?>

</body>
</html>