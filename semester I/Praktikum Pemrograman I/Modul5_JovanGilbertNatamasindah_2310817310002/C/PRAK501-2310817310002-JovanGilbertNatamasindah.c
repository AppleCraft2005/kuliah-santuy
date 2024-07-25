#include <stdio.h>

int MaxBilangan(int x, int y, int i, int j) {

    if (x >= y && x >= i && x >= j) {
        return x;
    }

    else if ( y >= x && y >= i && y >= j) {
        return y;
    }

    else if ( i >= x && i >= y && i >= j ) {
        return i;
    }

    else if (j >= x && j >= y && j >= i) {
        return j;
    }
}

int main() {

    int a, b, c, d; 
    printf("Masukkan bilangan - bilangan : ");
    scanf("%d %d %d %d", &a, &b, &c, &d);

    int hasil = MaxBilangan(a, b, c, d);
    printf("Bilangan Maksimal : %d", hasil); 

return 0;
}









