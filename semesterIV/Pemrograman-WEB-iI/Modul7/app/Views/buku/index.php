<?= view('templates/header'); ?>
    <div class="container mt-5">
        <h1>List Buku</h1>
        <a href="<?= base_url('buku/tambah');?>" class="btn btn-primary mb-3">Tambah Buku</a>
        <table class="table table-hover table-striped table-bordered table-striped">
            <thead class="table-primary">
                <tr>
                    <th>ID</th>
                    <th>Aksi</th>
                    <th>Judul</th>
                    <th>Penulis</th>
                    <th>Penerbit</th>
                    <th>Tahun Terbit</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach($buku as $b): ?>
                    <tr>
                        <td><?= $b['id']; ?></td>
                        <td>
                            <a href="<?= base_url('/buku/edit/'.$b['id']); ?>">Edit</a> |
                            <a href="<?= base_url('/buku/hapus/'.$b['id']); ?>">Hapus</a>
                        </td>
                        <td><?= $b['judul']; ?></td>
                        <td><?= $b['penulis']; ?></td>
                        <td><?= $b['penerbit']; ?></td>
                        <td><?= $b['tahun_terbit']; ?></td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>

    </div>
</body>
</html>