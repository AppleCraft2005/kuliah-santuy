def MaxBilangan(x,y,i,j) :

    if (x >= y and x >= i and x >= j) :
        return x
    
    elif (y >= x and y >= i and y >= j) :
        return y

    elif (i >= x and i >= y and i >= j) :
        return i

    elif (j >= x and j >= y and j >= i) :
        return j


a, b, c, d = map(int,input("Masukkan bilangan - bilangan : ").split(" "))
Bilangan_max = MaxBilangan(a,b,c,d)
print("Bilangan Maksimal : ",Bilangan_max)



