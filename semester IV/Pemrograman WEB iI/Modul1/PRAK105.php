<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table, tr, td {
            border: 1px solid black;
            
        }
    </style>
</head>
<body>
    <table>
        <?php 
            $phoneList = array("S22" => "Samsung Galaxy S22", "S22+" => "Samsung Galaxy S22+", "A03" => "Samsung Galaxy A03", "xcvr5" => "Samsung Galaxy Xcover5")
            
        ?>

        <tr><td style="background-color: red; height: 3rem; font-weight:bold">Daftar Smartphone Samsung</td></tr>
        <tr><td> <?php echo $phoneList["S22"] ?> </td></tr>
        <tr><td> <?php echo $phoneList["S22+"] ?> </td></tr>
        <tr><td> <?php echo $phoneList["A03"] ?> </td></tr>
        <tr><td> <?php echo $phoneList["xcvr5"] ?> </td></tr>
    </table>
</body>
</html>