#include <stdio.h>

void main() {
    int ORDO,BARIS1,BARIS2;

    printf("Masukkan jumlah ordo matriks : ");
    scanf("%d", &ORDO);

    int arrA[ORDO][ORDO];
    int arrB[ORDO][ORDO];

    printf("Matriks A : \n");
    for (int i = 0 ; i < ORDO ; i++) {
        for (int j = 0 ; j < ORDO ; j++) {
            scanf("%d", &arrA[i][j]);
        }
    }

    printf("Matriks B : \n");
    for (int i = 0 ; i < ORDO ; i++) {
        for(int j = 0 ; j < ORDO ; j++) {
            scanf("%d", &arrB[i][j]);
        }
    }

    int HASIL[ORDO][ORDO];

    for (int i = 0; i < ORDO; i++) {
        for (int j = 0; j < ORDO; j++) {
            HASIL[i][j] = 0;
            for (int h = 0; h < ORDO; h++) {
                HASIL[i][j] += arrA[i][h] * arrB[h][j];
            }
        }
    }

    printf("Matriks AXB : \n");
    for (int i = 0; i < ORDO; i++) {
        for (int j = 0; j < ORDO; j++) {
            printf("%d ", HASIL[i][j]);
        }
        printf("\n");
    }
}