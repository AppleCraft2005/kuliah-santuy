<?php 
require '../Model.php';
$query = getData("SELECT * FROM member");

// untuk hapus member
if(isset($_GET['id_member'])) {
    deleteData("member", "id_member",$_GET['id_member']);
    header("Location: Member.php");
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
    <h1>Halaman Member</h1>
    <a href="FormMember.php" class="add-btn">Tambah Member</a>

    <table border="1" cellspacing="0" cellpadding="5">
        <tr>
            <th>ID Member</th>
            <th>Aksi</th>
            <th>Nama Member</th>
            <th>Nomor Member</th>
            <th>Alamat</th>
            <th>Tanggal Mendaftar</th>
            <th>Tanggal Terakhir Bayar</th>
        </tr>

        <?php foreach($query as $q): ?>
            <tr>
                <td><?= $q["id_member"] ?></td>
                <td class="action-links">
                    <a href="FormMember.php?id_member=<?= $q['id_member'] ?>">Edit</a> | <a href="Member.php?id_member=<?= $q['id_member'] ?>">Hapus</a>
                </td>
                <td><?= $q["nama_member"] ?></td>
                <td><?= $q["nomor_member"] ?></td>
                <td><?= $q["alamat"] ?></td>
                <td><?= $q["tgl_mendaftar"] ?></td>
                <td><?= $q["tgl_terakhir_bayar"] ?></td> 
            </tr>
        <?php endforeach; ?>
    </table>
</body>
</html>