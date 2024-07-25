def Biodata(tahunLahir,Namaku,Asal) :
    tahun_sekarang = 2023

    Umur = tahun_sekarang - tahunLahir

    print(f"\nPerkenalkan Nama Saya : {Namaku}")
    print(f"Umur saya : {Umur}")
    print(f"Saya Adalah Angkatan : {tahun_sekarang}")
    print(f"Asal Saya dari : {Asal}\n")


tahunLahir = int(input("\nTahun lahir : "))
Namaku = input("Namaku : ")
Asal = input("Asal : ")

Biodata(tahunLahir, Namaku, Asal)



