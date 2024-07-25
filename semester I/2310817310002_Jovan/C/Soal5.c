#include <stdio.h>

void main() {
    int  PILIHAN, HASIL, NILAIPERTAMA, NILAIKEDUA ;

    while (1) {
        
    printf("Operasi Aritmatika Dua Bilangan\n");
    printf("1. Penjumlahan\n");
    printf("2. Pengurangan\n");
    printf("3. Perkalian\n");
    printf("4. Pembagian\n");
    printf("5. Keluar\n");

    printf("=========================\n");
    printf("Pilih Menu: ");
    scanf("%d", &PILIHAN);

    printf("\n\n");

        if (PILIHAN == 5) {
            printf("Terimakasih\n\n");
            break;
        }

        if(PILIHAN == 1) {
            printf("Masukkan Bilangan 1 : ");
            scanf("%d", &NILAIPERTAMA);
            printf("Masukkan Bilangan 2 : ");
            scanf("%d", &NILAIKEDUA);
            printf("\nOperasi Penjumlahan\n\n");
            printf("Hasil Penjumlahan antara %d + %d = %d\n\n", NILAIPERTAMA, NILAIKEDUA, HASIL = NILAIPERTAMA + NILAIKEDUA);     
        }
        else if(PILIHAN == 2) {
            printf("Masukkan Bilangan 1 : ");
            scanf("%d", &NILAIPERTAMA);
            printf("Masukkan Bilangan 2 : ");
            scanf("%d", &NILAIKEDUA);
            printf("\nOperasi Pengurangan\n\n");
            printf("Hasil Pengurangan antara %d - %d = %d\n", NILAIPERTAMA, NILAIKEDUA, HASIL = NILAIPERTAMA - NILAIKEDUA);     
        }
        else if(PILIHAN == 3) {
            printf("Masukkan Bilangan 1 : ");
            scanf("%d", &NILAIPERTAMA);
            printf("Masukkan Bilangan 2 : ");
            scanf("%d", &NILAIKEDUA);
            printf("\nOperasi Perkalian\n\n");
            printf("Hasil Perkalian antara %d * %d = %d\n", NILAIPERTAMA, NILAIKEDUA, HASIL = NILAIPERTAMA * NILAIKEDUA);     
        }
        else if(PILIHAN == 4) {
            printf("Masukkan Bilangan 1 : ");
            scanf("%d", &NILAIPERTAMA);
            printf("Masukkan Bilangan 2 : ");
            scanf("%d", &NILAIKEDUA);
            printf("\nOperasi Pembagian\n\n");
            printf("Hasil Pembagian antara %d / %d = %d\n", NILAIPERTAMA, NILAIKEDUA, HASIL = NILAIPERTAMA / NILAIKEDUA);     
        }
        else {
            printf("Input anda salah, silahkan coba lagi\n");

        }
    }
}
