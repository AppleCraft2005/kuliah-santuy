n, KELIPATAN = map(int,input("Masukkan nilai n dan kelipatan : ").split())

TOTAL = 0

for i in range(1, n + 1):

    TOTAL_BARIS = 0

    for j in range(i, 0, -1):
        
        TOTAL_BARIS += j * KELIPATAN
        if j == i:
            print(f"({j} * {KELIPATAN})", end="")
        else:
            print(f" + ({j} * {KELIPATAN})", end="")

    print(f" = {TOTAL_BARIS}")
    TOTAL += TOTAL_BARIS

print(TOTAL)

