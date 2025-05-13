<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
    <style>
        .jumbotron-custom {
            color: black;
            border-radius: 20px;
            padding: 3rem;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <nav class=" navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid container">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link active" aria-current="page" href="http://localhost:8080/">Home</a>
                    <a class="nav-link" href="http://localhost:8080/home/profil">Profil</a>
                </div>
            </div>
        </div>
    </nav>
    <div class="container my-5">
        <div class="jumbotron-custom text-center">
            <h1 class="display-5 fw-bold mb-3">Halo, Selamat Datang! 👋</h1>
            <p class="lead">
                Website ini dibuat oleh saya sendiri <strong><?= $nama; ?></strong> dengan NIM <strong><?= $nim; ?></strong>.
            </p>
            <hr class="my-4 border-dark" />
            <p>Silakan kunjungi halaman profil untuk melihat lebih lengkap tentang saya!</p>
            <a href="http://localhost:8080/home/profil" class="btn bg-primary text-white mt-2">Lihat Profil</a>
        </div>
    </div>
</body>
</html>