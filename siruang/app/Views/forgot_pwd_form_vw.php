<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lupa Password</title>
    <style>
        /* Styling dasar, sesuaikan dengan desain Anda */
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; }
        .form-container { background-color: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); width: 100%; max-width: 400px; }
        h2 { text-align: center; margin-bottom: 20px; color: #333; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; color: #555; }
        input[type="email"] { width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box; }
        .submit-button { width: 100%; padding: 10px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 1em; }
        .submit-button:hover { background-color: #0056b3; }
        .error-message { color: red; font-size: 0.85em; margin-top: 5px; }
        .alert { padding: 10px; margin-bottom: 10px; border-radius: 4px; }
        .alert.error { background-color: #f8d7da; color: #721c24; border: 1px solid #f5c6cb; }
        .alert.success { background-color: #d4edda; color: #155724; border: 1px solid #c3e6cb; }
        .alert.info { background-color: #d1ecf1; color: #0c5460; border: 1px solid #bee5eb; }
        .back-link { text-align: center; margin-top: 15px; font-size: 0.9em; }
        .back-link a { color: #007bff; text-decoration: none; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Lupa Password</h2>
        <p>Masukkan alamat email Anda untuk menerima link reset password.</p>

        <?php if(session()->getFlashdata('error')): ?>
            <div class="alert error"><?= esc(session()->getFlashdata('error')) ?></div>
        <?php endif; ?>
        <?php if(session()->getFlashdata('success')): ?>
            <div class="alert success"><?= esc(session()->getFlashdata('success')) ?></div>
        <?php endif; ?>
        <?php if(session()->getFlashdata('info')): ?>
            <div class="alert info"><?= esc(session()->getFlashdata('info')) ?></div>
        <?php endif; ?>

        <form action="<?= base_url('forgot-pwd') ?>" method="post">
            <?= csrf_field() ?>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" value="<?= old('email') ?>" required>
                <?php if (session('validation') && session('validation')->hasError('email')): ?>
                    <p class="error-message"><?= session('validation')->getError('email') ?></p>
                <?php endif; ?>
            </div>
            <button type="submit" class="submit-button">Kirim Link Reset</button>
        </form>
        <div class="back-link">
            <a href="<?= base_url('login') ?>">Kembali ke Halaman Login</a>
        </div>
    </div>
</body>
</html>