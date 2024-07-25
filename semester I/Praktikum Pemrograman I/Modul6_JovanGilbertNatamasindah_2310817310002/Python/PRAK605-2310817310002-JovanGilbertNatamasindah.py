import numpy as np

ORDO = int(input("Masukkan jumlah ordo matriks : "))

print("Matriks A:")
ELEMEN_ARRAY1 = []
for i in range(ORDO):
    BARIS = list(map(int, input("").split()))
    ELEMEN_ARRAY1.append(BARIS)

print("Matriks B:")
ELEMEN_ARRAY2 = []
for i in range(ORDO):
    BARIS = list(map(int, input("").split()))
    ELEMEN_ARRAY2.append(BARIS)

arr1 = np.array(ELEMEN_ARRAY1).reshape(ORDO,ORDO)
arr2 = np.array(ELEMEN_ARRAY2).reshape(ORDO,ORDO)

print("Matriks AXB : ")

PERKALIAN = np.dot(arr1, arr2)

for HASIL in PERKALIAN :
    print(*HASIL) 


# mengubah disini untuk mengetes commit melalui vscode ke github





