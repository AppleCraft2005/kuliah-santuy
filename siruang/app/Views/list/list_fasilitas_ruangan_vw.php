<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIRUANG - Sistem Informasi Pemantauan & Peminjaman Ruangan PSTI</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<?= base_url('css/ListFasilitasRuangan.css'); ?>">
</head>
<body>

<header class="header">
    <div class="header-text-container">
        <div class="header-brand">SIRUANG</div>
        <div class="header-title">SISTEM INFORMASI PEMANTAUAN & PEMINJAMAN RUANGAN PSTI</div>
    </div>
</header>

    <?php 
        $RuanganGroup = []; 
        foreach($ruanganFasilitas as $rf) {
            if(!isset($RuanganGroup[$rf['id_ruangan']])) {
                $RuanganGroup[$rf['id_ruangan']] = [
                    'id_ruangan' => $rf['id_ruangan'],
                    'nama_ruang' => $rf['nama_ruang'],
                    'kapasitas' => $rf['kapasitas'],
                    'url_foto' => $rf['url_foto'],
                    'fasilitas' => [],
                ];                
            }
            
            if(!empty($rf['id_fasilitas'])) {
                $RuanganGroup[$rf['id_ruangan']]['fasilitas'][] = [
                    'nama_fasilitas' => $rf['nama_fasilitas'],
                    'jumlah_fasilitas' => $rf['jumlah_fasilitas']
                ];
            }
        };
    ?>

    <main class="main-container">
        <div class="room-grid">
            <?php foreach($RuanganGroup as $rg): ?>
                <div class="room-card">
                    <div class="card-image-container">
                        <img src="<?= base_url($rg['url_foto']); ?>" alt="Ruang A15" class="card-image">
                    </div>
                    <div class="card-content">
                        <div class="card-title-header">
                            <h2>Ruang <?= $rg['nama_ruang']; ?></h2>
                            <span class="capacity-tag">Kapasitas: <?= $rg['kapasitas']; ?></span>
                        </div>
                        <h3>FASILITAS:</h3>
                        <ul class="facility-list-grid" >
                            <?php foreach($rg['fasilitas'] as $f): ?>
                                <li><span><?= $f['nama_fasilitas']; ?>: <?= $f['jumlah_fasilitas']; ?> Unit</span></li>
                            <?php endforeach; ?>
                        </ul> 
                    </div>
                </div>
            <?php endforeach; ?>
            </div> <div class="back-button-container">
                <a href="<?= route_to('peminjaman'); ?>" class="back-button">Kembali</a>
            </div>
        </div>
    </main>

</body>
</html>
