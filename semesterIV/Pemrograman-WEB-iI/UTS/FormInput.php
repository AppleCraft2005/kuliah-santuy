<?php 
session_start();

if(isset($_POST['reset'])) {session_unset();}

$error = false;

if(isset($_POST['submit'])) {
    $Namalist = $_POST['nama'];
    $Gambarlist = $_FILES['gambar'];

    if (!isset($_SESSION['data'])) {
        $_SESSION['data'] = [];
    }

    for($i = 0; $i < count($Namalist); $i++) {
        $Nama = $Namalist[$i];
        $Gambar = $Gambarlist['name'][$i];
        $Gambartmp = $Gambarlist['tmp_name'][$i];

        $allowFilesType = ['png','jpg','jpeg','gif','webp'];
        $filePath = strtolower(pathinfo($Gambar, PATHINFO_EXTENSION));

        if(!in_array($filePath, $allowFilesType)) {
            $error = true;
            continue;
        }

        $folderGambar = "img/". $Gambar;
        move_uploaded_file($Gambartmp, $folderGambar);

        $_SESSION['data'][] = ['Nama' => $Nama, 'Gambar' => $folderGambar];

    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Form Dinamis: Nama & Gambar</h1>

    <?php if($error): ?>
        <p style="color: red;">Hanya file gambar yang diperbolehkan (jpg, jpeg, png, gif, webp).</h2>
    <?php endif; ?>

    <form action="" method="post" enctype="multipart/form-data">
        <div id="inputContainer">
            <div class="input-group" style="display: flex; gap: 20px;">
                <div>
                    <label for="nama">Nama: </label> <br>
                    <input type="text" id="nama" name="nama[]" required> <br>
                </div>
        
                <div>
                    <label for="gambar">Gambar: </label> <br> 
                    <input type="file" id="gambar" name="gambar[]" required> <br>
                </div>
            </div>
        </div>

        <br>

        <button type="button" onclick="tambahInput()">Tambah input</button> <br> <br>
        <button name="submit">Submit</button> <br><br>
        <button name="reset" formnovalidate onclick=" return confirm('Yakin ingin menghapus semua data?')">Reset Data</button>
    </form>    
    <br>

    <a href="TabelData.php">Lihat Tabel Data</a>

    <script>
        
        function tambahInput() {
            const container = document.getElementById('inputContainer');

            const group = document.createElement('div');
            group.className = 'input-group';

            group.innerHTML = `
            <div style="display: flex; gap: 20px;">
                <div>
                    <label>Nama:</label><br>
                    <input type="text" name="nama[]" required> <br>
                </div>
                <div>
                    <label>Gambar:</label><br>
                    <input type="file" name="gambar[]" required> <br>
                </div>
                <button type="button" onclick="hapusInput(this)">Hapus</button>
            </div>
            `;
            container.appendChild(group)
        }

        function hapusInput(btn) {
            btn.parentElement.remove()
        }
    </script>
</body>
</html>