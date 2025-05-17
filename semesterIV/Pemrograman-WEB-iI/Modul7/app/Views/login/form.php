<?= view('templates/header'); ?>
    <div class="container mt-5">
        <div class="row justify-content-center ">
            <div class="col-md-4 border py-5">
                <H1 class="text-center mb-4">LOGIN </H1>
                <?php if(session()->getFlashdata('error')): ?>
                    <h6 class="alert alert-danger"><?= session()->getFlashdata('error'); ?></h6>
                <?php endif; ?>
                <form action="<?= base_url('login/proses') ?>" method="post">
                    <div class="mb-3">
                        <label for="username">Username</label>
                        <input type="text" name="username" id="username" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="password">Password</label>
                        <input type="password" name="password" id="password" class="form-control" required>
                    </div>
                    <button class="btn btn-info w-100 text-white " type="submit">Login</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>