#include <stdio.h>
#include <string.h>

void main() {
    int ANGKADESIMAL;

    scanf("%d", &ANGKADESIMAL);

    char NILAIBINER[32];
    int INDEX = 0;

    while (ANGKADESIMAL > 0) {
        NILAIBINER[INDEX++] = (ANGKADESIMAL % 2) + '0';
        ANGKADESIMAL /= 2;
    }
    NILAIBINER[INDEX] = '\0';

    int START = 0, END = INDEX - 1;

    while (START < END) {
        char temp = NILAIBINER[START];
        NILAIBINER[START] = NILAIBINER[END];
        NILAIBINER[END] = temp;

        START++;
        END--;
    }

    NILAIBINER[0] = (NILAIBINER[0] == '0') ? '1' : '0';

    int HASIL = 0, multiplier = 1;

    for (int i = INDEX - 1; i >= 0; i--) {
        HASIL += (NILAIBINER[i] - '0') * multiplier;
        multiplier *= 2;
    }

    printf("Hasil: %d\n", HASIL);

}