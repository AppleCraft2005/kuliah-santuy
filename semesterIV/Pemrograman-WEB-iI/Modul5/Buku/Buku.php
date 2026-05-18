<?php 
require '../Model.php';
$query = getData("SELECT * FROM buku");

// untuk hapus member
if(isset($_GET['id_buku'])) {
    deleteData("buku", "id_buku", $_GET['id_buku']);
    header("Location: Buku.php");
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f4f6;
            margin: 20px;
            color: #333;
        }

        h1 {
            text-align: center;
            color: #2c3e50;
        }

        .add-btn {
            display: inline-block;
            margin-bottom: 20px;
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border-radius: 5px;
            font-size: 14px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            transition: background-color 0.2s ease-in-out;
            text-decoration: none;
        }

        .add-btn:hover {
            background-color: #45a049;
        }

        .table-container {
            max-width: 1000px;
            margin: 0 auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
            font-size: 14px;
        }

        th {
            background-color: #2c3e50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #eef6fa;
        }

        .action-links a {
            margin-right: 8px;
            color: #e67e22;
            text-decoration: none;
        }

        .action-links a:last-child {
            color: #e74c3c;
        }

        .action-links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Halaman Buku</h1>
    <a href="FormBuku.php" class="add-btn">Tambah Buku</a>

    <table border="1" cellspacing="0" cellpadding="5">
        <tr>
            <th>ID Buku</th>
            <th>Aksi</th>
            <th>Judul Buku</th>
            <th>Penulis</th>
            <th>Penerbit</th>
            <th>Tahun Terbit</th>
        </tr>

        <?php foreach($query as $q): ?>
            <tr>
                <td><?= $q["id_buku"] ?></td>
                <td class="action-links">
                    <a href="FormBuku.php?id_buku=<?= $q['id_buku'] ?>">Edit</a> | <a href="Buku.php?id_buku=<?= $q['id_buku'] ?>">Hapus</a>
                </td>
                <td><?= $q["judul_buku"] ?></td>
                <td><?= $q["penulis"] ?></td>
                <td><?= $q["penerbit"] ?></td>
                <td><?= $q["tahun_terbit"] ?></td> 
            </tr>
        <?php endforeach; ?>
    </table>
</body>
</html>