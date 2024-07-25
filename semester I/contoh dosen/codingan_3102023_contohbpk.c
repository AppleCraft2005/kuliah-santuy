#include <stdio.h>

// void main() {
//     for(int i = 0; i<4; i++) {
//         printf("ini loop luar \n");
//         for(int j = 0; j<3; j++) {
//             printf("ini loop dalam \n");
//         }
//     }
// }


void main() {
    int i,j,n=5;

    for(i = 1; i <= n; i++) {
        for(j = 1; j < i; j++) {        /*loop akan dieksekusi selama kondisi memenuhi. Seperti contoh disamping pada outer loop, */
            printf("%d", j);            /*jika kondisi outer loop terpenuhi, maka akan berlanjut ke inner loop. Tapi jika kondisi */
        }                               /*inner loop tidak terpenuhi, maka akan langsung lanjut mencetak outer loop tadi kemudian */
        printf("%d\n", i);              /*outer loop di increment. Lalu jika ternyata kondisi pada inner loop terpenuhi, maka akan*/
    }                                   /*mencetak inner loop dan inner loop akan di increment. Hal tersebut akan terus berulang hingga*/
}                                       /*kondisi inner loop menjadi tidak terpenuhi, dan outer loop akan dicetak dan mengalami increment hal ini */
                                        /*akan terus terjadi hingga kondisi outer loop menjadi tidak terpenuhi*/


