#include <stdio.h>

void main () {
    int NILAI;

    printf("Masukkan Nilai : ");
    scanf("%d", &NILAI);

    switch(NILAI) {

        case 80 ... 100:
            printf("A");
            break;

        case 70 ... 79:
            printf("B");
            break;

        case 60 ... 69:
            printf("C");
            break;

        case  50 ... 59:
            printf("D");
            break;

        case  0 ... 49:
            printf("E");
            break;

        default:
            printf("Nilai yang dimasukkan tidak valid");
    }
}