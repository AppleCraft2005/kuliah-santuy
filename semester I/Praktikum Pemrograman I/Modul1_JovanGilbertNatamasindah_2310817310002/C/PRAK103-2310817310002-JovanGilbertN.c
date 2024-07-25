#include <stdio.h>

void main() {
    float a = 9;
    float b = 6;
    float x = 10;
    float y = 7;
    float TOTAL = (a + b) * x / y;

    printf("Variabel a bernilai %0.f\n", a);
    printf("Variabel b bernilai %0.f\n", b);
    printf("Variabel x bernilai %0.f\n", x);
    printf("Variabel y bernilai %0.f\n", y);
    printf("Hasil dari a ditambah b dikali x dan dibagi y adalah %.2f", TOTAL );

}