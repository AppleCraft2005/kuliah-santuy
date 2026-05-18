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
categories = ["TerimaKasih", "Maaf", "SamaSama", "Tolong", "Haus", "SampaiJumpa"]
base_dataset_path = "dataset_preprocessing"
csv_file = "dataset_preprocessing_6class.csv" 

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
                    row.append(lm.z)

                row.append(label)
                data.append(row)

                # Menampilkan visualisasi (bisa di-comment jika ingin proses cepat)
                mp_drawing.draw_landmarks(image, hand_landmarks, mp_hands.HAND_CONNECTIONS)
                cv2.imshow("Hand Landmark", image)
                
                if cv2.waitKey(1) == 27: # Tekan ESC untuk stop paksa
                    break
        else:
            print(f"- Tangan tidak terdeteksi di {img_name}")

cv2.destroyAllWindows()

# Membuat nama kolom 
columns = []
for i in range(21):
    columns.extend([f"x{i}", f"y{i}", f"z{i}"])
columns.append("label")

# Menyimpan ke CSV
df = pd.DataFrame(data, columns=columns)
df.to_csv(csv_file, index=False)

print(f"\nSelesai! Berhasil mengekstrak fitur mentah dari {len(data)} gambar.")
print(f"Dataset tersimpan di: {csv_file}")