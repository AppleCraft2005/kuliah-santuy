CREATE TABLE ruangan (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nama VARCHAR(100),
  status VARCHAR(20)
);

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50)
);

CREATE TABLE peminjaman (
  id INT AUTO_INCREMENT PRIMARY KEY,
  ruang VARCHAR(100),
  nama_peminjam VARCHAR(100),
  nama_dosen VARCHAR(100),
  nama_matkul VARCHAR(100),
  jam_mulai VARCHAR(10),
  jam_akhir VARCHAR(10),
  status VARCHAR(20),
  alasan TEXT
);
