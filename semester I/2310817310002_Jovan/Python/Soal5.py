while 1 :
    print("Operasi Aritmatik Dua Bilangan ")
    print("1. Penjumlahan")
    print("2. Pengurangan")
    print("3. Perkalian")
    print("4. Pembagian")
    print("5. Keluar")
    print("=========================")

    PILIHAN = int(input("Pilih Menu: "))

    print("\n")

    if (PILIHAN == 5) :
        print("Terimakasih\n")
        break

    if(PILIHAN == 1) :
        NILAIPERTAMA = int(input("Masukkan Bilangan 1 : "))
        NILAIKEDUA = int(input("Masukkan Bilangan 2 : "))
        HASIL = NILAIPERTAMA + NILAIKEDUA
        print("\nOperasi Penjumlahan\n")
        print(f"Hasil Penjumlahan antara {NILAIPERTAMA} + {NILAIKEDUA} = {HASIL}\n")     
        
    elif(PILIHAN == 2) :
        NILAIPERTAMA = int(input("Masukkan Bilangan 1 : "))
        NILAIKEDUA = int(input("Masukkan Bilangan 2 : "))
        HASIL = NILAIPERTAMA - NILAIKEDUA
        print("\nOperasi Pengurangan\n")
        print(f"Hasil Pengurangan antara {NILAIPERTAMA} - {NILAIKEDUA} = {HASIL}\n")        
        
    elif(PILIHAN == 3) :
        NILAIPERTAMA = int(input("Masukkan Bilangan 1 : "))
        NILAIKEDUA = int(input("Masukkan Bilangan 2 : "))
        HASIL = NILAIPERTAMA * NILAIKEDUA
        print("\nOperasi Perkalian\n")
        print(f"Hasil Perkalian antara {NILAIPERTAMA} * {NILAIKEDUA} = {HASIL}\n")          
        
    elif(PILIHAN == 4) :
        NILAIPERTAMA = int(input("Masukkan Bilangan 1 : "))
        NILAIKEDUA = int(input("Masukkan Bilangan 2 : "))
        HASIL = NILAIPERTAMA / NILAIKEDUA
        print("\nOperasi Pembagian\n")
        print(f"Hasil Pembagian antara {NILAIPERTAMA} / {NILAIKEDUA} = {HASIL}\n")     
        
    else :
        print("Input anda salah, silahkan coba lagi\n")