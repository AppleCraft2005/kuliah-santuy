<!DOCTYPE html>
<html lang="id">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Form Peminjaman Ruangan</title>
  <link rel="stylesheet" href="<?= base_url('css/FormPeminjaman.css') ?>" />
  <!-- Gunakan versi Font Awesome lengkap -->
  <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
  />
</head>
<body>
  <div class="container">
    <h1><?= isset($peminjaman['id_peminjaman']) ? 'EDIT PEMINJAMAN RUANGAN' : 'FORM PEMINJAMAN RUANGAN' ?></h1>
    <div class="form-container">
      <form action="<?= base_url(session()->get('role') == 'admin' ? 'admin/peminjaman/save' : 'user/peminjaman/save') ?>" method="post">
        
        <?php if(isset($peminjaman['id_peminjaman'])): ?>
          <input type="hidden"  name="id_peminjaman" value="<?= $peminjaman['id_peminjaman'] ?>"> 
        <?php endif; ?>

        <div class="form-group">
          <div class="icon-container">
            <i class="far fa-user"></i> <!-- user tersedia di regular -->
          </div>
          <div class="input-container">
            <label for="nama_dosen">Nama Dosen</label>
            <select id="nama_dosen" name="nama_dosen" required>
                <option value="">-- Pilih Dosen --</option>
                <?php foreach($dosen as $d):?>
                    <option value="<?= $d['id_dosen']; ?>" <?= (isset($peminjaman['nama_dosen']) && ($peminjaman['nama_dosen'] == $d['id_dosen'])) ? 'selected' : ''; ?> > <?= $d['nama_dosen'] ?></option>
                <?php endforeach; ?>
            </select>
          </div>
        </div>

        <div class="form-group">
          <div class="icon-container">
            <i class="fas fa-book"></i> <!-- hanya tersedia di solid -->
          </div>
          <div class="input-container">
            <label for="nama_matkul">Nama Mata Kuliah</label>
            <select id="nama_matkul" name="nama_matkul" required>
                <option value="">-- Pilih Matkul --</option>
                <?php foreach($matkul as $m):?>
                    <option value="<?= $m['id_matkul']; ?>" <?= (isset($peminjaman['nama_matkul']) && ($peminjaman['nama_matkul'] == $m['id_matkul'])) ? 'selected' : ''; ?> > <?= $m['nama_matkul'] ?></option>
                <?php endforeach; ?>
            </select>
          </div>
        </div>

        <div class="form-group">
          <div class="icon-container">
            <i class="fas fa-calendar-alt"></i> <!-- solid -->
          </div>
          <div class="input-container">
            <label for="tanggal-mulai">Tanggal & Jam Mulai</label>
            <input type="datetime-local" name="mulai" id="tanggal-mulai" value="<?= isset($peminjaman['mulai']) ? $peminjaman['mulai'] : ''?>"  required/>
          </div>
        </div>

        <div class="form-group">
          <div class="icon-container">
            <i class="fas fa-calendar-check"></i> <!-- solid -->
          </div>
          <div class="input-container">
            <label for="tanggal-selesai">Tanggal & Jam Selesai</label>
            <input type="datetime-local" name="selesai" id="tanggal-selesai" value="<?= isset($peminjaman['selesai']) ? $peminjaman['selesai'] : '' ?>" required/>
          </div>
        </div>

        <div class="form-group">
          <div class="icon-container">
            <i class="fas fa-door-open"></i> <!-- lebih representatif untuk ruangan -->
          </div>
          <div class="input-container">
            <label for="nama_ruang">Nama Ruangan</label>
            <select id="nama_ruang" name="nama_ruang" required>
                <option value="">-- Pilih Ruang --</option>
                <?php foreach($ruangan as $r):?>
                    <option value="<?= $r['id_ruangan']; ?>" <?= (isset($peminjaman['nama_ruang']) && ($peminjaman['nama_ruang'] == $r['id_ruangan'])) ? 'selected' : ''; ?> > <?= $r['nama_ruang'] ?></option>
                <?php endforeach; ?>
            </select>
          </div>
        </div>

        <div class="form-group">
          <div class="icon-container">
            <i class="fas fa-tools"></i> <!-- untuk sarana -->
          </div>
          <div class="input-container">
            <label for="sarana">Sarana</label>
            <textarea id="sarana" name="sarana" rows="4" required><?= (isset($peminjaman['sarana']) ? $peminjaman['sarana'] : '') ?></textarea>
          </div>
        </div>

          <?php if(session()->get('role') == 'admin'): ?>           
            <div class="form-group">
                <div class="icon-container">
                    <i class="fas fa-info-circle"></i> </div>
                <div class="input-container">
                    <label for="status-peminjaman">Status Peminjaman</label>
                    <select name="status_peminjaman" id="status-peminjaman" required>
                        <option value="Menunggu🔄" <?= (isset($peminjaman['status_peminjaman']) && ($peminjaman['status_peminjaman'] == 'Menunggu🔄')) ? 'selected' : ''; ?>>Menunggu🔄</option>
                        <option value="Disetujui✅" <?= (isset($peminjaman['status_peminjaman']) && ($peminjaman['status_peminjaman'] == 'Disetujui✅')) ? 'selected' : ''; ?>>Disetujui✅</option>
                        <option value="Ditolak❌" <?= (isset($peminjaman['status_peminjaman']) && ($peminjaman['status_peminjaman'] == 'Ditolak❌')) ? 'selected' : ''; ?>>Ditolak❌</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="icon-container">
                    <i class="fas fa-comment-alt"></i> </div>
                <div class="input-container">
                    <label for="komentar">Komentar</label>
                    <textarea id="komentar" name="komentar" rows="4" required><?= (isset($peminjaman['komentar']) ? $peminjaman['komentar'] : '') ?></textarea>
                </div>
            </div>
          <?php endif; ?>

        <button type="submit" name="submit" class="submit-btn"><?= isset($peminjaman['id_peminjaman']) ? 'Simpan Perubahan' : 'Ajukan Peminjaman' ?></button>
      </form>
    </div>
  </div>
</body>
</html>
