import math

DETIK = int(input("Masukkan detik : "))

JAM = math.floor(DETIK / 3600)
SISAJAM = DETIK - (JAM * 3600)

MENIT = math.floor((SISAJAM / 60))
SISAMENIT = SISAJAM - 60

DETIK2 = math.floor(SISAMENIT % 60)

HARI = math.floor(DETIK / 86400)

JAM2 = math.floor(JAM % 24)

if(DETIK < 86400 ) :
    print(f"{JAM:02d}:{MENIT:02d}:{DETIK2:02d}")

elif (DETIK >= 86400) :
    print(f"{HARI} hari {JAM2:02d}:{MENIT:02d}:{DETIK2:02d}")



# materi dan penjelasan mengenai math.floor = https://www.w3schools.com/python/ref_math_floor.asp#:~:text=The%20math.floor()%20method,the%20math.ceil()%20method.
# materi dan penjelasan mengenai penambahan angak nol di depan integer = https://www.askpython.com/python/examples/display-numbers-with-leading-zeros#:~:text=To%20add%20leading%20zeros%20to,to%20meet%20the%20desired%20width.