#include <stdio.h>

void main() {
    int  PILIHAN;
    float HASIL, NILAIPERTAMA, NILAIKEDUA ;

    while (1) {
        
    printf("\nPilih Program \n");
    printf("1. Penjumlahan\n");
    printf("2. Pengurangan\n");
    printf("3. Perkalian\n");
    printf("4. Pembagian\n");
    printf("5. Exit\n");

    printf("Masukkan Pilihan : ");
    scanf("%d", &PILIHAN);

        if (PILIHAN == 5) {
            printf("Terimakasih, telah menggunakan kalkulator Jovan Gilbert Natamasindah\n\n");
            break;
        }

        if(PILIHAN == 1) {
            printf("Masukkan Nilai Pertama : ");
            scanf("%f", &NILAIPERTAMA);
            printf("Masukkan Nilai Kedua : ");
            scanf("%f", &NILAIKEDUA);
            printf("Hasil Penjumlahan antara %.2f dengan %.2f adalah %.2f\n", NILAIPERTAMA, NILAIKEDUA, HASIL = NILAIPERTAMA + NILAIKEDUA);     
        }
        else if(PILIHAN == 2) {
            printf("Masukkan Nilai Pertama : ");
            scanf("%f", &NILAIPERTAMA);
            printf("Masukkan Nilai Kedua : ");
            scanf("%f", &NILAIKEDUA);
            printf("Hasil Pengurangan antara %.2f dengan %.2f adalah %.2f\n", NILAIPERTAMA, NILAIKEDUA, HASIL = NILAIPERTAMA - NILAIKEDUA);     
        }
        else if(PILIHAN == 3) {
            printf("Masukkan Nilai Pertama : ");
            scanf("%f", &NILAIPERTAMA);
            printf("Masukkan Nilai Kedua : ");
            scanf("%f", &NILAIKEDUA);
            printf("Hasil Perkalian antara %.2f dengan %.2f adalah %.2f\n", NILAIPERTAMA, NILAIKEDUA, HASIL = NILAIPERTAMA * NILAIKEDUA);     
        }
        else if(PILIHAN == 4) {
            printf("Masukkan Nilai Pertama : ");
            scanf("%f", &NILAIPERTAMA);
            printf("Masukkan Nilai Kedua : ");
            scanf("%f", &NILAIKEDUA);
            printf("Hasil Pembagian antara %.2f dengan %.2f adalah %.2f\n", NILAIPERTAMA, NILAIKEDUA, HASIL = NILAIPERTAMA / NILAIKEDUA);     
        }
        else {
            printf("Input anda salah, silahkan coba lagi\n");

        }
    }
}



