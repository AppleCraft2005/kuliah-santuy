#include <stdio.h>

void main() {
    int ANGKA;

    printf("Masukkan Angka : ");
    scanf("%d", &ANGKA);

    for( int GANJIL = 1 ; GANJIL <= ANGKA ; GANJIL++) {
        
        if( GANJIL % 2 != 0) {
            printf("%d ", GANJIL);
        }

    }    

    printf("\n");

    for (int GENAP = ANGKA ; GENAP >= 1 ; GENAP--) {

         if (GENAP % 2 == 0) {
            printf("%d ", GENAP);
        }
        
    }
}