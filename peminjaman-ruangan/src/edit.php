<?php 
session_start();
$userRole = $_SESSION['role'];
//cek session
if(!isset($_SESSION['login'])) {
    header("Location: login.php");
    exit;
}

require 'functions.php';
// untuk mengambil nama-nama dosen dan matkul
$dosen = query("SELECT * FROM dosen");
$matkul = query("SELECT * FROM mata_kuliah");
$ruangan = query("SELECT * FROM ruangan");

$idPeminjaman = $_GET['id_peminjaman'];
$dataPeminjaman = query("SELECT * FROM pinjam_ruang WHERE id_peminjaman = $idPeminjaman")[0];

if(isset($_POST["submit"])) {
    if(editData($_POST) > 0) {
      if($userRole == "admin") {
        echo "
            <script>
                document.location.href = '../admin/dashboard.php'
                alert('Data berhasil diubah');
            </script>";
      }
      else{
        echo "
        <script>
            document.location.href = '../user/dashboard.php'
            alert('Data berhasil diubah');
        </script>";
      }
    } 
    else{
        echo "
        <script>
            alert('Data gagal ditambahkan');
        </script>";
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
  <h2>Edit data peminjaman</h2>

  <a href="">Kembali</a>
  <form action="" method="POST">
    <!-- agar id_peminjaman dari GET dapat di POST ke fungsi edit -->
    <input type="hidden" name="id_peminjaman" value="<?= $dataPeminjaman['id_peminjaman']; ?>">

    <!-- nama dosen -->
    <label for="nama_dosen">Nama Dosen:</label><br>
    <select id="nama_dosen" name="nama_dosen" required>
      <option value="">-- Pilih Dosen --</option>
      <?php foreach($dosen as $d):?>
        <option value="<?= $d['id_dosen']; ?>" <?= ($dataPeminjaman['nama_dosen'] == $d['id_dosen']) ? 'selected' : '' ?> ><?= $d['nama_dosen']; ?></option>
      <?php endforeach; ?>
    </select><br><br>

    <!-- nama matkul -->
    <label for="nama_matkul">Nama Mata Kuliah:</label><br>
    <select id="nama_matkul" name="nama_matkul" required>
      <option value="">-- Pilih Mata Kuliah --</option>
      <?php foreach($matkul as $m):?>
        <option value="<?= $m['id_matkul']; ?>" <?= ($dataPeminjaman['nama_matkul'] == $m['id_matkul']) ? 'selected' : '' ?> ><?= $m['nama_matkul']; ?></option>
      <?php endforeach; ?>
    </select><br><br>

    <!-- waktu mulai dan selesai -->
    <label for="mulai">Tanggal & Jam Mulai:</label><br>
    <input type="datetime-local" id="mulai" name="mulai" required value="<?= $dataPeminjaman['mulai']; ?>"><br><br>

    <label for="selesai">Tanggal & Jam Selesai:</label><br>
    <input type="datetime-local" id="selesai" name="selesai" required value="<?= $dataPeminjaman['selesai']; ?>"><br><br>
    
    <!-- ruangan -->
    <label for="ruangan">Ruangan:</label><br>
    <select id="ruangan" name="ruangan" required>
      <?php foreach($ruangan as $r):?>
        <option value="<?= $r['id_ruangan']; ?>"<?= $r['nama_ruang']; ?> <?= ($dataPeminjaman['id_ruangan'] == $r['id_ruangan']) ? 'selected' : '' ?>> <?= $r['nama_ruang']; ?> </option>
      <?php endforeach; ?>
    </select><br><br>
    
    <!-- sarana -->
    <label for="sarana">Sarana Tambahan (opsional):</label><br>
    <textarea id="sarana" name="sarana" rows="3" placeholder="Contoh: Proyektor BenQ, Kabel HDMI panjang, Spidol biru"><?= $dataPeminjaman['sarana']; ?></textarea><br><br>
    
    <!-- mengecek agar hanya tampil saat digunakan admin saja -->
    <?php if($userRole == "admin"): ?>
      <!-- status peminjaman -->
      <label for="status_peminjaman">Status Peminjaman:</label><br>
      <select id="status_peminjaman" name="status_peminjaman" required>
        <option value="Menunggu🔄" <?= ($dataPeminjaman['status_peminjaman'] == 'Menunggu🔄') ? 'selected' : '' ?>>Menunggu🔄</option>
        <option value="Disetujui✅" <?= ($dataPeminjaman['status_peminjaman'] == 'Disetujui✅') ? 'selected' : '' ?>>Disetujui✅</option>
        <option value="Ditolak❌" <?= ($dataPeminjaman['status_peminjaman'] == 'Ditolak❌') ? 'selected' : '' ?>>Ditolak❌</option>
      </select><br><br>
      
      <!-- komentar -->
      <label for="komentar">Komentar:</label><br>
      <textarea id="komentar" name="komentar" rows="3"><?= $dataPeminjaman['komentar']; ?></textarea><br><br>
      <?php endif; ?>
      
    <button type="submit" name="submit">Ubah Data</button>
  </form>
</body>
</html>