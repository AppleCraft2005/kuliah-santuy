import cv2
import mediapipe as mp
import numpy as np
import pickle
import os
from joblib import load


# =========================
# Load Model
# =========================
# model_path = "training_svm1/C=0.1/model_svm_rbf_0.1(best).pkl"
model_path = "model_svm_rbf.pkl"
# model_path = "training_SVM1/gridsearch_poly/model_svm (21).pkl"
# model_path = "training_RF1/Tuning/model_random_forest_tuning.pkl"



if not os.path.exists(model_path):
    print(f"ERROR: File '{model_path}' tidak ditemukan di folder ini!")
    input("Tekan Enter untuk keluar...")
    exit()

model = load(model_path)

# =========================
# MediaPipe Setup
# =========================
mp_hands = mp.solutions.hands
mp_drawing = mp.solutions.drawing_utils

hands = mp_hands.Hands(
    static_image_mode=False,
    max_num_hands=1,
    min_detection_confidence=0.7,
    min_tracking_confidence=0.7
)

# =========================
# Webcam
# =========================
cap = cv2.VideoCapture(0)

if not cap.isOpened():
    print("ERROR: Kamera tidak bisa dibuka! Pastikan tidak dipakai aplikasi lain.")
    exit()

while True:

    ret, frame = cap.read()
    if not ret:
        break

    frame = cv2.flip(frame, 1)

    image_rgb = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)

    result = hands.process(image_rgb)

    if result.multi_hand_landmarks:

        for hand_landmarks in result.multi_hand_landmarks:

            landmarks = []

            for lm in hand_landmarks.landmark:
                landmarks.append(lm.x)
                landmarks.append(lm.y)
                landmarks.append(lm.z)

            landmarks = np.array(landmarks).reshape(1, -1)

            # prediksi gesture
            prediction = model.predict(landmarks)

            gesture = prediction[0]

            # gambar landmark
            mp_drawing.draw_landmarks(
                frame,
                hand_landmarks,
                mp_hands.HAND_CONNECTIONS
            )

            # tampilkan teks gesture
            cv2.putText(
                frame,
                f'Gesture: {gesture}',
                (10,50),
                cv2.FONT_HERSHEY_SIMPLEX,
                1,
                (0,255,0),
                2
            )

    cv2.imshow("Gesture Detection", frame)

    if cv2.waitKey(1) & 0xFF == 27:
        break

cap.release()
cv2.destroyAllWindows()