<?php 
if(!isset($_GET["brand"]) || !isset($_GET["type"]) || !isset($_GET["release"]) ) {
    header("Location: PHPcihuy1.php");
    exit;
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
    <li> <?= $_GET["brand"] ?> </li>
    <li> <?= $_GET["type"] ?> </li>
    <li> <?= $_GET["release"] ?> </li>
</body>
</html>