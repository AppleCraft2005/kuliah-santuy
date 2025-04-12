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

    //upload gambar
    $gambar = uploadImg();
    if(!$gambar) {return false;};

    $query = "INSERT INTO mahasiswa VALUES('', '', '$gambar', '$nama', '$nim', '$email', '$jurusan')";

    mysqli_query($Conn, $query); 

    return mysqli_affected_rows($Conn);
}
function uploadImg() {
    $namaFile = $_FILES["gambar"]["name"];
    $tmp = $_FILES["gambar"]["tmp_name"];
    $ukuranFIle = $_FILES["gambar"]["size"];
    $error = $_FILES["gambar"]["error"];

    // cek apakah tidak ada gambar yang diupload
    if($error == 4) {
        echo "
        <script>
            alert('Tidak ada gambar yang diupload!');
        </script>";
        return false;
    }
    // cek apakah yang diupload gambar atau tidak
    $validImgExt = ['jpg', 'jpeg', 'png'];
    $imgExt = explode(".", $namaFile);
    $imgExt = strtolower(end($imgExt));
    if(!in_array($imgExt, $validImgExt)) {
        echo "
        <script>
            alert('ekstensi gambar yang diupload tidak didukung!');
        </script>";
        return false;
    }
    // cek ukuran gambar
    if($ukuranFIle > 3000000) {
        echo "
        <script>
            alert('Ukuran gambar terlalu besar!');
        </script>";
        return false;
    }
    // lolos semua pengecekan diatas, maka gambar dapat diupload
    $namaFileBaru = uniqid();
    $namaFileBaru .= '.';
    $namaFileBaru .= $imgExt;
    move_uploaded_file($tmp, 'img/' . $namaFileBaru);
    return $namaFileBaru;

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
    $gambarLama = $data["gambar"];

    // cek apakah user pilih gambar baru atau tidak
    if($_FILES['gambar']['error'] == 4) {
        $gambar = $gambarLama;
    }
    else {
        $gambar = uploadImg();
    }

    $query = "UPDATE mahasiswa SET nama = '$nama', nim = '$nim', email = '$email', jurusan = '$jurusan', gambar = '$gambar' WHERE Id = $Id";

    mysqli_query($Conn, $query);

    return mysqli_affected_rows($Conn);
}
function cariData($keyword) {
    $query = "SELECT * FROM mahasiswa WHERE nama LIKE '%$keyword%' OR nim LIKE '%$keyword%' OR email LIKE '%$keyword%' OR jurusan LIKE '%$keyword%'";

    return query($query);
}
function registerUser($data) {
    global $Conn;
    $username = strtolower(stripslashes($data['username']));
    $password = mysqli_real_escape_string($Conn, $data['password']);
    $passwordconf = mysqli_real_escape_string($Conn, $data['passwordconf']);
    $email = $data['email'];

    // cek username sudah ada atau belum
    $cekUname = mysqli_query($Conn, "SELECT Username FROM user WHERE Username = '$username'");
    if(mysqli_fetch_assoc($cekUname)) {
        echo "
        <script>
            alert('username sudah terdaftar');
        </script>";
        return false;
    }

    // cek apakah passwordconf sama dengan password
    if($passwordconf !== $password) {
        echo "
        <script>
            alert('Konfirmasi password tidak sesuai');
        </script>";
        return false;
    }
    // enkripsi password
    $password = password_hash($password, PASSWORD_DEFAULT);
    // tambahkan user baru ke database
    mysqli_query($Conn, "INSERT INTO user VALUES('', '$username', '$password', '$email' )");

    return mysqli_affected_rows($Conn);
}
?>