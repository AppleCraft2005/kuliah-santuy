#include <stdio.h>

void main() {
    int BARIS1,BARIS2,h;

    printf("Masukkan Total bilangan baris pertama dan baris kedua : ");
    scanf("%d %d", &BARIS1,&BARIS2);

    int arr1[BARIS1];
    int arr2[BARIS2];

    if(BARIS1 == BARIS2) {
        
        printf("Masukkan angka baris pertama\t: ");
        for(int i = 0 ; i < BARIS1 ; i++) {
            scanf("%d", &arr1[i]);
        }

        printf("Masukkan angka baris kedua\t: ");
        for(int i = 0 ; i < BARIS2 ; i++) {
            scanf("%d", &arr2[i]);
        }

        printf("Hasil : \n");

        int arr[h];
        for(int h = 0 ; h < BARIS1 && h < BARIS2; h++) {
            arr[h] = arr1[h] * arr2[h];
            printf("%d ", arr[h]);
        }        
    }
    
    else {
        printf("Jumlah tidak sama");
    }
}



