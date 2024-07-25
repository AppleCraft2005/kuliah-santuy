import numpy as np

TOTAL = int(input("Masukkan Total bilangan yang akan diinputkan : "))

ELEMEN_ARRAY = list(map(int,input("Masukkan angka matriks : ").split()))

arr = np.array(ELEMEN_ARRAY).reshape((1,TOTAL))

i = 0

print("Hasil : ")

while i < TOTAL :
    HASIL = ELEMEN_ARRAY[i] * (i + 1)
    print(f"{HASIL}", end = " ")
    i += 1
