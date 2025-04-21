<?php 
session_start();
// cek sudah login
if(isset($_SESSION['login'])) {
    header("Location: ../index.php");
    exit;
}
require 'functions.php';
if(isset($_POST['login'])) {
    $username = $_POST['username'];
    $password = $_POST['password'];

    $result = mysqli_query($conn, "SELECT * FROM users WHERE username = '$username'");
    // cek username
    if(mysqli_num_rows($result) === 1) {
        //cek password
        $row = mysqli_fetch_assoc($result);
        if(password_verify($password, $row['password'])) {
            //set session
            $_SESSION['login'] = true;
            $_SESSION['username'] = $row['username'];
            $_SESSION['role'] = $row['role'];
            // cek role
            if($row['role'] == 'admin') {header("Location: ../admin/dashboard.php");}
            else{header("Location: ../user/dashboard.php");}
            exit;
        }
    }
    $error = true;
    
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
    <h1>Halaman Login</h1>

    <?php 
    if(isset($error)) {
        echo "<h3>Username atau password salah</h3>";
    }
    ?>

    <form action="" method="post">
        <ul>
            <li>
                <label for="username">Username: </label>
                <input type="text" name="username" id="username">
            </li>
            <li>
                <label for="password">Password: </label>
                <input type="password" name="password" id="password">
            </li>
            <button type="submit" name="login">Login</button>
        </ul>
    </form>
    <a href="register.php">Buat Akun</a>
</body>
</html>