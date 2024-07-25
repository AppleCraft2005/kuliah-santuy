#include <stdio.h>

void main() {
    int VERTIKAL,HORIZONTAL,i,j;

    // VERTIKAL = Kolom
    // HORIZONTAL = Baris

    scanf("%d %d", &VERTIKAL,&HORIZONTAL);

    int arr[VERTIKAL][HORIZONTAL];
        
        for( i = 0 ; i < VERTIKAL ; i++) {
            for( j = 0 ; j < HORIZONTAL ; j++) {
                scanf("%d", &arr[i][j]);
            }
        }

    int JUMLAH = 0;
    for(i = 0; i < VERTIKAL; i++) {
        int MINIMUM = 999999;
        for(j = 0; j < HORIZONTAL ; j++) {
            if(arr[i][j] < MINIMUM) {
                MINIMUM = arr[i][j];
            }
        }
        JUMLAH += MINIMUM;
    }
    printf("%d",JUMLAH);
}