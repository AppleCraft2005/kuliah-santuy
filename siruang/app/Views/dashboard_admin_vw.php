<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php if(session()->get('error')): ?>
        <p><?= session()->get('error'); ?></p>
    <?php endif; ?>
</body>
</html>

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
                <h2>SISTEM INFORMASI PEMANTAUAN & PEMINJAMAN RUANGAN KELAS</h2>
            </div>
            <h1>Selamat Datang, <?= session()->get('username'); ?></h1>
        </header>

        <main>
            <div class="data-container">
                <h3>DATA PEMINJAMAN RUANGAN</h3>
                <a href="<?= base_url('admin/peminjaman') ?>">Tambah</a>

                <?= view('components/Searchs', ['ruangan_list' => $ruangan_list, 'search_params' => $search_params, 'base_url_for_search' => 'admin/dashboard']); ?>

                <table>
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Aksi</th>
                            <th>Nama Peminjam</th>
                            <th>Nama Dosen</th>
                            <th>Mata Kuliah</th>
                            <th>Waktu Mulai</th>
                            <th>Waktu Selesai</th>
                            <th>Ruangan</th>
                            <th>Sarana</th>
                            <th>Status</th>
                            <th>Komentar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php $no = 1; ?>
                        <?php foreach($pinjam as $p): ?>

                            <tr>
                                <td><?= $no++; ?></td>
                                <td>
                                    <a href="<?= base_url('admin/peminjaman/edit/'. $p['id_peminjaman']); ?>">Edit</a> |
                                    <a href="<?= base_url('admin/peminjaman/delete/'. $p['id_peminjaman']); ?>">Hapus</a>
                                </td>
                                <td><?= $p['nama_peminjam']; ?></td>
                                <td><?= $p['nama_dosen']; ?></td>
                                <td><?= $p['nama_matkul']; ?></td>
                                <td><?= $p['mulai']; ?></td>
                                <td><?= $p['selesai']; ?></td>
                                <td><?= $p['nama_ruang']; ?></td>
                                <td><?= $p['sarana']; ?></td>
                                <td><?= $p['status_peminjaman']; ?></td>
                                <td><?= $p['komentar']; ?></td>
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
        <a href="<?= base_url('/logout') ?>">LogOut</a>
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
