<?php 
    require 'functions.php';
    if(isset($_POST['register'])) {
        if(registerUser($_POST) > 0) {
            echo "
            <script>
                alert('berhasil register user');
            </script>";
            header("Location: login.php");
        }
        else{
            echo mysqli_error($Conn);
        }
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Halaman Registrasi</title>
</head>
<body>
    <h1>Halaman Registrasi</h1>

    <form action="" method="post">
        <ul>
            <li>
                <label for="username">Username: </label>
                <input type="text" name="username" id="username">
            </li>
            <li>
                <label for="email">email: </label>
                <input type="text" name="email" id="email">
            </li>
            <li>
                <label for="password">password: </label>
                <input type="password" name="password" id="password">
            </li>
            <li>
                <label for="passwordconf">Konfirmasi password: </label>
                <input type="password" name="passwordconf" id="passwordconf">
            </li>
            <button type="submit" name="register">Registrasi</button>
        </ul>
    </form>
</body>
</html>