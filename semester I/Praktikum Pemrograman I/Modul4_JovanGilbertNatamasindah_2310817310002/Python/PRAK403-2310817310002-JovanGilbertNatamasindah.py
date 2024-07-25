ANGKA1, ANGKA2 =  map(int, input("Masukkan dua buah angka : ").split())

i = ANGKA1
j = ANGKA2

if ANGKA1 > ANGKA2:
    for i in range(i, j, -1):
        print(f"{i} {j} -", end=" ")
        j += 1
else:
    for i in range(i, j):
        print(f"{i} {j} -", end=" ")
        j -= 1

print(ANGKA2,ANGKA1)