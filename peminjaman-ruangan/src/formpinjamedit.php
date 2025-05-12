<?php 
require 'functions.php';
session_start();
//cek session login
$userRole = $_SESSION['role'];
if(!isset($_SESSION['login'])) {
  header("Location: login.php");
  exit;
}

// untuk mengambil nama-nama dosen dan matkul
$dosen = query("SELECT * FROM dosen");
$matkul = query("SELECT * FROM mata_kuliah");
$ruangan = query("SELECT * FROM ruangan");

$Peminjaman = [
  'id_peminjaman' => '',
  'nama_dosen' => '',
  'nama_matkul' => '',
  'mulai' => '',
  'selesai' => '',
  'id_ruangan' => '',
  'sarana' => '',
  'status_peminjaman' => 'Menunggu🔄',
  'komentar' => ''
];

if(isset($_GET['id_peminjaman'])) {
  $idPeminjaman = $_GET['id_peminjaman'];
  $Peminjaman = query("SELECT * FROM pinjam_ruang WHERE id_peminjaman = $idPeminjaman")[0];
}

if(isset($_POST["submit"])) {
  if(isset($_GET['id_peminjaman'])) {
    if(editData($_POST) > 0) {
      $redirect = $userRole == "admin" ? "../admin/dashboard.php" : "../user/dashboard.php";
      echo "<script>
                alert('Data berhasil diubah');
                document.location.href = '$redirect'
            </script>";
    } 
    else {
      echo "<script>alert('Data gagal diubah!')</script>";
    }
  }
  else {
    if(insertData($_POST) > 0) {
      $redirect = $userRole == "admin" ? "../admin/dashboard.php" : "../user/dashboard.php";
      echo "<script>
                alert('Data berhasil ditambahkan');
                document.location.href = '$redirect'
            </script>";
    } 
    else {
      echo "<script>alert('Data gagal ditambahkan!')</script>";
    }
  }
}

?>

<!DOCTYPE html>
<html lang="id">
<head>
  <meta charset="UTF-8">
  <title>Form Peminjaman Ruangan</title>
</head>
<body>
    <h2>Form <?= isset($_GET['id_peminjaman']) ? "Edit":"Peminjaman" ?>  Ruangan</h2>
    <form action="" method="POST">

        <?php if(isset($_GET['id_peminjaman'])): ?>
          <input type="hidden"  name="id_peminjaman" value="<?= $Peminjaman['id_peminjaman'] ?>"> 
        <?php endif; ?>

        <!-- dosen -->
        <label for="nama_dosen">Nama Dosen:</label><br>
        <select id="nama_dosen" name="nama_dosen" required>
            <option value="">-- Pilih Dosen --</option>
            <?php foreach($dosen as $d):?>
              <option value="<?= $d['id_dosen']; ?>" <?= $Peminjaman['nama_dosen'] == $d['id_dosen'] ? 'selected' : ''; ?>> <?= $d['nama_dosen'] ?></option>
            <?php endforeach; ?>
        </select><br><br>

        <!-- matkul -->
        <label for="nama_matkul">Nama Mata Kuliah:</label><br>
        <select id="nama_matkul" name="nama_matkul" required>
            <option value="">-- Pilih Mata Kuliah --</option>
            <?php foreach($matkul as $m):?>
              <option value="<?= $m['id_matkul']; ?>" <?= $Peminjaman['nama_matkul'] == $m['id_matkul'] ? 'selected' : ''; ?>> <?= $m['nama_matkul']; ?> </option>
            <?php endforeach; ?>
        </select><br><br>

        <!-- tanggal mulai dan selesai -->
        <label for="mulai">Tanggal & Jam Mulai:</label><br>
        <input type="datetime-local" id="mulai" name="mulai" value="<?= $Peminjaman['mulai'] ?>" required><br><br>
        <label for="selesai">Tanggal & Jam Selesai:</label><br>
        <input type="datetime-local" id="selesai" name="selesai" value="<?= $Peminjaman['selesai'] ?>" required><br><br>

        <!-- ruang -->
        <label for="ruangan">Ruangan:</label><br>
        <select id="ruangan" name="ruangan" required>
            <option value="">-- Pilih Ruangan --</option>
            <?php foreach($ruangan as $r):?>
              <option value="<?= $r['id_ruangan']; ?>" <?= $Peminjaman['id_ruangan'] == $r['id_ruangan'] ? 'selected' : ''; ?>> <?= $r['nama_ruang']; ?> </option>
            <?php endforeach; ?>
        </select><br><br>

        <!-- sarana -->
        <label for="sarana">Sarana Tambahan (opsional):</label><br>
        <textarea id="sarana" name="sarana" rows="3" placeholder="Contoh: Proyektor BenQ, Kabel HDMI panjang, Spidol biru"><?= $Peminjaman['sarana'] ?></textarea><br><br>

        <?php if($userRole == "admin"): ?>
            <!-- status peminjaman -->
            <label for="status_peminjaman">Status Peminjaman:</label><br>
            <select id="status_peminjaman" name="status_peminjaman" required>
                <option value="Menunggu🔄" <?= ($Peminjaman['status_peminjaman'] == 'Menunggu🔄') ? 'selected' : '' ?>>Menunggu🔄</option>
                <option value="Disetujui✅" <?= ($Peminjaman['status_peminjaman'] == 'Disetujui✅') ? 'selected' : '' ?>>Disetujui✅</option>
                <option value="Ditolak❌" <?= ($Peminjaman['status_peminjaman'] == 'Ditolak❌') ? 'selected' : '' ?>>Ditolak❌</option>
            </select><br><br>
            <!-- komentar -->
            <label for="komentar">Komentar:</label><br>
            <textarea id="komentar" name="komentar" rows="3"><?= $Peminjaman['komentar']; ?></textarea><br><br>
        <?php endif; ?>

        <button type="submit" name="submit"><?= isset($_GET['id_peminjaman']) ? "Simpan Edit":"Ajukan Peminjaman" ?></button>
    </form>
</body>
</html>
