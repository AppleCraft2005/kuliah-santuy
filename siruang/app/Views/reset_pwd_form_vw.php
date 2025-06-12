<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>
    <style>
        /* Styling dasar, sesuaikan dengan desain Anda */
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; }
        .form-container { background-color: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); width: 100%; max-width: 400px; }
        h2 { text-align: center; margin-bottom: 20px; color: #333; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; color: #555; }
        input[type="password"] { width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box; }
        .submit-button { width: 100%; padding: 10px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 1em; }
        .submit-button:hover { background-color: #0056b3; }
        .error-message { color: red; font-size: 0.85em; margin-top: 5px; }
        .alert { padding: 10px; margin-bottom: 10px; border-radius: 4px; }
        .alert.error { background-color: #f8d7da; color: #721c24; border: 1px solid #f5c6cb; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Reset Password Anda</h2>

        <?php if(session()->getFlashdata('error')): ?>
            <div class="alert error"><?= esc(session()->getFlashdata('error')) ?></div>
        <?php endif; ?>

        <form action="<?= base_url('reset-password') ?>" method="post">
            <?= csrf_field() ?>
            <input type="hidden" name="token" value="<?= esc($token) ?>">

            <div class="form-group">
                <label for="password">Password Baru</label>
                <input type="password" id="password" name="password" required>
                <?php if (session('validation') && session('validation')->hasError('password')): ?>
                    <p class="error-message"><?= session('validation')->getError('password') ?></p>
                <?php endif; ?>
            </div>

            <div class="form-group">
                <label for="confirm_password">Konfirmasi Password Baru</label>
                <input type="password" id="confirm_password" name="confirm_password" required>
                <?php if (session('validation') && session('validation')->hasError('confirm_password')): ?>
                    <p class="error-message"><?= session('validation')->getError('confirm_password') ?></p>
                <?php endif; ?>
            </div>

            <button type="submit" class="submit-button">Reset Password</button>
        </form>
    </div>
</body>
</html>