<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table, tr, td {border: 1px solid black}
    </style>
</head>
<body>
    <table>
        <tr><td style="font-weight: bold;">Daftar Smartphone Samsung</td></tr>

        <?php 
            $phoneList = array("Samsung Galaxy S22", "Samsung Galaxy S22+", "Samsung Galaxy A03", "Samsung Galaxy Xcover5");
            foreach($phoneList as $i) {echo "<tr><td>  $i </td></tr>";}
        ?>
    </table>
</body>
</html>