<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="" method="post">
        <input type="text" name="input-str">
        <button type="submit" name="submit">submit</button>
    </form>

    <?php 
        if(isset($_POST['submit'])) {
            $input = strtolower($_POST['input-str']);
            $panjangStr = strlen($input);
            $pisah = str_split($input);

            foreach($pisah as $p) {
                for($i = 0 ; $i < $panjangStr ; $i++) {
                    if($i == 0) {echo strtoupper($p);}
                    else {echo $p;}
                }
            }
        }
    ?>
</body>
</html>