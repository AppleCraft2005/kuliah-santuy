import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.svm import SVC
from sklearn.metrics import accuracy_score, classification_report
import pickle

# =========================
# Load Dataset
# =========================
df = pd.read_csv("dataset_preprocessing.csv")

# fitur dan label
X = df.drop("label", axis=1)
y = df["label"]

# =========================
# Split Dataset
# =========================
X_train, X_test, y_train, y_test = train_test_split(
    X, y,
    test_size=0.2,
    random_state=42
)

# =========================
# Training Model
# =========================
model = SVC(kernel='linear')

print("Training model...")
model.fit(X_train, y_train)

# =========================
# Evaluasi Model
# =========================
y_pred = model.predict(X_test)

accuracy = accuracy_score(y_test, y_pred)

print("Accuracy:", accuracy)
print(classification_report(y_test, y_pred))

# =========================
# Simpan Model
# =========================
with open("gesture_model.pkl", "wb") as f:
    pickle.dump(model, f)

print("Model berhasil disimpan sebagai gesture_model.pkl")