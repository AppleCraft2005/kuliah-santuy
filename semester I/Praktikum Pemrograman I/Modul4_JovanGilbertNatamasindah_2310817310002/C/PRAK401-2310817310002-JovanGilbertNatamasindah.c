#include <stdio.h>

void main() {
    int  ANGKA;
    char SIMBOL;

    printf("Masukkan Angka dan Simbol : ");
    scanf("%d %c",&ANGKA, &SIMBOL);

    for(int BILANGAN = 1 ; BILANGAN <= 50 ; BILANGAN++ ) {

        if (BILANGAN % ANGKA == 0) {
            printf("%c ", SIMBOL);
            continue;
        }
        
        printf("%d ", BILANGAN);
    }
}