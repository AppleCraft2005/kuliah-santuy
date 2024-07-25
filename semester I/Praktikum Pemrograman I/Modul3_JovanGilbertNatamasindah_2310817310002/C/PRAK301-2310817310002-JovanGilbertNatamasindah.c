#include <stdio.h>

void main() {
    int INPUT1,INPUT2;

    printf("Masukkan Angka : ");
    scanf("%d %d", &INPUT1, &INPUT2);

    if (INPUT1 >= INPUT2) {
        printf("Hasil : %d %d", INPUT2, INPUT1);            
    }

    else if (INPUT1 <= INPUT2 ) {
        printf("Hasil : %d %d", INPUT1, INPUT2);
    }

}



