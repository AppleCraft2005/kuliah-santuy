<?php 
$Conn = mysqli_connect("localhost", "root", "", "phpdasarlagi");

function query($q) {
    global $Conn;
    $result = mysqli_query($Conn, $q);
    $rows = [];

    while($row = mysqli_fetch_assoc($result)) {
        $rows[] = $row;
    };
    
    return $rows;
}

function insertData($data){
    global $Conn;
    $nama = htmlspecialchars($data["nama"]);
    $nim = htmlspecialchars($data["nim"]);
    $email = htmlspecialchars($data["email"]);
    $jurusan = htmlspecialchars($data["jurusan"]);

    $query = "INSERT INTO mahasiswa VALUES('', '', '$nama', '$nim', '$email', '$jurusan')";

    mysqli_query($Conn, $query); 

    return mysqli_affected_rows($Conn);
}

function deleteData($data) {
    global $Conn;
    $query = "DELETE FROM mahasiswa WHERE id = $data";

    mysqli_query($Conn, $query);

    return mysqli_affected_rows($Conn);
}
function editData($data) {
    global $Conn;
    $Id = htmlspecialchars($data["Id"]);
    $nama = htmlspecialchars($data["nama"]);
    $nim = htmlspecialchars($data["nim"]);
    $email = htmlspecialchars($data["email"]);
    $jurusan = htmlspecialchars($data["jurusan"]);

    $query = "UPDATE mahasiswa SET nama = '$nama', nim = '$nim', email = '$email', jurusan = '$jurusan' WHERE Id = $Id";

    mysqli_query($Conn, $query);

    return mysqli_affected_rows($Conn);
}
function cariData($keyword) {
    $query = "SELECT * FROM mahasiswa WHERE nama LIKE '%$keyword%' OR nim LIKE '%$keyword%' OR email LIKE '%$keyword%' OR jurusan LIKE '%$keyword%'";

    return query($query);
}
?>