<?php 
    if(isset($_POST["submit"])) {
        if( $_POST["username"] == "admin" && $_POST["password"] == "admin") {
            header("Location: admin.php");
            exit;
        }
        else $error = true;
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <?php if(isset($error)) {echo "<h3>Username atau Password anda salah, coba lagi!</h3>";}
    ?>
    
    <form action="" method="post">
        <h1>Login</h1>
        <label for="username">username: </label>
        <input type="text" name="username" id="username">

        <br>

        <label for="password">password: </label>
        <input type="password" name="password">

        <br>

        <button type="submit" name="submit">kirim</button>
    </form>
    
    
</body>
</html>