import math

A, B = input("").split(" ")

C = round(math.sqrt(int(B)*int(B) - int(A)*int(A)))
KELILING = round(int(A) + int(B) + int(C))
LUAS = round((int(C) * int(A)) / 2)

print(f"Alas : {C} cm")
print(f"Tinggi : {A} cm")
print(f"Keliling : {KELILING} cm")
print(f"Luas : {LUAS} cm^2")




#CODE YANG TIDAK TERPAKAI


# print("\nketik \"h\" untuk horizontal dan ketik \"v\" untuk vertikal ")

# JENIS = input("Masukkan jenis perhitungan : ")

# if JENIS == "h" :

#     A, B = input("").split(" ")

#     C = round(math.sqrt(int(B)*int(B) - int(A)*int(A)))
#     KELILING = (int(A) + int(B) + int(C))
#     LUAS = round((int(C) * int(A)) / 2)


#     print(f"Alas : {C} cm")
#     print(f"Tinggi : {A} cm")
#     print(f"Keliling : {KELILING} cm")
#     print(f"Luas : {LUAS} cm^2")

# elif JENIS == "v" :

#     A = input("")
#     B = input("")

#     C = round(math.sqrt(int(B)*int(B) - int(A)*int(A)))
#     KELILING = (int(A) + int(B) + int(C))
#     LUAS = round((int(C) * int(A)) / 2)


#     print(f"Alas : {C} cm")
#     print(f"Tinggi : {A} cm")
#     print(f"Keliling : {KELILING} cm")
#     print(f"Luas : {LUAS} cm^2")