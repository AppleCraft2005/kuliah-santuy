<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIRUANG - Sistem Informasi Pemantauan & Peminjaman Ruangan PSTI</title>
    <link rel="stylesheet" href="<?= base_url('css/Home.css') ?>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
    <header>
        <div class="header-container">
            <div>
                <h1 class="site-title">SIRUANG</h1>
                <p class="site-description">SISTEM INFORMASI PEMANTAUAN & PEMINJAMAN RUANGAN PSTI</p>
            </div>
            <a href="<?= $loginbtnurl; ?>" class="login-button"><?= $loginbtntxt ?></a>
        </div>
    </header>

    <main>
        <div class="schedule-card">
            <div class="card-header">
                <div class="icon-container">
                    <i class="fa-regular fa-calendar"></i>
                    Jadwal Ruangan Kelas
                </div>
            </div>
            <div class="schedule-table-container">
                <table class="schedule-table">
                    <thead>
                        <tr>
                            <th>
                                <div style="display: flex; align-items: center; gap: 0.25rem;">
                                    <svg class="icon" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                        <circle cx="12" cy="12" r="10"></circle>
                                        <polyline points="12 6 12 12 16 14"></polyline>
                                    </svg>
                                    <span>Waktu</span>
                                </div>
                            </th>
                            <?php foreach($waktuPerkuliahan as $waktu): ?>
                                <th><?= esc($waktu); ?></th>
                            <?php endforeach; ?>
                        </tr>
                    </thead>
                    <tbody>
                        <tbody>
                            <?php if(!empty($jadwalTersusun)): ?>
                                <?php foreach($hariPerkuliahan as $hari): ?>
                                    <tr>
                                        <td><?= esc($hari); ?></td>
                                        <?php foreach($waktuPerkuliahan as $waktu): ?>
                                            <td>
                                                <?php if(!empty($jadwalTersusun[$hari][$waktu])): ?>
                                                    <?php foreach($jadwalTersusun[$hari][$waktu] as $jadwal): ?>
                                                        <div class="schedule-item">
                                                            <p class="Matkul"><?= esc($jadwal['nama_matkul']); ?> - <?= esc($jadwal['nama_ruang']); ?></p>
                                                            <p class="Dosen"><?= esc($jadwal['nama_dosen']); ?></p>
                                                        </div>
                                                    <?php endforeach; ?>
                                                <?php else: ?>
                                                    <div class="schedule-item"></div>
                                                <?php endif; ?>
                                            </td>
                                        <?php endforeach; ?>
                                    </tr>
                                <?php endforeach; ?>
                            <?php else: ?>
                                <td colspan="13"><p>Tidak Ada Jadwal Perkuliahan Saat Ini</p></td>
                            <?php endif; ?>
                        </tbody>
                    </tbody>
                </table>
            </div>

            <div class="card-footer">
                <div class="status-indicators">
                    <div class="status-item">
                        <span class="status-text" style="color: #ef4444;">* Jadwal Kuliah Bisa Berubah Sewaktu-waktu</span>
                    </div>
                </div>
                <a href="<?= route_to('peminjaman') ?>" class="list-button">LIHAT DAFTAR PEMINJAMAN</a>
            </div>
        </div>
    </main>
</body>
</html>