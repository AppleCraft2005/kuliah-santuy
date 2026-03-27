import cv2
import os
import glob # Library untuk mencari file dengan pola tertentu

def video_to_frames_dynamic(video_path, output_folder, label_name, target_fps=5):
    """
    Mengambil frame dari video untuk GESTUR BERGERAK.
    MELANJUTKAN penomoran jika di folder sudah ada foto sebelumnya.
    """
    
    # 1. Cek File Video
    if not os.path.exists(video_path):
        print(f"Error: Video '{video_path}' tidak ditemukan!")
        return

    # 2. Buat Folder Output jika belum ada
    if not os.path.exists(output_folder):
        os.makedirs(output_folder)
        print(f"Folder '{output_folder}' dibuat.")

    # ============================================================
    # 🧠 LOGIKA ANTI-OVERWRITE (TIMPA)
    # ============================================================
    # Cari semua file jpg yang berawalan nama label di folder itu
    search_pattern = os.path.join(output_folder, f"{label_name}_*.jpg")
    existing_files = glob.glob(search_pattern)
    
    # Mulai hitungan dari jumlah file yang sudah ada
    saved_count = len(existing_files)
    
    print(f"Ditemukan {saved_count} foto lama di folder '{output_folder}'.")
    print(f"Foto baru akan dimulai dari nama: {label_name}_{saved_count:04d}.jpg")
    # ============================================================

    # 3. Baca Video & Deteksi FPS
    cap = cv2.VideoCapture(video_path)
    fps = cap.get(cv2.CAP_PROP_FPS)
    fps = round(fps)
    if fps == 0: fps = 30 # Fallback
    
    print(f"Processing video: {video_path} (Video Asli: {fps} FPS)")
    
    # ============================================================
    # 🔥 LOGIKA BARU UNTUK GESTUR BERGERAK
    # ============================================================
    # Menghitung interval untuk mendapatkan target foto per detik.
    # Contoh: Video 30 FPS. Target 5 foto/detik. 30 / 5 = 6.
    # Artinya ambil 1 foto setiap melewati 6 frame.
    frame_interval = int(fps / target_fps)
    
    # Jaga-jaga agar interval tidak 0 jika target_fps lebih besar dari fps asli
    if frame_interval == 0: 
        frame_interval = 1 
        
    print(f"Target: {target_fps} foto/detik. (Menyimpan 1 foto setiap {frame_interval} frame)")
    # ============================================================
    
    frame_count = 0
    new_photos_count = 0
    
    while cap.isOpened():
        ret, frame = cap.read()
        if not ret: break
        
        # Ambil frame sesuai interval yang baru
        if frame_count % frame_interval == 0:
            # Nama file menggunakan saved_count yang terus bertambah
            filename = f"{label_name}_{saved_count:04d}.jpg"
            save_path = os.path.join(output_folder, filename)
            
            cv2.imwrite(save_path, frame)
            
            # Update counter
            saved_count += 1
            new_photos_count += 1
            
        frame_count += 1

    cap.release()
    print("------------------------------------------------")
    print(f"SUKSES! {new_photos_count} foto BARU ditambahkan.")
    print(f"Total foto di folder sekarang: {saved_count}")

# ================= KONFIGURASI =================

# Video BARU yang berisi gestur bergerak (misal huruf J dalam BISINDO)
input_video = "video_bisindo_J.mp4" 

# Folder output
output_dir = "dataset/BISINDO_J"

# Label 
label = "J"

# Jalankan fungsi dengan menentukan target_fps (misal ingin 5 foto per detik)
video_to_frames_dynamic(input_video, output_dir, label, target_fps=5)