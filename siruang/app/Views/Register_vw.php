<!DOCTYPE html>
<html lang="id">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Register - SIRUANG</title>
  <link rel="stylesheet" href="<?= base_url('css/Register.css') ?>" />
</head>
<body>
  <div class="main-layout">
    <div class="left-content">
      <div class="container">
        <h1 class="title">SIRUANG: SISTEM INFORMASI PEMANTAUAN & PEMINJAMAN RUANGAN KELAS</h1>
        <div class="register-card">
          <h2 class="register-title">Register</h2>
          <?php if(session()->getFlashdata('validation')): ?>
            <p><?= session()->getFlashdata('validation')->listErrors(); ?></p>
          <?php endif; ?> 
          <br>
          <form action="/register/auth" method="post">
            <div class="form-group">
              <label for="username">Username</label>
              <input type="text" id="username" name="username" class="form-control" placeholder="Masuk username" required />
            </div>
            <div class="form-group">
              <label for="email">Email</label>
              <input type="email" id="email" name="email" class="form-control" placeholder="Masuk email" required />
            </div>
            <div class="form-group">
              <label for="password">Password</label>
              <input type="password" id="password" name="password" class="form-control" placeholder="Masuk password" required />
            </div>
            <div class="form-group">
              <label for="confirm_password">Confirm Password</label>
              <input type="password" id="confirm_password" name="confirm_password" class="form-control" placeholder="Confirm password" required />
            </div>
            <button type="submit" class="btn-login" name="submit">Daftar</button>
          </form>
          <p class="register-text">Sudah punya akun? <a href="<?= base_url('login') ?>" class="register-link">Login</a></p>
        </div>
      </div>
    </div>
    <div class="right-background"></div>
  </div>
</body>
</html>