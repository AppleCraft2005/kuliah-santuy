#include <stdio.h>

int reverse(int bilangan){

    int reversed = 0;

    while(bilangan != 0) {

        reversed = (reversed) * 10 + (bilangan % 10) ;
        bilangan /= 10;

    }

    return reversed;

}

int main() {

    int A, B;

    printf("Masukkan bilangan : ");
    scanf("%d %d",&A,&B);
    
    A = reverse(A);
    B = reverse(B);

    int C = A+B;
    printf("Hasilnya adalah : %d",reverse(C));

}

