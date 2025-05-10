<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
    <style>
        .profile-img {
            width: 100%;
            height: 300px;
            object-fit: cover;
            object-position: center 40%;
        }
        .card {
            border-radius: 15px;
        }
        .image-container{
            text-align: center;
            overflow: hidden;
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
            <a class="nav-link" href="http://localhost:8080/profil">Profil</a>
        </div>
        </div>
    </div>
    </nav>
    
    <div class="container ">
        <h1 class="text-center mb-4">Berikut Profil Lengkap Saya:</h1>
        <div class="card mx-auto shadow " style="max-width: 500px;">
            <div class="image-container">
                <img src="http://localhost:8080/img/jovanimg.jpg" alt="Foto Profil" class="profile-img mb-2" />
            </div>
            <div class="card-body p-4">
                <table cellpadding="5">
                    <tr>
                        <th>Nama Lengkap</th>
                        <td>: Jovan Gilbert Natamasindah</td>
                    </tr>
                    <tr>
                        <th>NIM</th>
                        <td>: 2310817310002</td>
                    </tr>                    
                    <tr>
                        <th>Asal Prodi</th>
                        <td>: Teknologi Informasi</td>
                    </tr>                    
                    <tr>
                        <th>Hobi</th>
                        <td>: Badminton, Baca Manga, Main Game</td>
                    </tr>                    
                    <tr>
                        <th>Skill</th>
                        <td>: Editing Video</td>
                    </tr>                    
                </table>
                <!-- <p><strong>Nama Lengkap:</strong> <?= $nama; ?></p>
                <p><strong>NIM:</strong> <?= $nim; ?></p>
                <p><strong>Asal Prodi:</strong> <?= $prodi; ?></p>
                <p><strong>Hobi:</strong> <?= $hobi; ?></p>
                <p><strong>Skill:</strong> <?= $skill; ?></p> -->
            </div>
        </div>
    </div>

</body>
</html>