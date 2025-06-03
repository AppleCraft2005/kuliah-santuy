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
            <button class="login-button"><a href="/login">LOGIN</a></button>
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


                        </tr>
                    </thead>
                    <tbody>
                        <tbody>
                            <tr>
                                <td>Senin</td>
                                <td><div class="empty-cell">
                                    <p>Keterampilan Komunikasi - A14</p>
                                    <p>Andrew Stewars, S.Kom</p>
                                </div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell">
                                    <p>Keterampilan Komunikasi - A14</p>
                                    <p>Andrew Stewars, S.Kom</p>
                                </div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell">
                                    <p>Keterampilan Komunikasi - A14</p>
                                    <p>Andrew Stewars, S.Kom</p>
                                </div></td>
                            </tr>
                            <tr>
                                <td>Selasa</td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell">
                                    <p>Keterampilan Komunikasi - A14</p>
                                    <p>Andrew Stewars, S.Kom</p>
                                </div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                            </tr>
                            <tr>
                                <td>Rabu</td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell">
                                    <p>Keterampilan Komunikasi - A14</p>
                                    <p>Andrew Stewars, S.Kom</p>
                                </div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                            </tr>
                            <tr>
                                <td>Kamis</td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell">
                                    <p>Keterampilan Komunikasi - A14</p>
                                    <p>Andrew Stewars, S.Kom</p>
                                </div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                            </tr>
                            <tr>
                                <td>Jumat</td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell">
                                    <p>Keterampilan Komunikasi - A14</p>
                                    <p>Andrew Stewars, S.Kom</p>
                                </div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell"></div></td>
                                <td><div class="empty-cell">
                                    <p>Keterampilan Komunikasi - Lab. Big Data</p>
                                    <p>Andrew Stewars, S.Kom</p>
                                </div></td>
                                <td><div class="empty-cell"></div></td>
                            </tr>
                        </tbody>

                                    </div>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div class="card-footer">
                <div class="status-indicators">
                    <div class="status-item">
                        <div class="status-dot" style="background-color: #22c55e;"></div>
                        <span class="status-text">Kelas Kosong</span>
                    </div>
                    <div class="status-item">
                        <div class="status-dot" style="background-color: #3b82f6;"></div>
                        <span class="status-text">Waktu Tersedia</span>
                    </div>
                    <div class="status-item">
                        <div class="status-dot" style="background-color: #eab308;"></div>
                        <span class="status-text">Tersedia Hari Jumat</span>
                    </div>
                    <div class="status-item">
                        <div class="status-dot" style="background-color: #ef4444;"></div>
                        <span class="status-text">Keterangan/Info Ruangan</span>
                    </div>
                </div>

                <button class="register-button"><a href="<?= base_url('/peminjaman') ?>">LIHAT DAFTAR PEMINJAMAN</a></button>
            </div>
        </div>
    </main>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            const dayButtons = document.querySelectorAll('.day-button');
            
            dayButtons.forEach(button => {
                button.addEventListener('click', function() {
                    dayButtons.forEach(btn => btn.classList.remove('active'));
                    
                    this.classList.add('active');
                    
                });
            });
        });
    </script>
</body>
</html>