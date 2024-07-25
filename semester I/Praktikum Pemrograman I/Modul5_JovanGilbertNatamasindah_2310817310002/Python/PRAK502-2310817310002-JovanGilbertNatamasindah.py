def mutlak(angka) :
    
    if (angka < 0) :
        angka *= -1


    return angka

def hitung(nilai1, nilai2) :

    hitung = nilai1 - nilai2

    if (hitung < 0) :
        hitung *= -1

    return hitung


a,c,b,d = map(int,input("Masukkan bilangan : ").split(" "))

Hasil = hitung(a,b) + hitung(c,d)

print(f"Hasilnya adalah : {Hasil}")
