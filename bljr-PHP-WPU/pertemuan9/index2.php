<?php 
// konek ke database
$Conn = mysqli_connect("localhost", "root", "", "phpdasarlagi");
// ambil data tabel mahasiswa
$result = mysqli_query($Conn, "SELECT * FROM mahasiswa");
// ambil data (fetch) dari objek result
// mysqli_fetch_row() = mengembalikan array numeric
// mysqli_fetch_assoc() = mengembalikan array assoc
// mysqli_fetch_array() = mengembalikan numeric dan assoc
// mysqli_fetch_object() = mengembalkan object
// while($mhs = mysqli_fetch_assoc($result)) {var_dump($mhs);};

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Daftar Mahasiswa</h1>

    <table border="1" cellpadding="10"  >
        <tr>
            <th>No.</th>
            <th>Aksi</th>
            <th>Nama</th>
            <th>NIM</th>
            <th>Email</th>
            <th>Jurusan</th>
        </tr>

        <?php $no = 1; ?>
        <?php while($mhs = mysqli_fetch_assoc($result)): ?>
        <tr>
            
            <td><?php echo $no ?></td>
            <td>
                <a href="">Edit</a> | <a href="">Hapus</a> 
            </td>
            <td><?php echo $mhs["nama"] ?></td>
            <td><?php echo $mhs["nim"] ?></td>
            <td><?php echo $mhs["email"] ?></td>
            <td><?php echo $mhs["jurusan"] ?></td>
        </tr>
        <?php $no++; ?>
        <?php endwhile ?>
    </table>
</body>
</html>