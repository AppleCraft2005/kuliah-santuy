#include <stdio.h>

void main () {
    int ANGKA;      // ANGKA melambangkan inputan panjang pagar
    float HASIL;    // HASIL melambangkan maxarea dalam pagar
    float PHI = 3.14159265359; // jika make 3,14 maka di SPOJ akan muncul wrong answer

    while (scanf("%d", &ANGKA )) {

        if ( ANGKA == 0) {      // berfungsi untuk mengehentikan fungsi jika ANGKA diinput dengan 0 
            break;
        }

        printf("%.2f\n",HASIL = (ANGKA * ANGKA) / (PHI * 2));

    }

}


