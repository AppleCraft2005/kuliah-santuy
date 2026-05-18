<?= view('templates/header'); ?>
    <div class="container mt-5">
        <div class="card">
            <div class="card-body">
                <h1 class="card-title text-center"><?= $buku ? 'Edit Buku' : 'Tambah Buku'; ?></h1>

                <?php if(session()->getFlashdata('validation')): ?>
                    <h5 class="alert alert-danger"><?= session()->getFlashdata('validation')->listErrors(); ?></h5>
                <?php endif; ?>

                <form action="<?= base_url('buku/simpan'); ?>" method="post">
                    <?php if ($buku): ?>
                        <input type="hidden" name="id" value="<?= esc($buku['id']) ?>">
                    <?php endif; ?>  
                    <div class="mb-3">
                        <label for="judul"> Judul Buku</label>
                        <input type="text" name="judul" id="judul" class="form-control" value="<?= $buku['judul'] ?? ''; ?> "> 
                    </div>
                    <div class="mb-3">
                        <label for="penulis"> Penulis Buku</label>
                        <input type="text" name="penulis" id="penulis" class="form-control" value="<?= $buku['penulis'] ?? ''; ?> "> 
                    </div>
                    <div class="mb-3">
                        <label for="penerbit"> Penerbit Buku</label>
                        <input type="text" name="penerbit" id="penerbit" class="form-control" value="<?= $buku['penerbit'] ?? ''; ?> "> 
                    </div>
                    <div class="mb-3">
                        <label for="tahun_terbit"> Tahun Terbit Buku</label>
                        <input type="number" name="tahun_terbit" id="tahun_terbit" class="form-control" value="<?= $buku['tahun_terbit'] ?? ''; ?> "> 
                    </div>
                    <button class="btn btn-success w-100" name="submit">Submit</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>