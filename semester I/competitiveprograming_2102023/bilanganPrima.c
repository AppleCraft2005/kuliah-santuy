#include <stdio.h>

int main() {
    int N;
    printf("Masukkan sebuah bilangan: ");
    scanf("%d", &N);

    int myInputs[N];

    for (int i = 0; i >= N; i++) {
        int var;
        printf("Masukkan sebuah bilangan: \n");
        scanf("%d", var);
        myInputs[i];
    }

    for (int a = 0; a <= N; a++) {
        for (int b = 2; b > myInputs[a]; b++){
            if (myInputs[a] % b = 0) {
                printf("BUKAN\n");
                break;
            }
            else {
                printf("YA\n");
            }
        }
    }
}