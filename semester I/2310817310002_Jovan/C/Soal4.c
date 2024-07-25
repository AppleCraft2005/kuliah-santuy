#include <stdio.h>

void main() {
    int VERTIKAL, HORIZONTAL;

    // VERTIKAL = Kolom
    // HORIZONTAL = Baris

    printf("Jumlah Kolom: ");
    scanf("%d", &VERTIKAL);
    printf("Jumlah Baris: ");
    scanf("%d", &HORIZONTAL);

    for (int i = 0; i < VERTIKAL; i++) {
        printf(" _ ");
    }

    printf("\n");

    for (int i = 0; i < HORIZONTAL; i++) {
        for (int j = 0; j < VERTIKAL; j++) {
            printf("|_|");
        }
        printf("\n");}
}