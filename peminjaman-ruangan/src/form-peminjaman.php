<?php 
session_start();
$userRole = $_SESSION['role'];
require 'functions.php';
// untuk mengambil nama-nama dosen dan matkul
$dosen = query("SELECT * FROM dosen");
$matkul = query("SELECT * FROM mata_kuliah");

if(isset($_POST["submit"])) {
  if(insertData($_POST) > 0) {
    if($userRole == "admin") {
      echo "
          <script>
              document.location.href = '../admin/dashboard.php'
              alert('Data berhasil ditambahkan');
          </script>";
    }
    else{
      echo "
      <script>
          document.location.href = '../user/dashboard.php'
          alert('Data berhasil ditambahkan');
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
  <h2>Form Peminjaman Ruangan</h2>
  <form action="" method="POST">
    <!-- Nama Peminjam dan NIM diambil dari sesi login biasanya -->
    <label for="nama_dosen">Nama Dosen:</label><br>
    <select id="nama_dosen" name="nama_dosen" required>
      <option value="">-- Pilih Dosen --</option>
      <?php foreach($dosen as $d):?>
        <option value="<?= $d['id_dosen']; ?>"><?= $d['nama_dosen']; ?></option>
      <?php endforeach; ?>
    </select><br><br>

    <label for="nama_matkul">Nama Mata Kuliah:</label><br>
    <select id="nama_matkul" name="nama_matkul" required>
      <option value="">-- Pilih Mata Kuliah --</option>
      <?php foreach($matkul as $m):?>
        <option value="<?= $m['id_matkul']; ?>"><?= $m['nama_matkul']; ?></option>
      <?php endforeach; ?>
    </select><br><br>

    <label for="mulai">Tanggal & Jam Mulai:</label><br>
    <input type="datetime-local" id="mulai" name="mulai" required><br><br>

    <label for="selesai">Tanggal & Jam Selesai:</label><br>
    <input type="datetime-local" id="selesai" name="selesai" required><br><br>

    <label for="ruangan">Ruangan:</label><br>
    <select id="ruangan" name="ruangan" required>
      <option value="">-- Pilih Ruangan --</option>
      <option value="1">Ruang A13</option>
      <option value="2">Ruang A14</option>
      <option value="3">Ruang A15</option>
      <!-- Bisa disesuaikan dari database -->
    </select><br><br>

    <label for="sarana">Sarana Tambahan (opsional):</label><br>
    <textarea id="sarana" name="sarana" rows="3" placeholder="Contoh: Proyektor BenQ, Kabel HDMI panjang, Spidol biru"></textarea><br><br>

    <button type="submit" name="submit">Ajukan Peminjaman</button>
  </form>
</body>
</html>
