#include <stdio.h>

void main() {
    int a = 4;
    int b = 5;
    int c = 7;
    int KELILING = 16;
    int HARGATANAH = 85000;
    int TOTAL = HARGATANAH * KELILING ;

    printf("Diketahui :\n");
    printf("Panjang sisi segitiga berturut-turut adalah %d, %d, dan %d\n", a, b, c);
    printf("Keliling Tanah Pak Dengklek adalah %d\n", KELILING);
    printf("Harga tanah per Meter adalah %d \n\n", HARGATANAH);
    printf("Jawaban :\n");
    printf("Biaya yang diperlukan Pak Dengklek adalah %d", TOTAL );
   }