VERTIKAL = int(input("Jumlah Kolom: "))
HORIZONTAL = int(input("Jumlah Baris: "))

for i in range(VERTIKAL):
    print(" _ ", end="")

print()

for i in range(HORIZONTAL):
    for j in range(VERTIKAL):
        print("|_|", end="")
        
    print()

