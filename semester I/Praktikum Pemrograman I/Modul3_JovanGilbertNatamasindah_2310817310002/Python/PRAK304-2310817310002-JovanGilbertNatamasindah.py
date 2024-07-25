ANGKA = int(input("Masukkan angka : "))

if(ANGKA == 0) :
    print("Nol")

elif(ANGKA >= 1 and ANGKA <= 9) :
    print("Satuan")

elif(ANGKA == 10) :
    print("Puluhan")

elif(ANGKA >= 11 and ANGKA <= 19) :
    print("Belasan")

elif(ANGKA >= 20 and ANGKA <= 99 ) :
    print("Puluhan")

else :
    print("Anda Menginput Melebihi Limit Bilangan")