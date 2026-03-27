<?php
    $Phones = [
        [
            "Brand" => "Samsung",
            "Type" => "S7 Edge",
            "Release" => "2015",
            "Ram" => "4GB",
            "Rom" => "128GB",
            "Battery" => "3200mah",

        ],
        [
            "Brand" => "Xiaomi",
            "Type" => "11",
            "Release" => "2021",
            "Ram" => "6GB",
            "Rom" => "256GB",
            "Battery" => "4500mah",

        ]
    ]
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GET</title>
</head>
<body>
    <?php foreach ($Phones as $phone) :?>
        <a href='PHPcihuy2.php?
            brand=<?= $phone["Brand"] ?>
            &type=<?= $phone["Type"] ?>
            &release=<?= $phone["Release"] ?>'>
        <li> <?= $phone["Brand"] ?> </li></a>
        <br>
        
    <?php endforeach;?>
    
</body>
</html>