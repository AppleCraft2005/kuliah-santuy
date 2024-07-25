#include <stdio.h>
#include <math.h>

void main () {
    int ALAS = 5;
    int TINGGI = 12;
    int MIRING = sqrt(ALAS*ALAS + TINGGI*TINGGI);
    int KELILING = ALAS + TINGGI + MIRING;
    int LUAS = (ALAS * TINGGI)/2;
    
    printf("Diketahui : \n");
    printf("Alas = %d cm\n", ALAS);
    printf("Tinggi = %d cm\n\n", TINGGI);
    
    printf("jawab : \n");
    printf("Sisi A = ? %d cm\n", ALAS);
    printf("Sisi B = ? %d cm\n", MIRING);
    printf("Sisi C = ? %d cm\n", TINGGI);
    printf("Keliling = %d cm\n", KELILING );
    printf("Luas = %d cm\n", LUAS );
}


