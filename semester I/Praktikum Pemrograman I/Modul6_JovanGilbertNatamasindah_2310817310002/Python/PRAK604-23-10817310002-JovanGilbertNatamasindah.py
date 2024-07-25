import numpy as np

BARIS1 = input("Masukkan kalimat baris pertama : ")
BARIS2 = input("Masukkan kalimat baris kedua : ")

print()

arr1 = np.array(BARIS1).reshape(1,1)
arr2 = np.array(BARIS2).reshape(1,1)

SIZE_BARIS1 = len(BARIS1)
SIZE_BARIS2 = len(BARIS2)

if (SIZE_BARIS1 == SIZE_BARIS2) :

    i = 0
    j = 0
    JUMLAH_ASTERISK = 0
    JUMLAH_HASH = 0

    while (i < SIZE_BARIS1 and j < SIZE_BARIS2) :
        
        if (BARIS1[i] == ' ' and BARIS2[j] == ' ') :
            i += 1
            j += 1
            continue

        if (BARIS1[i] == BARIS2[j]) :
            print("*", end = "")
            JUMLAH_ASTERISK += 1

        else :
            print("#", end = "")
            JUMLAH_HASH += 1

        i += 1
        j += 1

    print(f"\n* = {JUMLAH_ASTERISK}")
    print(f"# = {JUMLAH_HASH}")

    if (JUMLAH_ASTERISK >= JUMLAH_HASH) :
        print("Pesan Asli")
    
    else :
        print("Pesan Palsu")
        
else :
    print("Panjang kalimat berbeda, pesan palsu")
