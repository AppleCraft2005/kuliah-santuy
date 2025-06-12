<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Reset Password Anda</title>
</head>
<body>
    <h2>Halo, <?= esc($username) ?></h2>
    <p>Kami menerima permintaan untuk mereset password akun Anda.</p>
    <p>Untuk mereset password Anda, silakan klik link di bawah ini:</p>
    <p><a href="<?= esc($resetLink) ?>">RESET PASSWORD SEKARANG</a></p>
    <p>Link ini akan kadaluarsa dalam 1 jam.</p>
    <p>Jika Anda tidak meminta reset password ini, silakan abaikan email ini.</p>
    <br>
    <p>Terima kasih,</p>
    <p>Tim SIRUANG Keren`</p>
</body>
</html>