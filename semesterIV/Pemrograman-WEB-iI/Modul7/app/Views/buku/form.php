<?= view('templates/header'); ?>
    <div class="container mt-5">
        <div class="card">
            <div class="card-body">
                <h1 class="card-title text-center"><?= $buku ? 'Edit Buku' : 'Tambah Buku'; ?></h1>
                <form action="<?= base_url('buku/simpan'); ?>" method="post">
                    <?php if ($buku): ?>
                        <input type="hidden" name="id" value="<?= esc($buku['id']) ?>">
                    <?php endif; ?>  
                    <div class="mb-3">
                        <label for="judul"> Judul Buku</label>
                        <input type="text" name="judul" id="judul" class="form-control" value="<?= $buku['judul'] ?? ''; ?> "required> 

                    </div>
                    <div class="mb-3">
                        <label for="penulis"> Penulis Buku</label>
                        <input type="text" name="penulis" id="penulis" class="form-control" value="<?= $buku['penulis'] ?? ''; ?> "required> 
                    </div>
                    <div class="mb-3">
                        <label for="penerbit"> Penerbit Buku</label>
                        <input type="text" name="penerbit" id="penerbit" class="form-control" value="<?= $buku['penerbit'] ?? ''; ?> "required> 
                    </div>
                    <div class="mb-3">
                        <label for="tahun_terbit"> Tahun Terbit Buku</label>
                        <input type="text" name="tahun_terbit" id="tahun_terbit" class="form-control" value="<?= $buku['tahun_terbit'] ?? ''; ?> "required> 
                    </div>
                    <button class="btn btn-success w-100" name="submit">Submit</button>
                </form>

            </div>
        </div>
    </div>
</body>
</html>