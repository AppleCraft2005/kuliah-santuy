<?php
include 'config.php';

$data = json_decode(file_get_contents("php://input"), true);

$ruang = $data['ruang'];
$nama_peminjam = $data['nama_peminjam'];
$nama_dosen = $data['nama_dosen'];
$nama_matkul = $data['nama_matkul'];
$jam_mulai = $data['jam_mulai'];
$jam_akhir = $data['jam_akhir'];
$status = "pending";

$stmt = $conn->prepare("INSERT INTO peminjaman (ruang, nama_peminjam, nama_dosen, nama_matkul, jam_mulai, jam_akhir, status) VALUES (?, ?, ?, ?, ?, ?, ?)");
$stmt->bind_param("sssssss", $ruang, $nama_peminjam, $nama_dosen, $nama_matkul, $jam_mulai, $jam_akhir, $status);
$stmt->execute();

echo json_encode(["status" => "success"]);
?>
