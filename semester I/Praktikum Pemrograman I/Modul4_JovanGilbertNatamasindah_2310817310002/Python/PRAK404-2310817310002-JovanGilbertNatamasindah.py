while 1 :
    print("\nPilih Program")
    print("1. Penjumlahan")
    print("2. Pengurangan")
    print("3. Perkalian")
    print("4. Pembagian")
    print("5. Exit")

    PILIHAN = int(input("Masukkan Pilihan : "))

    if (PILIHAN == 5) :
        print("Terimakasih, telah menggunakan kalkulator Jovan Gilbert Natamasindah\n")
        break


    if(PILIHAN == 1) :
        NILAIPERTAMA = float(input("Masukkan Nilai Pertama : "))
        NILAIKEDUA = float(input("Masukkan Nilai Kedua : "))
        HASIL = NILAIPERTAMA + NILAIKEDUA
        print(f"Hasil Penjumlahan antara {NILAIPERTAMA:.2f} dengan {NILAIKEDUA:.2f} adalah {HASIL:.2f}\n")     
        
    elif(PILIHAN == 2) :
        NILAIPERTAMA = float(input("Masukkan Nilai Pertama : "))
        NILAIKEDUA = float(input("Masukkan Nilai Kedua : "))
        HASIL = NILAIPERTAMA - NILAIKEDUA
        print(f"Hasil Pengurangan antara {NILAIPERTAMA:.2f} dengan {NILAIKEDUA:.2f} adalah {HASIL:.2f}\n")        
        
    elif(PILIHAN == 3) :
        NILAIPERTAMA = float(input("Masukkan Nilai Pertama : "))
        NILAIKEDUA = float(input("Masukkan Nilai Kedua : "))
        HASIL = NILAIPERTAMA * NILAIKEDUA
        print(f"Hasil Perkalian antara {NILAIPERTAMA:.2f} dengan {NILAIKEDUA:.2f} adalah {HASIL:.2f}\n")          
        
    elif(PILIHAN == 4) :
        NILAIPERTAMA = float(input("Masukkan Nilai Pertama : "))
        NILAIKEDUA = float(input("Masukkan Nilai Kedua : "))
        HASIL = NILAIPERTAMA / NILAIKEDUA
        print(f"Hasil Pembagian antara {NILAIPERTAMA:.2f} dengan {NILAIKEDUA:.2f} adalah {HASIL:.2f}\n")     
        
    else :
        print("Input anda salah, silahkan coba lagi\n")

        