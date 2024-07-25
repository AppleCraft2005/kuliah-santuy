#include <stdio.h>

void Biodata(int tahunLahir, char *Namaku, char *Asal){

    int tahun_sekarang = 2023;

    int Umur = tahun_sekarang - tahunLahir;

    printf("\nPerkenalkan Nama Saya : %s\n", Namaku);
    printf("Umur Saya : %d\n", Umur);
    printf("Saya Adalah Angkatan : %d\n", tahun_sekarang);
    printf("Asal Saya dari : %s\n\n", Asal);

}

int main() {

    int tahunLahir;
    char Namaku[20], Asal[15];

        printf("\nTahun lahir : ");
        scanf(" %d",&tahunLahir);
        printf("Namaku : ");
        scanf(" %[^\n]%*c",&Namaku);
        printf("Asal : ");
        scanf(" %[^\n]%*c",&Asal);
        Biodata(tahunLahir, Namaku, Asal);

return 0;

}







