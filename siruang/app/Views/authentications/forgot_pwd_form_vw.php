<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lupa Password</title>
    <link rel="stylesheet" href="<?= base_url('css/resetForgotPwdForm.css') ?>">
</head>
<body>
    <div class="container">
        <h1 class="title">SIRUANG: SISTEM INFORMASI PEMANTAUAN & PEMINJAMAN RUANGAN PSTI</h1>
        <div class="form-container">
            <h2>Lupa Password</h2>
            <p>Masukkan alamat email Anda untuk menerima link reset password.</p>
    
            <?php if(session()->getFlashdata('error')): ?>
                <div class="alert error"><?= esc(session()->getFlashdata('error')) ?></div>
            <?php endif; ?>
            <?php if(session()->getFlashdata('success')): ?>
                <div class="alert success"><?= esc(session()->getFlashdata('success')) ?></div>
            <?php endif; ?>
    
            <form action="<?= route_to('send_reset_link') ?>" method="post">
                <?= csrf_field() ?>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" value="<?= old('email') ?>" placeholder="Masukkan Email Anda" required>
                    <?php if (session('validation') && session('validation')->hasError('email')): ?>
                        <p class="error-message"><?= session('validation')->getError('email') ?></p>
                    <?php endif; ?>
                </div>
                <button type="submit" class="submit-button">Kirim Link Reset</button>
            </form>
            <div class="back-link">
                <a href="<?= route_to('login') ?>">Kembali ke Halaman Login</a>
            </div>
        </div>
    </div>
</body>
</html>