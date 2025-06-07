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
            <h3>Selamat Datang, <?= session()->get('username'); ?></h3>
        </header>

        <main>
            <div class="data-container">
                <h3>DATA PEMINJAMAN RUANGAN</h3>
                <a href="<?= base_url('user/peminjaman') ?>" class="tambah-button"><i class="fa-solid fa-plus"></i> Tambah</a>

                <?= view('components/Searchs', ['ruangan_list' => $ruangan_list, 'search_params' => $search_params, 'base_url_for_search' => 'user/dashboard']); ?>

                <div class="table-container">
                    <table>
                        <thead>
                            <tr>
                                <th>No</th>
                                <th style="width: 75px;">Aksi</th>
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
                            <?php if(!empty($pinjam)): ?>
                            <?php $no = 1 + ($pager->getCurrentPage('peminjaman_list') - 1) * $pager->getPerPage('peminjaman_list'); ?>
                            <?php foreach($pinjam as $p): ?>
                                <tr>
                                    <td><?= $no++; ?></td>
                                    <td>
                                        <?php if(session()->get('username') === $p['nama_peminjam']): ?>
                                            <a href="<?= base_url('user/peminjaman/edit/'. $p['id_peminjaman']); ?>"><i class="fa-solid fa-pen-to-square"></i></a> | 
                                            <a href="<?= base_url('user/peminjaman/delete/'. $p['id_peminjaman']); ?>" onclick=" return confirm('Yakin Ingin Menghapus Data Peminjaman Ini?')"><i class="fa-solid fa-trash"></i></a>
                                        <?php endif; ?>
                                    </td>
                                    <td><?= esc($p['nama_peminjam']); ?></td>
                                    <td><?= esc($p['nama_dosen']); ?></td>
                                    <td><?= esc($p['nama_matkul']); ?></td>
                                    <td><?= esc(date('l',strtotime($p['mulai']))).'<br>' . esc($p['mulai']); ?></td>
                                    <td><?= esc(date("l",strtotime($p['selesai']))). '<br>' . esc($p['selesai']); ?></td>
                                    <td><?= esc($p['nama_ruang']); ?></td>
                                    <td><?= esc($p['sarana']); ?></td>
                                    <td><?= esc($p['status_peminjaman'] );?></td>
                                    <td><?= esc($p['komentar']); ?></td>
                                </tr>
                            <?php endforeach; ?>
                            <?php else : ?>
                                <tr>
                                    <td colspan="11"><p class="empty-notif">Tidak ada data peminjaman yang ditemukan.</p></td>
                                </tr>
                            <?php endif; ?>
                        </tbody>
                    </table>
                </div>

                <div class="pagination-link">
                    <?= $pager->links('peminjaman_list', 'default_full'); ?>
                </div>
            </div>
        </main>
        <a href="<?= base_url('/logout') ?>" class="logout-button">LogOut</a>
    </div>
    <script>
        <?php if(session()->getFlashdata('success')): ?>
            alert('<?= session()->getFlashdata('success'); ?>');
        <?php endif; ?>
    </script>
</body>
</html>
