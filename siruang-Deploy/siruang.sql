-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2025 at 03:53 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `siruang`
--

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `id_dosen` int(11) NOT NULL,
  `nama_dosen` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`id_dosen`, `nama_dosen`) VALUES
(1, 'Dr. Kevin Thompson, M.Eng.\r\n'),
(2, 'Emily Carter, M.Sc.\r\n'),
(3, 'Prof. Sarah Johnson, M.Sc., Ph.D.\r\n'),
(4, 'Dr. Michael Anderson, Ph.D.\r\n'),
(5, 'Dr. Daniel Lee, Ph.D.\r\n'),
(6, 'Jessica Moore, M.Eng.\r\n'),
(7, 'Dr. Andrew Walker, M.Sc., Ph.D.\r\n'),
(8, 'Prof. Olivia Scott, Ph.D.\r\n'),
(9, 'Benjamin Adams, M.Sc.\r\n'),
(10, 'Dr. Sophia Martinez, M.Eng., Ph.D.\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `mata_kuliah`
--

CREATE TABLE `mata_kuliah` (
  `id_matkul` int(11) NOT NULL,
  `nama_matkul` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mata_kuliah`
--

INSERT INTO `mata_kuliah` (`id_matkul`, `nama_matkul`) VALUES
(1, 'Bahasa Inggris I'),
(2, 'Bahasa Indonesia'),
(3, 'Pemrograman I'),
(4, 'Pemrograman II'),
(5, 'Pemrograman Web I'),
(6, 'Pemrograman Web II'),
(7, 'Pemrograman Mobile'),
(8, 'Analisis Perancangan Sistem'),
(9, 'Administrasi Sistem dan Jaringan'),
(10, 'Basis Data I'),
(11, 'Basis Data II'),
(12, 'Algoritma dan Struktur Data'),
(13, 'Jaringan Komunikasi dan Data'),
(14, 'Statistika dan Probabilitas'),
(15, 'Matematika Diskrit'),
(16, 'Kalkulus'),
(17, 'Aljabar Linear'),
(18, 'Sistem Operasi'),
(19, 'Rekayasa Perangkat Lunak'),
(20, 'Keamanan Siber');

-- --------------------------------------------------------

--
-- Table structure for table `pinjam_ruang`
--

CREATE TABLE `pinjam_ruang` (
  `id_peminjaman` int(11) NOT NULL,
  `nama_peminjam` varchar(100) NOT NULL,
  `nama_dosen` varchar(100) NOT NULL,
  `nama_matkul` varchar(100) NOT NULL,
  `mulai` datetime NOT NULL,
  `selesai` datetime NOT NULL,
  `id_ruangan` varchar(100) NOT NULL,
  `sarana` text NOT NULL,
  `status_peminjaman` enum('Menunggu?','Disetujui✅','Ditolak❌') NOT NULL,
  `komentar` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pinjam_ruang`
--

INSERT INTO `pinjam_ruang` (`id_peminjaman`, `nama_peminjam`, `nama_dosen`, `nama_matkul`, `mulai`, `selesai`, `id_ruangan`, `sarana`, `status_peminjaman`, `komentar`) VALUES
(35, 'jovan gilbert natamasindah', '3', '3', '2025-04-20 12:04:00', '2025-04-20 14:04:00', '1', 'spidol hitam', 'Ditolak❌', 'ruangan sedang di renov'),
(48, 'jovan gilbert natamasindah', '3', '5', '2025-05-12 15:04:00', '2025-05-12 18:04:00', '3', 'pinjam proyektor epson', 'Menunggu🔄', ''),
(51, 'wawan mabest', '3', '6', '2025-05-12 15:20:00', '2025-05-12 17:20:00', '4', '111qqq tv gefe wkwkwkww', 'Menunggu🔄', ''),
(52, 'admin', '6', '7', '2025-05-24 22:08:00', '2025-05-24 01:08:00', '4', 'gak ada', 'Menunggu🔄', ''),
(53, 'admin', '4', '7', '2025-05-25 11:59:00', '2025-05-25 09:59:00', '5', 'proyektor putih', 'Menunggu🔄', ''),
(54, 'amay', '1', '3', '2025-05-25 10:00:00', '2025-05-25 11:00:00', '6', 'perlu spidol hitam', 'Disetujui✅', 'hati hati pake ruannya\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE `ruangan` (
  `id_ruangan` int(11) NOT NULL,
  `nama_ruang` varchar(50) NOT NULL,
  `kapasitas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ruangan`
--

INSERT INTO `ruangan` (`id_ruangan`, `nama_ruang`, `kapasitas`) VALUES
(1, 'A13', 25),
(2, 'A14', 45),
(3, 'A15', 30),
(4, 'Lab. Big Data', 55),
(5, 'Lab. MTI', 25),
(6, 'Lab. RPL', 30);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `role` enum('user','admin') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`, `role`) VALUES
(1, 'jovan gilbert natamasindah', '$2y$10$i0BAUUsAaU8.81goWmWQoeD7qUFx7ReNB2DtG0ZDtuRp3LnYwVTs6', '2310817310002@mhs.ulm.ac.id', 'user'),
(3, 'admin', '$2y$10$NAPJtTFvwxj1FRJDs9I3a.fKPPkCzzYlEWxb7raH/Ej67iVbuGgU6', 'admin@ulm.ac.id', 'admin'),
(4, 'wawan mabest', '$2y$10$gjxoA005ZsNvBI3pVFYXk.Ic8R/2Spnk9sdZRxrntFROtu./Gff/y', '2310817310003@mhs.ulm.ac.id', 'user'),
(5, 'kipuding', '$2y$10$skxpTIMmHUUYcnUIoABDtuPugkefFft7OI9vOvSRWgdcTf5c4voKi', 'kiput@gmail.com', 'user'),
(7, 'applec', '$2y$10$E/E4GguugtA4xQRvWvfjruoqM/60lcqm.GwDloPxY2d3MOZC1tiVm', '2310817310002@mhs.ulm.ac.id', 'user'),
(8, 'amay', '$2y$10$UWJiS4216RtY5fKUoyLCp.vzjM6pm1kwAS6Q22GWwjgFxDGZl0vxe', '2310817310002@mhs.ulm.ac.id', 'user'),
(9, 'akundosen', '$2y$10$vMpYftkezNBvtGdONk3T5OlHNTtHdvBY0XeZS4fMTiTCe3Y88.wp2', 'dosen@ulm.ac.id', 'user'),
(10, 'mahasiswa', '$2y$10$5hNOC5IJGAVJNq/mSbyBDuWVR/CJvGGuoMuANCaWRS2YUY9xZJHY.', 'mahasiswa@ulm.ac.id', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`id_dosen`);

--
-- Indexes for table `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
  ADD PRIMARY KEY (`id_matkul`);

--
-- Indexes for table `pinjam_ruang`
--
ALTER TABLE `pinjam_ruang`
  ADD PRIMARY KEY (`id_peminjaman`);

--
-- Indexes for table `ruangan`
--
ALTER TABLE `ruangan`
  ADD PRIMARY KEY (`id_ruangan`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dosen`
--
ALTER TABLE `dosen`
  MODIFY `id_dosen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
  MODIFY `id_matkul` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `pinjam_ruang`
--
ALTER TABLE `pinjam_ruang`
  MODIFY `id_peminjaman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `ruangan`
--
ALTER TABLE `ruangan`
  MODIFY `id_ruangan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
