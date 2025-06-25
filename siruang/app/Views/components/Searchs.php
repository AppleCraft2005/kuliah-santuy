                <div class="search-container">
                    <form action="<?= base_url(route_to($base_url_for_search)) ?>" method="get" class="search-form">
                        <div class="input-ruangan-tanggal-search">
                            <div class="search-group">
                                <label for="search_ruangan">Ruangan:</label>
                                <select id="search_ruangan" name="ruangan">
                                    <option value="">-- Pilih Ruangan --</option>
                                    <?php foreach($ruangan_list as $r):?>
                                        <option value="<?= esc($r['id_ruangan']); ?>" > <?= esc($r['nama_ruang']) ?> </option>
                                    <?php endforeach; ?>
                                </select>
                            </div>
                            
                            <div class="search-group">
                                <label for="search_date">Tanggal:</label>
                                <input type="date" id="search_date" name="tanggal">
                            </div>
                        </div>
                        <button type="submit" class="search-btn"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </form>
                </div>