#include <stdio.h>

void main () {
    int TESTCASE ; // TESTCASE menyatakan berapa kali testcase yang ingin dilakukan
    int N,M;     // N dan M menyatakan baris dan kolom

    scanf("%d", &TESTCASE);

    while(TESTCASE--) {   // -- berarti perulangan while akan berhenti sesuai jumlah testcase yang diinputkan

        scanf("%d %d", &N, &M);

        if(N <= M ) {
            
            if(N % 2 == 0) {    //disamping merupakan cara untuk menentukan apakah nilai N bernilai genap atau ganjil, jika ganjil maka akan langsung menuju else
                printf("L\n");                
            }
            else {
                printf("R\n");
            }
        }

        if(N > M ) {        

            if (M % 2 == 0) {   //disamping merupakan cara untuk menentukan apakah nilai M bernilai genap atau ganjil, jika ganjil maka akan langsung menuju else
                printf("U\n");                
            }
            else {
                printf("D\n");
            }
        }
    }
}