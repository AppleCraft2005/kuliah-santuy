a, b, i, j, x, y = input().split(" ")

HASIL = round(((int(a) - int(b)) * int(i) / int(j) - (int(x) + int(y))),3)

print(f"{HASIL:.3f}" )




#CODE YANG TIDAK TERPAKAI


# print("\nketik \"h\" untuk horizontal dan ketik \"v\" untuk vertikal ")

# JENIS = input("Masukkan jenis perhitungan : ")

# if JENIS == "h" :

#     a, b, i, j, x, y = input("").split(" ")

#     HASIL = round(((int(a) - int(b)) * int(i) / int(j) - (int(x) + int(y))),3)

#     print("=", HASIL )

# elif JENIS == "v" :
#     a, b = input("").split(" ")
#     i, j = input("").split(" ")
#     x, y = input("").split(" ")

#     HASIL = round(((int(a) - int(b)) * int(i) / int(j) - (int(x) + int(y))),3)

#     print("=", HASIL)

