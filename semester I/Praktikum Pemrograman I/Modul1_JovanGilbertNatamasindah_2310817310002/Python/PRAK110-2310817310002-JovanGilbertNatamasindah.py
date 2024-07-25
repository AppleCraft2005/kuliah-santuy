import math

ALAS = 5
TINGGI = 12
MIRING = round(math.sqrt(ALAS * ALAS + TINGGI * TINGGI))
KELILING = ALAS + TINGGI + MIRING
LUAS = round((ALAS * TINGGI) / 2)

print("Diketahui : ")
print(f"Alas = {ALAS} cm")
print(f"Tinggi = {TINGGI} cm\n")

print("Jawab : ")
print(f"Sisi A = ? {ALAS} cm")
print(f"Sisi B = ? {MIRING} cm")
print(f"Sisi C = ? {TINGGI} cm")
print(f"Keliling = {KELILING} cm")
print(f"Luas = {LUAS} cm")


