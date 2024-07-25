ANGKA = int(input("Masukkan Angka : "))

for (GANJIL) in range(1,ANGKA + 1) :
    
    if (GANJIL % 2 != 0) :
        print(GANJIL, end=" ")

print()

for (GENAP) in range(ANGKA,1,-1) :
    
    if (GENAP % 2 == 0) :
        print(GENAP, end=" ")


# penjelasan dari penggunaan -1 = https://sparkbyexamples.com/python/python-for-loop-in-backwards/#:~:text=You%20can%20use%20range(),values%20from%20the%20last%20index.