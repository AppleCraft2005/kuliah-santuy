#include <stdio.h>

void main() {
    int TOTAL;

    printf("Masukkan Total bilangan yang akan diinputkan : ");
    scanf("%d", &TOTAL);
    
    int arr[TOTAL];

    printf("Masukkan angka : ");
    for(int i = 0 ; i < TOTAL ; i++) {
        scanf("%d", &arr[i]);
    }

    printf("Hasil : ");

    for(int i = 0 ; i < TOTAL ; i++) {
        arr[i] = arr[i] * (1 + i);
        printf("%d ", arr[i]);
    }
}

