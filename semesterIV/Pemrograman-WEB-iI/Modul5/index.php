<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Halaman Awal</title>
    <style>
        body {
            background-image: url("https://static1.srcdn.com/wordpress/wp-content/uploads/2022/01/Genshin-Impact-Mondstadt-Library.jpg");
            background-repeat: no-repeat;
            background-size: cover;
            font-family: Arial, sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        h1 {
            margin-bottom: 40px;
            color: #333;
        }

        .container {
            padding: 12px;
            background-color:rgba(241, 239, 236, 0.61);
            border-radius: 12px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .menu-container {
            display: flex;
            gap: 20px;
        }

        .menu-container a {
            padding: 15px 30px;
            background-color: #45a049;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .menu-container a:hover {
            background-color:rgb(49, 114, 52);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Menu Akses Tabel</h1>
        <div class="menu-container">
            <a href="Buku/Buku.php">Tabel Buku</a>
            <a href="Peminjaman/Peminjaman.php">Tabel Peminjaman</a>
            <a href="Member/Member.php">Tabel Member</a>
        </div>  
    </div>
</body>
</html>
