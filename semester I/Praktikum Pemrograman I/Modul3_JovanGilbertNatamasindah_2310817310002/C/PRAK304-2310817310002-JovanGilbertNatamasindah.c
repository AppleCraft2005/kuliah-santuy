#include <stdio.h>

void main() {
    int ANGKA;

    printf("Masukkan Angka : ");
    scanf("%d", &ANGKA);

    if (ANGKA == 0) {
        printf("nol");
    }

    else if(ANGKA >= 1 , ANGKA <= 9) {
        printf("Satuan");
    }

    else if (ANGKA == 10) {
        printf("Puluhan");
    }

    else if(ANGKA >= 11 , ANGKA <= 19) {
        printf("Belasan");
    }

    else if(ANGKA >= 20 , ANGKA <= 99) {
        printf("Puluhan");
    }

    else {
        printf("Anda Menginput Melebihi Limit Bilangan");
    }

}





//KODE TIDAK DIPAKAI, HANYA SAYA SIMPAN DIBAWAH SINI SIAPA TAU NANTI SAYA PERLU 
//KODE DIBAWAH MERUPAKAN KODE SOAL NO 3 JIKA INGIN DIGABUNG DENGAN PERULANGAN


void main() {
    int ANGKA;

    while(scanf("%d", &ANGKA)) {

        if(ANGKA == 0) {
            break;
        }

        if(ANGKA >= 1 , ANGKA <= 9) {
            printf("Satuan\n");
        }

        else if(ANGKA >= 11 , ANGKA <= 19) {
            printf("Belasan\n");
        }

        else if(ANGKA >=20 , ANGKA <= 99) {
            printf("Puluhan\n");
        }

        else {
            printf("Anda Menginput Melebihi Limit Bilangan\n");
        }
    }
}