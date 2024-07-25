#include <stdio.h>

// void main() {
//     char HURUF;
//     int ANGKA;

//     printf("Alamat variabel : %x\n", &HURUF);
//     printf("Alamat variabel : %x\n\n", &ANGKA);

//     int BIL = 20;
//     int *PENUNJUK = &BIL;

//     printf("Alamat variabel BIL : %x\n", &BIL);
//     printf("Alamat yang disimpan dalam pointer penunjuk : %x\n", PENUNJUK);
//     printf("Nilai variable penunjuk : %d\n", PENUNJUK);

// }

void main() {
    int a;
    int reversed = 0;

printf("Masukkan angka yang ingin dibalik : ");
scanf("%d", &a);

while(a != 0) {

    reversed = (reversed) * 10 + (a % 10) ;
    a /= 10;

}

printf("Angka yang sdudah dibalik = %d", reversed);
        
}


