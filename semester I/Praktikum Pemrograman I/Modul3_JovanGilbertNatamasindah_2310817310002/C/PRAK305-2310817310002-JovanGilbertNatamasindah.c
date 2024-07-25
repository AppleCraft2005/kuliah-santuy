#include <stdio.h>

void main() {
    int DETIK;

    printf("Masukkan detik : ");
    scanf("%d", &DETIK);

    int JAM = DETIK / 3600;
    int SISAJAM = DETIK - (JAM * 3600);

    int MENIT = SISAJAM / 60;
    int SISAMENIT = SISAJAM - 60;

    int DETIK2 = SISAMENIT % 60;
    
    int HARI = DETIK / 86400;

    int JAM2 = JAM % 24;

    if (DETIK < 86400) {
        printf("%.2d:%.2d:%.2d", JAM, MENIT, DETIK2);
    }

    else if (DETIK >= 86400) {
        printf(" %d Hari %.2d:%.2d:%.2d", HARI,JAM2,MENIT,DETIK2);
    }

}