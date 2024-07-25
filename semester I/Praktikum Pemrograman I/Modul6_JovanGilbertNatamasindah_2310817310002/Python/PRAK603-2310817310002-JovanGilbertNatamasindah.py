import numpy as np

BARIS1, BARIS2 = map(int, input("Masukkan Total bilangan baris pertama dan baris kedua : ").split())

if (BARIS1 == BARIS2) :

    ELEMEN_ARRAY1 = list(map(int,input("Masukkan angka baris pertama \t: ").split()))
    ELEMEN_ARRAY2 = list(map(int,input("Masukkan angka baris kedua \t: ").split()))

    arr1 = np.array(ELEMEN_ARRAY1).reshape(1,BARIS1)
    arr2 = np.array(ELEMEN_ARRAY2).reshape(1,BARIS2)

    i = 0
    print("Hasil : ")
    while i < BARIS1 and i < BARIS2 :
        HASIL = ELEMEN_ARRAY1[i] * ELEMEN_ARRAY2[i]
        print(HASIL, end = " ")
        i += 1

else :
    print("Jumlah tidak sama")