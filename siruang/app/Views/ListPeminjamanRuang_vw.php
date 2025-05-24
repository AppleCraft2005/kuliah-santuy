<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>SIRUANG - Sistem Informasi Pemantauan & Peminjaman Ruangan Kelas</title>
    <link rel="stylesheet" href="<?= base_url('css/ListPinjamRuang.css') ?>" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
</head>
<body>
    <div class="container">
        <header>
            <div class="header-text">
                <h1>SIRUANG</h1>
                <h2>SISTEM INFORMASI PEMANTAUAN &</h2>
                <h2>PEMINJAMAN RUANGAN KELAS</h2>
            </div>
            <a class="login-btn" href="<?= base_url('/login') ?>">LOGIN</a>
        </header>

        <main>
            <div class="data-container">
                <h3>DATA PEMINJAMAN RUANGAN</h3>
                <div class="search-container">
                    <input type="text" placeholder="Search" />
                    <i class="fas fa-search"></i>
                </div>

                <table>
                    <thead>
                        <tr>
                            <th>Nama Peminjam</th>
                            <th>Nama Dosen</th>
                            <th>Mata Kuliah</th>
                            <th>Waktu Mulai</th>
                            <th>Waktu Selesai</th>
                            <th>Ruangan</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php foreach($pinjam as $p): ?>
                            <tr>
                                <td><?= $p['nama_peminjam']; ?></td>
                                <td><?= $p['nama_dosen']; ?></td>
                                <td><?= $p['nama_matkul']; ?></td>
                                <td><?= $p['mulai']; ?></td>
                                <td><?= $p['selesai']; ?></td>
                                <td><?= $p['id_ruangan']; ?></td>
                                <td><?= $p['status_peminjaman']; ?></td>
                            </tr>
                        <?php endforeach; ?>
                    </tbody>
                </table>

                <!-- <div class="pagination">
                    <a href="#" class="prev-btn">← Prev 10</a>
                    <div class="page-numbers">
                        <a href="#">1</a>
                        <a href="#">2</a>
                        <a href="#" class="active">3</a>
                        <a href="#">4</a>
                        <a href="#">5</a>
                        <a href="#">6</a>
                        <a href="#">7</a>
                        <a href="#">8</a>
                        <a href="#">9</a>
                        <a href="#">10</a>
                        <a href="#">11</a>
                        <span>...</span>
                        <a href="#">78</a>
                    </div>
                    <a href="#" class="next-btn">Next 10 →</a>
                </div> -->
            </div>
        </main>
    </div>

    <script>
        // Untuk efek klik aktif pada pagination (tanpa load ulang)
        const pageLinks = document.querySelectorAll(".page-numbers a");
        pageLinks.forEach(link => {
            link.addEventListener("click", function (e) {
                e.preventDefault();
                pageLinks.forEach(l => l.classList.remove("active"));
                this.classList.add("active");
            });
        });
    </script>
</body>
</html>
