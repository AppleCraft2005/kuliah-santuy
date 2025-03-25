<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        $nilai = 72;

        if ($nilai >= 80) {$huruf = 'A';}
        elseif ($nilai >= 70 and $nilai <= 79) {$huruf = 'B';}
        elseif ($nilai >= 60 and $nilai <= 69) {$huruf = 'C';}
        elseif ($nilai >= 50 and $nilai <= 59) {$huruf = 'D';}
        elseif ($nilai <= 49) {$huruf = 'E';}

        switch ($nilai) {
            case $nilai >= 80:
                $hurufSwitch = 'A';
                break;
            case $nilai >= 70 and $nilai <= 79:
                $hurufSwitch = 'B';
                break;
            case $nilai >= 60 and $nilai <= 69:
                $hurufSwitch = 'C';
                break;   
            case $nilai >= 50 and $nilai <= 59:
                $hurufSwitch = 'D';
                break; 
            case $nilai <= 49;
                $hurufSwitch = 'E';
                break;  
            default:
                echo "nilai tidak valid";
                break;
        }
    ?>

    <h2>Program Konversi Nilai Angka ke Huruf</h2>

    <h3>Pada percabangan if else:</h3>
    <p>Nilai yang disimpan: <?php echo $nilai; ?> sehingga hurufnya: <?php echo $huruf ?> </p>

    <h3>Pada percabangan switchCase</h3>
    <p>Nilai yang disimpan: <?php echo $nilai; ?> sehingga hurufnya: <?php echo $hurufSwitch ?> </p>

</body>
</html>

