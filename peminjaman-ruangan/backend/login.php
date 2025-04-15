<?php
require_once 'db.php';

header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");
header("Access-Control-Allow-Methods: POST, OPTIONS");

// Jika permintaan OPTIONS (preflight), cukup keluar saja
if ($_SERVER['REQUEST_METHOD'] === 'OPTIONS') {
    exit();
}

$data = json_decode(file_get_contents("php://input"));

$username = $data->username;

$query = "SELECT * FROM users WHERE username = ?";
$stmt = $conn->prepare($query);
$stmt->bind_param("s", $username);
$stmt->execute();
$result = $stmt->get_result();

if ($user = $result->fetch_assoc()) {
    echo json_encode(["success" => true, "user" => $user]);
} else {
    echo json_encode(["success" => false, "message" => "Username tidak ditemukan"]);
}
?>
