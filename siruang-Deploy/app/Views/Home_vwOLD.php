<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIRUANG - Sistem Informasi Pemantauan & Peminjaman Ruangan Kelas</title>
    <link rel="stylesheet" href="<?= base_url('css/Home.css') ?>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
    <header>
        <div class="header-container">
            <div>
                <h1 class="site-title">SIRUANG</h1>
                <p class="site-description">SISTEM INFORMASI PEMANTAUAN & PEMINJAMAN RUANGAN KELAS</p>
            </div>
            <a href="/login" class="login-button">LOGIN</a>
        </div>
    </header>

    <main>
        <div class="schedule-card">
            <div class="card-header">
                <div class="icon-container">
                    <i class="fa-regular fa-calendar"></i>
                    Jadwal Ruangan Kelas
                </div>
            </div>
            <div class="schedule-table-container">
                <table class="schedule-table">
                    <thead>
                        <tr>
                            <th>
                                <div style="display: flex; align-items: center; gap: 0.25rem;">
                                    <svg class="icon" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                        <circle cx="12" cy="12" r="10"></circle>
                                        <polyline points="12 6 12 12 16 14"></polyline>
                                    </svg>
                                    <span>Waktu</span>
                                </div>
                            </th>
                            <th>08:00-08:50</th>
                            <th>08:50-09:40</th>
                            <th>09:40-10:30</th>
                            <th>10:30-11:20</th>
                            <th>11:20-12:10</th>
                            <th>12:10-13:00</th>
                            <th>13:00-13:50</th>
                            <th>13:50-14:40</th>
                            <th>14:40-15:30</th>
                            <th>15:30-16:20</th>
                            <th>16:20-17:10</th>
                            <th>17:10-18:00</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tbody>
                            <tr>
                                <td>Senin</td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Keterampilan Komunikasi - A14</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Keterampilan Komunikasi - A14</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Keterampilan Komunikasi - A14</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>                                    
                                    <div class="schedule-item">
                                        <p class="Matkul">Pemrograman Mobile P1 - A14</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Pemrograman Mobile P1 - A14</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td><div class="schedule-item">ISHOMA</div></td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Administrasi Sistem dan Jaringan P1 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Administrasi Sistem dan Jaringan P1 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Administrasi Sistem dan Jaringan P1 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>Selasa</td>
                                <td><div class="schedule-item"></div></td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Pemrograman Web II P2 - A14</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Pemrograman Web II P2 - A14</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                    <div class="schedule-item">
                                        <p class="Matkul">Rekayasa Perangkat Lunak P1 - A14</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>  
                                    <div class="schedule-item">
                                        <p class="Matkul">Rekayasa Perangkat Lunak P1 - A14</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Rekayasa Perangkat Lunak P1 - A14</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td><div class="schedule-item">ISHOMA</div></td>
                                <td><div class="schedule-item"></div></td>
                                <td><div class="schedule-item"></div></td>
                                <td><div class="schedule-item"></div></td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Praktikum Pemrograman Web II P2 - Lab. MTI</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Praktikum Pemrograman Web II P2 - Lab. MTI</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Praktikum Pemrograman Web II P2 - Lab. MTI</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>Rabu</td>
                                <td>                                    
                                    <div class="schedule-item">
                                        <p class="Matkul">Pemrograman Mobile P2 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>                                    
                                    <div class="schedule-item">
                                        <p class="Matkul">Pemrograman Mobile P2 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Keamanan Siber P2 - Lab. RPL</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Keamanan Siber P2 - Lab. RPL</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Keamanan Siber P2 - Lab. RPL</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td><div class="schedule-item">ISHOMA</div></td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Rekayasa Perangkat Lunak P2 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Rekayasa Perangkat Lunak P2 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Rekayasa Perangkat Lunak P2 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td><div class="schedule-item"></div></td>
                                <td><div class="schedule-item"></div></td>
                                <td><div class="schedule-item"></div></td>
                            </tr>
                            <tr>
                                <td>Kamis</td>
                                <td><div class="schedule-item"></div></td>
                                <td><div class="schedule-item"></div></td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Bahasa Indonesia - A14</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Bahasa Indonesia - A14</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Bahasa Indonesia - A14</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td><div class="schedule-item">ISHOMA</div></td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Administrasi Sistem dan Jaringan P2 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Administrasi Sistem dan Jaringan P2 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Administrasi Sistem dan Jaringan P2 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Praktikum Pemrograman Mobile P1 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Praktikum Pemrograman Mobile P1 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Praktikum Pemrograman Mobile P1 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>Jumat</td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Keamanan Siber P1 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Keamanan Siber P1 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Keamanan Siber P1 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td><div class="schedule-item"></div></td>
                                <td><div class="schedule-item"></div></td>
                                <td><div class="schedule-item">ISHOMA</div></td>
                                <td><div class="schedule-item">ISHOMA</div></td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Integrasi Sistem P1 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                    <div class="schedule-item">
                                        <p class="Matkul">Integrasi Sistem P2 - Lab. RPL</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Integrasi Sistem P1 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                    <div class="schedule-item">
                                        <p class="Matkul">Integrasi Sistem P2 - Lab. RPL</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                                <td>
                                    <div class="schedule-item">
                                        <p class="Matkul">Integrasi Sistem P1 - Lab. Big Data</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                    <div class="schedule-item">
                                        <p class="Matkul">Integrasi Sistem P2 - Lab. RPL</p>
                                        <p class="Dosen">Samsul Arif, S.Kom</p>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </tbody>
                </table>
            </div>

            <div class="card-footer">
                <div class="status-indicators">
                    <div class="status-item">
                        <span class="status-text" style="color: #ef4444;">* Jadwal Kuliah Bisa Berubah Sewaktu-waktu</span>
                    </div>
                </div>
                <a href="<?= base_url('/peminjaman') ?>" class="list-button">LIHAT DAFTAR PEMINJAMAN</a>
            </div>
        </div>
    </main>
</body>
</html>