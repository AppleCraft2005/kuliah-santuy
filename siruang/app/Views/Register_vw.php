<!DOCTYPE html>
<html lang="id">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Register - SIRUANG</title>
  <link rel="stylesheet" href="<?= base_url('css/Register.css') ?>" />
</head>
<body>
  <div class="container">
    <div class="left">
      <div class="form-box">
        <h3>SIRUANG: SISTEM INFORMASI PEMANTAUAN &<br>PEMINJAMAN RUANGAN KELAS</h3>
        <h2>REGISTER</h2>
        <?php if(session()->getFlashdata('validation')): ?>
            <p><?= session()->getFlashdata('validation')->listErrors(); ?></p>
        <?php endif; ?>
        <form action="/register/auth" method="post">
          <label for="username">Username</label>
          <input type="text" id="username" name="username" placeholder="Masuk username" required />

          <label for="email">Email</label>
          <input type="email" id="email" name="email" placeholder="Masuk email" required />

          <label for="password">Password</label>
          <input type="password" id="password" name="password" placeholder="Masuk password" required />

          <label for="confirm_password">Confirm Password</label>
          <input type="password" id="confirm_password" name="confirm_password" placeholder="Confirm password" required />

          <button type="submit" name="submit">DAFTAR</button>
          <p>Punya akun? <a href="<?= base_url('login') ?>">Login</a></p>
        </form>
      </div>
    </div>
    <div class="right">
      <img src="<?= base_url('img/Register.png') ?>" alt="Gambar Samping">
    </div>
  </div>
</body>
</html>
