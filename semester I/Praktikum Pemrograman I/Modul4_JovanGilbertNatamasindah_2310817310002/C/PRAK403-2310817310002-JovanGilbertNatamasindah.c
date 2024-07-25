#include <stdio.h>

void main(){
    int ANGKA1, ANGKA2;
    
    printf("Masukkan dua angka dengan spasi : ");
    scanf("%d %d",&ANGKA1, &ANGKA2);

    if (ANGKA1 > ANGKA2) {

        for (int i = ANGKA1, j = ANGKA2; i > ANGKA2; i--,j++) {
            printf("%d %d - ",i, j);
        }
    } 

    else {
        
        for (int i = ANGKA1, j = ANGKA2; i < ANGKA2; i++, j--) {
            printf("%d %d - ",i, j);
        }
    }

    printf("%d %d",ANGKA2, ANGKA1);
}









