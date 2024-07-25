def reverse(bilangan) :

    reversed = 0

    while(bilangan != 0) :

        reversed = (reversed) * 10 + (bilangan % 10)
        bilangan //= 10

    return reversed


A,B = map(int,input("Masukkan bilangan : ").split(" "))

A = reverse(A)
B = reverse(B)

C = A + B

print(f"Hasilnya adalah : {reverse(C)}")



