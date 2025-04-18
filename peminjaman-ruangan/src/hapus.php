<?php 
session_start();
$userRole = $_SESSION['role'];

    require 'functions.php';
    if(deleteData($_GET["id_peminjaman"]) > 0) {
        if($userRole == "admin") {
            echo "
                <script>
                    document.location.href = '../admin/dashboard.php'
                    alert('Data berhasil dihapus');
                </script>";
        }
        else{
            echo "
            <script>
                document.location.href = '../user/dashboard.php'
                alert('Data berhasil dihapus');
            </script>";
        }
    }
    else {
        echo "
        <script>
            document.location.href = '../index.php'
            alert('Data peminjaman gagal dihapus');
        </script>";
    }
?>