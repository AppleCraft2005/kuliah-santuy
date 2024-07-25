#include <stdio.h>

void main() {
    int N;

    printf("Masukkan Angka : ");
    scanf("%d", &N);

    if (N < 0) {
        printf("negatif");
    }

    else if (N == 0) {
        printf("nol");
    }

    else if (N > 0) {
        printf("positif");
    }
    
}