#include <stdio.h>

void main() {
    int n, KELIPATAN;
    int TOTAL = 0;

    printf("Masukkan nilai n dan kelipatan : ");
    scanf("%d %d", &n, &KELIPATAN);

    for (int i = 1; i <= n; i++) {

        int TOTAL_BARIS = 0;

        for (int j = i; j > 0; j--) {

            TOTAL_BARIS += j * KELIPATAN;

            if (j == i) {
                printf("(%d * %d)", j, KELIPATAN);
            } 
            else {
                printf(" + (%d * %d)", j, KELIPATAN);
            }
            
        }

        printf(" = %d\n", TOTAL_BARIS);
        TOTAL += TOTAL_BARIS;
    }

    printf("%d\n", TOTAL);
}

