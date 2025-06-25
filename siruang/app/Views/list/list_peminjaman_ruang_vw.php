<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>SIRUANG - Sistem Informasi Pemantauan & Peminjaman Ruangan PSTI</title>
    <link rel="stylesheet" href="<?= base_url('css/ListPinjamRuang.css') ?>" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
</head>
<body>
    <div class="container">
        <header>
            <div class="header-text">
                <h1 class="site-title">SIRUANG</h1>
                <p class="site-description">SISTEM INFORMASI PEMANTAUAN & PEMINJAMAN RUANGAN PSTI</p>
            </div>
            <a href="<?= $loginbtnurl; ?>" class="login-button"><?= $loginbtntxt ?></a>
        </header>

        <main>
            <div class="data-container">
                <h3>DATA PEMINJAMAN RUANGAN</h3>

                <?= view('components/searchs', ['ruangan_list' => $ruangan_list, 'search_params' => $search_params, 'base_url_for_search' => 'peminjaman']); ?>
                
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
                            <?php if(!empty($pinjam)): ?>
                            <?php $no = 1 + ($pager->getCurrentPage('peminjaman_list') - 1) * $pager->getPerPage('peminjaman_list'); ?>
                            <?php foreach($pinjam as $p): ?>
                                <tr>
                                    <td><?= $no++; ?></td>
                                    <td><?= esc($p['username']); ?></td>
                                    <td><?= esc($p['nama_dosen']); ?></td>
                                    <td><?= esc($p['nama_matkul']); ?></td>
                                    <td><?= esc(date('l',strtotime($p['waktu_mulai']))).'<br>' . esc($p['waktu_mulai']); ?></td>
                                    <td><?= esc(date("l",strtotime($p['waktu_selesai']))). '<br>' . esc($p['waktu_selesai']); ?></td>
                                    <td><?= esc($p['nama_ruang']); ?></td>
                                    <td><?= esc($p['status_peminjaman'] );?></td>
                                </tr>
                            <?php endforeach; ?>
                            <?php else : ?>
                                <tr>
                                    <td colspan="8"><p class="empty-notif">Tidak ada data peminjaman yang ditemukan.</p></td>
                                </tr>
                            <?php endif; ?>
                        </tbody>
                    </table>
                </div>
                <div class="pagination-link">
                    <?= $pager->links('peminjaman_list', 'default_full'); ?>
                </div>
                
                <div class="navigation-buttons">
                    <a href="/" class="back-button">Kembali</a>
                    <a href="<?= route_to('fasilitas_ruangan') ?>" class="fasilitas-button">LIHAT FASILITAS RUANGAN</a>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
