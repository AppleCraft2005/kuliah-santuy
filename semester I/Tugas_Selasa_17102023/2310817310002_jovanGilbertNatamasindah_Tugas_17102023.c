#include <stdio.h>

void main () {

    int ANGKA = 0;


    while ( ANGKA < 100) {
        scanf("%d\n", &ANGKA);

        if (ANGKA == 42) {
           break;
    }
        printf("%d\n", ANGKA);

    }


}