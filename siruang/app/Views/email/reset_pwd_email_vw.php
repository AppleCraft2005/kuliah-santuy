<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Reset Password Anda</title>
</head>
<body>
    <h2>Halo, <?= esc($username) ?></h2>
    <p>Kami menerima permintaan untuk mereset password akun Anda.</p>
    <p>Silahkan klik link dibawah ini untuk melakukan reset password:</p>
    <p><a href="<?= esc($resetLink) ?>">RESET PASSWORD</a></p>
    <p>Link ini akan kadaluarsa dalam 1 jam.</p>
    <p>Jika Anda tidak meminta reset password ini, silakan abaikan email ini.</p>
    <br>
    <p>Terima kasih,</p>
    <p>Tim SIRUANG Keren`</p>
</body>
</html>