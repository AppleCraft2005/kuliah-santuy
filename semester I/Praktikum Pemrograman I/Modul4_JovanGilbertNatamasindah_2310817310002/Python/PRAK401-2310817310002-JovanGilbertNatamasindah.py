ANGKA, SIMBOL = input("Masukkan Angka dan Simbol : ").split(" ")

for (BILANGAN) in range(1,51) :
    
    if (int(BILANGAN )% int(ANGKA) == 0) :
        print(SIMBOL, end=" ")
        continue

    print(int(BILANGAN), end=" ")



# penjelasan mengenai penggunaan end="" : https://www.freecodecamp.org/news/python-for-loop-example-how-to-write-loops-in-python/