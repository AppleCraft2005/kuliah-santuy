#include <stdio.h>
#include <math.h>

int mutlak(int angka){

   if (angka < 0) {
      angka *= -1;
   }

   return angka;

}

int hitung(int nilai1, int nilai2){

   int hitung;

   hitung = nilai1 - nilai2;

   if (hitung < 0) {
      hitung *= -1;
   }

   return hitung;

}

int main() {

 int a,b,c,d,Hasil,hasil1,hasil2;

   printf("Masukkan bilangan : ");
    scanf("%d %d %d %d",&a,&c,&b,&d);

    Hasil = hitung(a,b) + hitung(c,d);
    printf(" Hasilnya adalah : %d",mutlak(Hasil));

 return 0;
}