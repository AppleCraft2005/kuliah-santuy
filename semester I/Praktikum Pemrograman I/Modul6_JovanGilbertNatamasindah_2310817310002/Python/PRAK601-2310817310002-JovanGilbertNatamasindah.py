import numpy as np

V, H = map(int, input("Masukkan ukuran Vertikal (V) dan Horizontal (H) matriks : ").split())

ELEMEN_ARRAY = list(map(int,input("Masukkan angka matriks : ").split(" ")))

print(f"\nMatriks {V} x {H} :\n")

arr = np.array(ELEMEN_ARRAY).reshape((V, H))

for HASIL in arr :
    print(*HASIL)   


