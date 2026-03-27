<?php 
// konek ke database
$Conn = mysqli_connect("localhost", "root", "", "phpdasarlagi");

// ambil data tabel mahasiswa
function query($q) {
    global $Conn;
    $result = mysqli_query($Conn, $q);
    $rows = [];

    while($row = mysqli_fetch_assoc($result)) {
        $rows[] = $row;
    };
    
    return $rows;

// ambil data (fetch) dari objek result
// mysqli_fetch_row() = mengembalikan array numeric
// mysqli_fetch_assoc() = mengembalikan array assoc
// mysqli_fetch_array() = mengembalikan numeric dan assoc
// mysqli_fetch_object() = mengembalkan object

}
?>