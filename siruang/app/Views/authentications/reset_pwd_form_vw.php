<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>
    <link rel="stylesheet" href="<?= base_url('css/resetForgotPwdForm.css') ?>">
</head>
<body>
    <div class="container">
        <h1 class="title">SIRUANG: SISTEM INFORMASI PEMANTAUAN & PEMINJAMAN RUANGAN PSTI</h1>
        <div class="form-container">
            <h2>Reset Password Anda</h2>
    
            <?php if(session()->getFlashdata('validation')): ?>
                <?= session()->getFlashdata('validation')->listErrors() ?>
            <?php endif; ?>
    
            <form action="<?= route_to('reset_password') ?>" method="post">
                <?= csrf_field() ?>
                <input type="hidden" name="token" value="<?= esc($token) ?>">
                <div class="form-group">
                    <label for="password">Password Baru</label>
                    <input type="password" id="password" name="password" placeholder="Masukkan Password Baru" required>
                </div>
                <div class="form-group">
                    <label for="confirm_password">Konfirmasi Password Baru</label>
                    <input type="password" id="confirm_password" name="confirm_password" placeholder="Masukkan Konfirmasi Password Baru" required>
                </div>
                <button type="submit" class="submit-button">Reset Password</button>
            </form>
        </div>
    </div>
</body>
</html>