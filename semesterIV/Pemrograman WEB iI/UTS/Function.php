<?php 
$Conn = mysqli_connect("localhost", "root", "", "UTSWeb");

function getData($q) {
    global $Conn;

    $result = mysqli_query($Conn, $q);
    $rows = [];

    while($row = mysqli_fetch_assoc($result)) {
        $rows[] = $row;
    };
    
    return $rows;
}
function insertData($data) {
    global $Conn;

    $Nama = $data['nama'];

    //untuk menangani upload gambar
    $namaGambar = $_FILES['gambar']['name'];
    $tmp = $_FILES['gambar']['tmp_name'];
    $folderGambar = "img/". $namaGambar;

    move_uploaded_file($tmp, $folderGambar);

    return mysqli_query($Conn, "INSERT INTO user VALUES('', '$Nama', '$folderGambar')");
}
?>