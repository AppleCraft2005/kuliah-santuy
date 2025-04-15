<?php
include 'config.php';

$data = json_decode(file_get_contents("php://input"), true);

$id = $data['id'];
$status = $data['status'];
$alasan = $data['alasan'];

$query = "UPDATE peminjaman SET status = '$status', alasan = '$alasan' WHERE id = $id";
$conn->query($query);

echo json_encode(["status" => "success"]);
?>
