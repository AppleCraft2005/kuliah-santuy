# import cv2
# import mediapipe as mp
# import os
# import pandas as pd

# # Inisialisasi MediaPipe
# mp_hands = mp.solutions.hands
# mp_drawing = mp.solutions.drawing_utils

# hands = mp_hands.Hands(
#     static_image_mode=True,
#     max_num_hands=1,
#     min_detection_confidence=0.5
# )

# # input dan output
# dataset_path = "dataset_preprocessing/Maaf"
# csv_file = "dataset_preprocessing.csv"

# data = []

# for img_name in os.listdir(dataset_path):

#     img_path = os.path.join(dataset_path, img_name)

#     image = cv2.imread(img_path)

#     if image is None:
#         continue

#     image_rgb = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)

#     result = hands.process(image_rgb)

#     if result.multi_hand_landmarks:

#         print(f"Hand detected in {img_name}")

#         for hand_landmarks in result.multi_hand_landmarks:

#             row = []

#             for lm in hand_landmarks.landmark:
#                 row.append(lm.x)
#                 row.append(lm.y)

#             row.append("Maaf")

#             data.append(row)

#             # Landmark overlay
#             mp_drawing.draw_landmarks(
#                 image,
#                 hand_landmarks,
#                 mp_hands.HAND_CONNECTIONS
#             )

#     else:
#         print(f"No hand detected in {img_name}")

#     # tampilkan gambar
#     cv2.namedWindow("Hand Landmark", cv2.WINDOW_NORMAL)
#     cv2.imshow("Hand Landmark", image)

#     key = cv2.waitKey(500)

#     if key == 27:
#         break

# cv2.destroyAllWindows()

# # membuat nama kolom
# columns = []

# for i in range(21):
#     columns.append(f"x{i}")
#     columns.append(f"y{i}")

# columns.append("label")

# df = pd.DataFrame(data, columns=columns)

# # ==============================
# # CEK APAKAH CSV SUDAH ADA
# # ==============================

# file_exists = os.path.exists(csv_file)

# df.to_csv(
#     csv_file,
#     mode='a',              # append
#     header=not file_exists, # header hanya jika file baru
#     index=False
# )

# print("Jumlah data baru:", len(data))
# print("Dataset berhasil ditambahkan ke CSV")




# import cv2
# import mediapipe as mp
# import os
# import pandas as pd

# # Inisialisasi MediaPipe
# mp_hands = mp.solutions.hands
# mp_drawing = mp.solutions.drawing_utils

# hands = mp_hands.Hands(
#     static_image_mode=True,
#     max_num_hands=1,
#     min_detection_confidence=0.5
# )

# # Daftar kategori sesuai gestur statis yang kita pilih
# categories = ["TerimaKasih", "Maaf", "SamaSama", "Tolong"]
# base_dataset_path = "dataset_preprocessing"
# csv_file = "dataset_Preprocessing.csv"

# data = []

# for label in categories:
#     dataset_path = os.path.join(base_dataset_path, label)
    
#     # Lewati jika folder belum dibuat
#     if not os.path.exists(dataset_path):
#         print(f"Folder {dataset_path} tidak ditemukan, lanjut ke folder berikutnya.")
#         continue

#     print(f"\nMemproses gestur: {label}...")
    
#     for img_name in os.listdir(dataset_path):
#         img_path = os.path.join(dataset_path, img_name)
#         image = cv2.imread(img_path)

#         if image is None:
#             continue

#         # Konversi BGR ke RGB untuk MediaPipe
#         image_rgb = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
#         result = hands.process(image_rgb)

#         if result.multi_hand_landmarks:
#             for hand_landmarks in result.multi_hand_landmarks:
#                 row = []
                
#                 # Ambil koordinat pergelangan tangan (landmark 0) sebagai titik pusat (0,0)
#                 wrist_x = hand_landmarks.landmark[0].x
#                 wrist_y = hand_landmarks.landmark[0].y

#                 for lm in hand_landmarks.landmark:
#                     # Jadikan posisi landmark relatif terhadap pergelangan tangan
#                     rel_x = lm.x - wrist_x
#                     rel_y = lm.y - wrist_y
#                     row.append(rel_x)
#                     row.append(rel_y)

#                 row.append(label)
#                 data.append(row)

#                 # Menampilkan visualisasi (bisa di-comment jika ingin proses cepat)
#                 mp_drawing.draw_landmarks(image, hand_landmarks, mp_hands.HAND_CONNECTIONS)
#                 cv2.imshow("Hand Landmark", image)
                
#                 if cv2.waitKey(1) == 27: # Tekan ESC untuk stop paksa
#                     break
#         else:
#             print(f"  -> Tangan tidak terdeteksi di {img_name}")

# cv2.destroyAllWindows()

# # Membuat nama kolom (x0, y0, x1, y1, ... x20, y20, label)
# columns = []
# for i in range(21):
#     columns.extend([f"x{i}", f"y{i}"])
# columns.append("label")

# # Menyimpan ke CSV
# df = pd.DataFrame(data, columns=columns)
# df.to_csv(csv_file, index=False)

# print(f"\nSelesai! Berhasil mengekstrak fitur dari {len(data)} gambar.")
# print(f"Dataset tersimpan di: {csv_file}")




import cv2
import mediapipe as mp
import os
import pandas as pd

mp_hands = mp.solutions.hands
mp_drawing = mp.solutions.drawing_utils

hands = mp_hands.Hands(
    static_image_mode=True,
    max_num_hands=1,
    min_detection_confidence=0.5
)

# Daftar kategori 
categories = ["TerimaKasih", "Maaf", "SamaSama", "Tolong"]
base_dataset_path = "dataset_preprocessing"
csv_file = "dataset_preprocessing.csv" 

data = []

for label in categories:
    dataset_path = os.path.join(base_dataset_path, label)
    
    # Lewati jika folder belum dibuat
    if not os.path.exists(dataset_path):
        print(f"Folder {dataset_path} tidak ditemukan, lanjut ke folder berikutnya.")
        continue

    print(f"\nMemproses gestur: {label}...")
    
    for img_name in os.listdir(dataset_path):
        img_path = os.path.join(dataset_path, img_name)
        image = cv2.imread(img_path)

        if image is None:
            continue

        # Konversi BGR ke RGB untuk MediaPipe
        image_rgb = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
        result = hands.process(image_rgb)

        if result.multi_hand_landmarks:
            for hand_landmarks in result.multi_hand_landmarks:
                row = []
                
                # Mengambil nilai x dan y mentah langsung dari MediaPipe
                for lm in hand_landmarks.landmark:
                    row.append(lm.x)
                    row.append(lm.y)

                row.append(label)
                data.append(row)

                # Menampilkan visualisasi (bisa di-comment jika ingin proses cepat)
                mp_drawing.draw_landmarks(image, hand_landmarks, mp_hands.HAND_CONNECTIONS)
                cv2.imshow("Hand Landmark", image)
                
                if cv2.waitKey(1) == 27: # Tekan ESC untuk stop paksa
                    break
        else:
            print(f"  -> Tangan tidak terdeteksi di {img_name}")

cv2.destroyAllWindows()

# Membuat nama kolom 
columns = []
for i in range(21):
    columns.extend([f"x{i}", f"y{i}"])
columns.append("label")

# Menyimpan ke CSV
df = pd.DataFrame(data, columns=columns)
df.to_csv(csv_file, index=False)

print(f"\nSelesai! Berhasil mengekstrak fitur mentah dari {len(data)} gambar.")
print(f"Dataset tersimpan di: {csv_file}")