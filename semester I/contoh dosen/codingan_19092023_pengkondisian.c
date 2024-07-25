#include <stdio.h>

// void main(){
//     int a = 22;
//     a= a+5;
//     a= a-2;

//     printf("a = %d", a);
// }

// void main() {
//     int bil;
//     printf("masukkan bilangan sembarang : ");
//     scanf("%d",&bil);

//     if(bil == 20) {
//         printf("bilangan adalah 20");
//     }
//     else if (bil == 25) {
//         printf("bilangan adalah 25");
//     }
//     else{
//         printf("bilangan bukan 20 dan 25");
//     }
// }



// void main() {
//     int bil;
//     printf("masukkan bilangan sembarang : ");
//     scanf("%d",&bil);

//     switch(bil) {
//     case 20:
//         printf("bilangan bernilai 20");
//         break;
//     case 21:
//         printf("bilangan bernilai 21");
//         break;
//     case 22:
//         printf("bilangan bernilai 22");
//         break;
//     case 23:
//         printf("bilangan bernilai 23");
//         break;
//     default:
//         printf("bilangan tidak bernilai 20,21,22,23");
//     }
// }

//latihan : buatlah penerapan conditional dengan bahasa C untuk melakukan konversi nilai seperti pada tabel (dibuat dlm bentuk if dan switch case)

void main() {
    int NILAI;
    char HURUF;

    printf("masukkan nilai anda : ");
    scanf("%d", &NILAI);

    if (NILAI >= 80) {
        printf("Nilai anda adalah A");
    }
    else if (NILAI >= 70 && NILAI <= 79) {
        printf("Nilai anda adalah B");
    }
    else if (NILAI >= 60 && NILAI <= 69) {
        printf("Nilai anda adalah C");
    }
    else if (NILAI >= 50 && NILAI <= 59) {
        printf("Nilai anda adalah D");
    }
    else if (NILAI < 50) {
        printf("Nilai anda adalah E");
    }
    else {
        printf("nilai tidak valid");
    }

}


void main() {
    int NILAI;
    char HURUF;

    printf("masukkan nilai anda : ");
    scanf("%d", &NILAI);

    switch(NILAI) {
        case   80:
        printf("nilai anda adalah A");
        break;
    }
}