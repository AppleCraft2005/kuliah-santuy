#include <stdio.h>

void main() {
    int N, HASIL;   // N melambangkan jumlah dari pentagon
                    // HASIL melambangkan jumlah kelereng dari n buah pentagon
    while ( scanf("%d", &N)) {
       
        if (N == 0) {   // fungsi disamping untuk menghentikan perulangan jika 
            break;
        } 
        
        printf("%d\n", HASIL = (1.5) * (N*N) + (2.5) * (N) + 1);
    
    }
}
