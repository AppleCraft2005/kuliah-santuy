<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<form action="" method="POST">
        <label for="nilai">Nilai: </label>
        <input type="text" id="nilai" name="nilai"> <br>

        <label for="dari">Dari: </label> <br>
        <?php 
            $suhu = ['Celcius','Fahrenheit', 'Rheamur', 'Kelvin'];
            foreach($suhu as $s) {
                echo "
                    <input type='radio'  name='satuan0' value='$s' required> 
                    <label for='$s'>$s </label> <br>";
            }
        ?>

        <label for="dari">Ke: </label> <br>
        <?php 
            foreach($suhu as $s) {
                echo "
                    <input type='radio'  name='satuan1' value='$s' required> 
                    <label for='$s'>$s </label> <br>";
            }
        ?>
        <button type="submit" name="submit">Urutkan</button>
    </form>

    <?php 
        if(isset($_POST['submit'])) {
            $nilai = $_POST['nilai'];
            $asal = $_POST['satuan0'];
            $tujuan = $_POST['satuan1'];
            
            if($asal == "Celcius" && $tujuan == "Fahrenheit") {$hasil = 9/5 * $nilai + 32; echo "<h2>Hasil Konversi $hasil °F</h2>";}
            else if($asal == "Celcius" && $tujuan == "Rheamur") {$hasil = 4/5 * $nilai; echo "<h2>Hasil Konversi $hasil °R</h2>"; }
            else if($asal == "Celcius" && $tujuan == "Kelvin") {$hasil = 273.15 + $nilai; echo "<h2>Hasil Konversi $hasil °K</h2>"; }

            else if($asal == "Fahrenheit" && $tujuan == "Celcius") {$hasil = 5/9 * ($nilai - 32); echo "<h2>Hasil Konversi $hasil °C</h2>";}
            else if($asal == "Fahrenheit" && $tujuan == "Rheamur") {$hasil = 4/9 * ($nilai - 32); echo "<h2>Hasil Konversi $hasil °R</h2>";}
            else if($asal == "Fahrenheit" && $tujuan == "Kelvin") {$hasil = 5/9 * ($nilai + 459.67); echo "<h2>Hasil Konversi $hasil °K</h2>";}

            else if($asal == "Rheamur" && $tujuan == "Celcius") {$hasil = 5/4 * $nilai; echo "<h2>Hasil Konversi $hasil °C</h2>";}
            else if($asal == "Rheamur" && $tujuan == "Fahrenheit") {$hasil = 9/4 * $nilai + 32; echo "<h2>Hasil Konversi $hasil °F</h2>";}
            else if($asal == "Rheamur" && $tujuan == "Kelvin") {$hasil = 5/4 * $nilai + 273.15; echo "<h2>Hasil Konversi $hasil °K</h2>";}

            else if($asal == "Kelvin" && $tujuan == "Celcius") {$hasil = $nilai - 273.15; echo "<h2>Hasil Konversi $hasil °C</h2>";}
            else if($asal == "Kelvin" && $tujuan == "Fahrenheit") {$hasil = 9/5 * $nilai - 459.67; echo "<h2>Hasil Konversi $hasil °F</h2>";}
            else if($asal == "Kelvin" && $tujuan == "Rheamur") {$hasil = 4/5 * ($nilai - 273.15); echo "<h2>Hasil Konversi $hasil °R</h2>";}
            
        }
    ?>

    
</body>
</html>