#include <stdio.h>
#include <string.h>

void main() {
    char BARIS1[50],BARIS2[50];

    printf("Masukkan kalimat baris pertama : ");
    scanf(" %[^\n]", &BARIS1);

    printf("Masukkan kalimat baris kedua : ");
    scanf(" %[^\n]", &BARIS2);

    printf("\n");

    size_t SIZE_BARIS1 = strlen(BARIS1);
    size_t SIZE_BARIS2 = strlen(BARIS2);

    if(SIZE_BARIS1 == SIZE_BARIS2) {

        size_t i = 0;
        size_t j = 0;

        int JUMLAH_ASTERISK = 0;
        int JUMLAH_HASH = 0;

        while(i < SIZE_BARIS1 && j < SIZE_BARIS2) {

            if(BARIS1[i] == ' ' && BARIS2[j] == ' '){
                i++;
                j++;
                continue;
            }
            if(BARIS1[i] == BARIS2[j]) {
                printf("*");
                JUMLAH_ASTERISK++;
            }
            else {
                printf("#");
                JUMLAH_HASH++;
            }
            i++;
            j++;
        }

        printf("\n* = %d\n", JUMLAH_ASTERISK);
        printf("# = %d\n", JUMLAH_HASH);

        if (JUMLAH_ASTERISK >= JUMLAH_HASH) {
            printf("Pesan Asli");
        }
        else {
            printf("Pesan Palsu");
        }

    }

    else {
        printf("Panjang kalimat berbeda, pesan palsu");
    } 
}



