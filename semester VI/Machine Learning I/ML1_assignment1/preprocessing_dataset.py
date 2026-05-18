# # import cv2
# # import os
# # import numpy as np

# # # Konfigurasi: "nama_kelas": (titik_X_awal, titik_Y_awal, ukuran_kotak_persegi)
# # # TUGASMU: Mencari angka yang paling pas untuk foto-fotomu!
# # CROP_CONFIGS = {
# #     "Tolong": (300, 600, 800),       # Contoh: Crop dari area dada ke bahu
# #     "TerimaKasih": (150, 600, 800), # Contoh: Crop area wajah ke dada
# #     "Maaf": (300, 550, 800),         # Mirip terima kasih posisinya
# #     "SamaSama": (150, 1200, 800)     # Contoh: Crop agak ke bawah (perut/dada bawah)
# # }

# # def crop_and_resize_by_class(image_path, class_name, target_size=256, to_grayscale=False):
# #     # 1. Baca gambar
# #     img = cv2.imread(image_path)
# #     if img is None:
# #         print(f"Gambar {image_path} tidak terbaca!")
# #         return None
        
# #     h, w = img.shape[:2]
    
# #     # Cek apakah kelas ada di konfigurasi
# #     if class_name not in CROP_CONFIGS:
# #         print(f"Kelas {class_name} tidak dikenali!")
# #         return None
        
# #     start_x, start_y, box_size = CROP_CONFIGS[class_name]
    
# #     # Proteksi agar area crop tidak melebihi batas ukuran asli gambar
# #     end_x = min(start_x + box_size, w)
# #     end_y = min(start_y + box_size, h)
    
# #     # 2. CROP area persegi yang luas
# #     cropped_img = img[start_y:end_y, start_x:end_x]
    
# #     # Proteksi tambahan jika gambar terpotong di pinggir sehingga tidak persegi sempurna
# #     # Kita padding sedikit dengan warna hitam agar tetap persegi sebelum di resize
# #     crop_h, crop_w = cropped_img.shape[:2]
# #     if crop_h != crop_w:
# #         max_side = max(crop_h, crop_w)
# #         canvas = np.zeros((max_side, max_side, 3), dtype=np.uint8)
# #         canvas[0:crop_h, 0:crop_w] = cropped_img
# #         cropped_img = canvas
    
# #     # 3. RESIZE paksa ke 256x256 
# #     resized_img = cv2.resize(cropped_img, (target_size, target_size))
    
# #     # 4. STANDARISASI CHANNEL
# #     if to_grayscale:
# #         final_img = cv2.cvtColor(resized_img, cv2.COLOR_BGR2GRAY)
# #     else:
# #         final_img = cv2.cvtColor(resized_img, cv2.COLOR_BGR2RGB) # OpenCV pakai BGR, kita ubah ke RGB
        
# #     # 5. NORMALISASI PIXEL (0-255 jadi 0-1)
# #     normalized_img = final_img.astype(np.float32) / 255.0
    
# #     return normalized_img

# # # --- CARA PAKAI ---
# # # hasil = crop_and_resize_by_class("Tolong_0000.jpg", "Tolong", target_size=256)

# # def proses_satu_folder(folder_input, folder_output, nama_kelas):
# #     # Buat folder output otomatis jika belum ada
# #     if not os.path.exists(folder_output):
# #         os.makedirs(folder_output)

# #     # Looping: Ambil semua file di dalam folder input
# #     for filename in os.listdir(folder_input):
# #         if filename.lower().endswith(('.png', '.jpg', '.jpeg')):
# #             path_input = os.path.join(folder_input, filename)
# #             path_output = os.path.join(folder_output, f"crop_{filename}")

# #             # Eksekusi gambar
# #             hasil_gambar = crop_and_resize_by_class(path_input, nama_kelas, target_size=256)

# #             if hasil_gambar is not None:
# #                 # Karena sebelumnya dinormalisasi (0-1), kita kembalikan ke (0-255) agar bisa di-save jadi file gambar (JPG/PNG)
# #                 gambar_untuk_disimpan = (hasil_gambar * 255).astype(np.uint8)
                
# #                 # OpenCV defaultnya membaca/menyimpan dalam BGR, kita kembalikan dari RGB ke BGR
# #                 gambar_untuk_disimpan = cv2.cvtColor(gambar_untuk_disimpan, cv2.COLOR_RGB2BGR)
                
# #                 # Simpan gambar
# #                 cv2.imwrite(path_output, gambar_untuk_disimpan)
# #                 print(f"Sukses memproses: {filename}")

# # # --- CARA PAKAI UNTUK SATU FOLDER PENUH ---
# # # Pastikan kamu menyiapkan folder sesuai kelasnya
# # proses_satu_folder("dataset/Maaf", "dataset_preprocessing/Maaf", "Maaf")

import cv2
import os
import numpy as np

CROP_CONFIGS = {
    "Tolong": (300, 600, 800),
    "TerimaKasih": (150, 600, 800),
    "Maaf": (300, 550, 800),
    "SamaSama": (150, 1200, 800)
}

def crop_and_resize_by_class(image_path, class_name, target_size=256, to_grayscale=False):

    # 1. Read image (OpenCV reads in BGR format)
    img = cv2.imread(image_path)
    if img is None:
        print(f"Image {image_path} could not be read!")
        return None
        
    h, w = img.shape[:2]
    
    if class_name not in CROP_CONFIGS:
        print(f"Class {class_name} not recognized!")
        return None
        
    start_x, start_y, box_size = CROP_CONFIGS[class_name]
    
    end_x = min(start_x + box_size, w)
    end_y = min(start_y + box_size, h)
    
    # 2. Crop image
    cropped_img = img[start_y:end_y, start_x:end_x]
    
    crop_h, crop_w = cropped_img.shape[:2]
    
    # Padding if crop is not square
    if crop_h != crop_w:
        max_side = max(crop_h, crop_w)
        canvas = np.zeros((max_side, max_side, 3), dtype=np.uint8)
        canvas[0:crop_h, 0:crop_w] = cropped_img
        cropped_img = canvas
    
    # 3. Resize image
    resized_img = cv2.resize(cropped_img, (target_size, target_size))
    
    # 4. Optional grayscale conversion
    if to_grayscale:
        final_img = cv2.cvtColor(resized_img, cv2.COLOR_BGR2GRAY)
    else:
        final_img = resized_img
    
    return final_img


def process_folder(input_folder, output_folder, class_name):

    if not os.path.exists(output_folder):
        os.makedirs(output_folder)

    for filename in os.listdir(input_folder):
        if filename.lower().endswith(('.png', '.jpg', '.jpeg')):
            
            input_path = os.path.join(input_folder, filename)
            output_path = os.path.join(output_folder, f"crop_{filename}")

            processed_image = crop_and_resize_by_class(
                input_path,
                class_name,
                target_size=256
            )

            if processed_image is not None:
                
                cv2.imwrite(output_path, processed_image)
                print(f"Successfully processed: {filename}")

# USAGE
process_folder("dataset/Maaf", "dataset_preprocessing/Maaf", "Maaf")

