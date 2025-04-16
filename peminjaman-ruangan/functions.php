<?php 
$conn = mysqli_connect("localhost", "root", "", "siruang");

function query($q) {
    global $conn;
    $result = mysqli_query($conn, $q);
    $rows = [];

    while($row = mysqli_fetch_assoc($result)) {
        $rows[] = $row;
    }

    return $rows;
}
function insertData($data) {
    global $conn;
    $namaDosen = $data['nama_dosen'];
    $namaMatkul = $data['nama_matkul'];
    $waktuMulai = $data['mulai'];
    $waktuSelesai = $data['selesai'];
    $namaRuang = $data['ruangan'];
    $sarana = $data['sarana'];

    $query = "INSERT INTO pinjam_ruang VALUES('', '$namaDosen', '$namaMatkul', '$waktuMulai', '$waktuSelesai', '$namaRuang', '$sarana')";

    mysqli_query($conn, $query);

    return mysqli_affected_rows($conn);
}
?>