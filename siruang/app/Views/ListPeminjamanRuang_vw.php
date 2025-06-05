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
                <h1 class="site-title">SIRUANG</h1>
                <p class="site-description">SISTEM INFORMASI PEMANTAUAN & PEMINJAMAN RUANGAN KELAS</p>
            </div>
            <a href="/login" class="login-button">LOGIN</a>
        </header>

        <main>
            <div class="data-container">
                <h3>DATA PEMINJAMAN RUANGAN</h3>

                <?= view('components/Searchs', ['ruangan_list' => $ruangan_list, 'search_params' => $search_params, 'base_url_for_search' => '/peminjaman']); ?>
                
                <div class="table-container">
                    <table>
                        <thead>
                            <tr>
                                <th>No</th>
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
                            <?php $no = 1 + ($pager->getCurrentPage('peminjaman_list') - 1) * $pager->getPerPage('peminjaman_list'); ?>
                            <?php foreach($pinjam as $p): ?>
                                <tr>
                                    <td><?= $no++; ?></td>
                                    <td><?= $p['nama_peminjam']; ?></td>
                                    <td><?= $p['nama_dosen']; ?></td>
                                    <td><?= $p['nama_matkul']; ?></td>
                                    <td><?= date('l',strtotime($p['mulai'])).'<br>' . $p['mulai'] ?></td>
                                    <td><?= date("l",strtotime($p['selesai'])). '<br>' . $p['selesai'] ?></td>
                                    <td><?= $p['nama_ruang']; ?></td>
                                    <td><?= $p['status_peminjaman']; ?></td>
                                </tr>
                            <?php endforeach; ?>
                        </tbody>
                    </table>
                </div>
                <div class="pagination-link">
                    <?= $pager->links('peminjaman_list', 'default_full'); ?>
                </div>

                <a href="/" class="back-button">Kembali</a>
            </div>
        </main>
    </div>
</body>
</html>
