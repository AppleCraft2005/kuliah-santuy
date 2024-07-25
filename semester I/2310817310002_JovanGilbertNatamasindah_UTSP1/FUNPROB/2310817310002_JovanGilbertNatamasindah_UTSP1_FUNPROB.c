#include <stdio.h>

void main() {
    float N,M;  // N melambangkan jumlah uang 10
                // M melambangkan jumlah uang 5

    while (scanf("%f %f", &N , &M) ) {

        if(N == 0 && M == 0) {
            break;
        }
        
        if (N == 0 ) {
            printf("1.000000\n"); // N == 0 berarti tidak ada yang membayar uang berjumlah 10, dimana tidak memerlukan uang kembalian makanya peluangnya 1,0000000
        }
        else if (N > M) {
            printf("0.000000\n"); // N > M berarti yang membayar uang berjumlah 10 lebih banyak daripada yang membayar dengan uang yang berjumlah 5, sehingga memerlukan uang kembalian dan peluangnya menjadi 0,000000 
        }
        else {
            printf("%f\n", (M - N + 1.0) / (M + 1.0)); // menggunakan teorema Bertrand Ballot : https://en.wikipedia.org/wiki/Bertrand%27s_ballot_theorem
        }
    }
}
