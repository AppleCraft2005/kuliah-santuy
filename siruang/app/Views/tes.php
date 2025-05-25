<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Yeayyy kamu berhasil Login</h1>
    <h2>Selamat Datang <?= session()->get('username'); ?></h2>
    <a href="<?= base_url('/logout') ?>">LogOut</a>
</body>
</html>