<?php 
    require 'functions.php';

    if(deleteData($_GET["Id"]) > 0) {
        echo "
        <script>
            document.location.href = 'index.php'
            alert('Data berhasil dihapus');
        </script>";
    }
    else {
        echo "
        <script>
            document.location.href = 'index.php'
            alert('Data gagal ditambahkan');
        </script>";
    }
?>