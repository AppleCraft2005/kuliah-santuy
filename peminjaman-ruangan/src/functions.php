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
    $namaPeminjam = $_SESSION['username'];
    $namaMatkul = $data['nama_matkul'];
    $waktuMulai = $data['mulai'];
    $waktuSelesai = $data['selesai'];
    $namaRuang = $data['ruangan'];
    $sarana = $data['sarana'];

    $query = "INSERT INTO pinjam_ruang VALUES('', '$namaPeminjam', '$namaDosen', '$namaMatkul', '$waktuMulai', '$waktuSelesai', '$namaRuang', '$sarana', 'Menunggu🔄', '')";

    mysqli_query($conn, $query);

    return mysqli_affected_rows($conn);
}
function deleteData($data) {
    global $conn;
    echo $data;
    $query = "DELETE FROM pinjam_ruang WHERE id_peminjaman = $data";

    mysqli_query($conn, $query);

    return mysqli_affected_rows($conn);
}
function editData($data) {
    global $conn;
    $idPeminjaman = $data['id_peminjaman'];
    $namaDosen = $data['nama_dosen'];
    $namaMatkul = $data['nama_matkul'];
    $waktuMulai = $data['mulai'];
    $waktuSelesai = $data['selesai'];
    $ruangan = $data['ruangan'];
    $sarana = $data['sarana'];
    $statusPeminjaman = $data['status_peminjaman'];
    $komentar = $data['komentar'];

    $query = "UPDATE pinjam_ruang SET nama_dosen = '$namaDosen', nama_matkul = '$namaMatkul', mulai = '$waktuMulai', selesai = '$waktuSelesai', id_ruangan = '$ruangan', sarana = '$sarana', status_peminjaman = '$statusPeminjaman', komentar = '$komentar' WHERE id_peminjaman = $idPeminjaman";

    mysqli_query($conn, $query);

    return mysqli_affected_rows($conn);
}
function registerUser($data) {
    global $conn;
    $username = strtolower(stripslashes($data['username']));
    $password = mysqli_real_escape_string($conn, $data['password']);
    $passwordconf = mysqli_real_escape_string($conn, $data['passwordconf']);
    $email = $data['email'];

    $password = password_hash($password, PASSWORD_DEFAULT);
    mysqli_query($conn, "INSERT INTO users VALUES('', '$username', '$password', '$email', 'user')");

    return mysqli_affected_rows($conn);
}
?>