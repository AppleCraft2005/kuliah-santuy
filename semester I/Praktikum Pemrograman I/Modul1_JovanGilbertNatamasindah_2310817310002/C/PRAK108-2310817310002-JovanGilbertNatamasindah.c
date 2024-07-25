#include <stdio.h>

void main() {
    float KELILING = 5;
    float PHI = 3.14;
    float JARAK = 14;
    float KELILINGSATUAN = JARAK / KELILING;
    float TOTAL = KELILINGSATUAN / (2 * PHI );

    printf("Diketahui\n");
    printf("Pak Dengklek mengelilingi taman = %0.f Putaran\n", KELILING);
    printf("Jarak tempuh Pak Dengklek = %0.f Kilometer\n\n", JARAK);

    printf("Jawaban\n");
    printf("Jari-jari yang dikelilingi Pak Dengklek adalah %.2f Kilometer", TOTAL );
}