<form method="GET" action="">
        <label for="ruangan">Pilih Ruangan:</label>
        <select name="ruangan" id="ruangan">
            <option value="">-- Semua Ruangan --</option>
            <?php foreach($ruang as $r): ?>
                <option value="<?= $r['id_ruangan']; ?>" <?= (($_GET['ruangan'] ?? '') == $r['id_ruangan']) ? 'selected' : '' ?>>
                    <?= $r['nama_ruang']; ?>
                </option>
            <?php endforeach; ?>
        </select>

        <label for="tanggal">Pilih Tanggal:</label>
        <select name="hari" id="hari">
            <option value="">-- Semua Hari --</option>
            <?php 
            $days = ['Monday' => 'Senin', 'Tuesday' => 'Selasa', 'Wednesday' => 'Rabu', 'Thursday' => 'Kamis', 'Friday' => 'Jumat', 'Saturday' => 'Sabtu', 'Sunday' => 'Minggu'];
            foreach($days as $eng => $indo): 
            ?>
                <option value="<?= $eng ?>" <?= (($_GET['hari'] ?? '') == $eng) ? 'selected' : '' ?>>
                    <?= $indo ?>
                </option>
            <?php endforeach; ?>
        </select>

        <button type="submit">Filter</button>
    </form>