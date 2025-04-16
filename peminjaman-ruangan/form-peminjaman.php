<?php 
require 'functions.php';

if(isset($_POST["submit"])) {
  if(insertData($_POST) > 0) {
      echo "
          <script>
              document.location.href = 'main.php'
              alert('Data berhasil ditambahkan');
          </script>";
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
    <input type="text" id="nama_dosen" name="nama_dosen" required><br><br>

    <label for="nama_matkul">Nama Mata Kuliah:</label><br>
    <input type="text" id="nama_matkul" name="nama_matkul" required><br><br>

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
