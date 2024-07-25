#include <stdio.h>

void main () {
    int SEPATUA = 400000;
    int SEPATUB = 350000;

    int DISKONA = 400000 * 13/100;
    int DISKONB = 350000 * 21/100;
    
    int HASILA = SEPATUA - DISKONA ;
    int HASILB = SEPATUB - DISKONB ;

    printf("Harga Sepatu A adalah %d\n", SEPATUA);
    printf("Harga Sepatu B adalah %d\n", SEPATUB);
    printf("Sepatu A mendapat diskon 13%% sehingga harganya menjadi %d\n", HASILA );
    printf("Sepatu B mendapat diskon 21%% sehingga harganya menjadi %d\n", HASILB );
}