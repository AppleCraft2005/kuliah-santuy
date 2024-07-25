#include <stdio.h>
#include <math.h>
#include <stdbool.h>

int main() {
    int N;
    printf("Masukkan sebuah bilangan ");
    scanf("%d", &N);
    bool duaPangkat = false;

    for (int i = 1; i <=16; i ++) {
        int pangkat = pow(2, i);
        if (pangkat == N)
        {
            printf("Ya\n");
            duaPangkat = true;
            break;
        }
    }
    if (duaPangkat == false)
    {
        printf("bukan\n");
    }   

    return 0;
}