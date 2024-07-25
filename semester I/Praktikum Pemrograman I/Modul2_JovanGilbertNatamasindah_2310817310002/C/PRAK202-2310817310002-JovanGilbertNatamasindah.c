#include <stdio.h>

void main () {

float N1 ;
float N2 ;
float HASIL ;       //operasi aritmatika diletakan diakhir karena jika diletakkan di baris k-8, maka perhitungan tidak akan jalan karena operasi aritmatika terletak sebelum scanf atau tempat uesr menginputkan angka

printf("Masukkan Nilai Pertama : ");
scanf("%f", &N1);

printf("Masukkan Nilai Kedua : ");
scanf("%f", &N2);

printf("\nHasil dari penjumlahan nilai pertama \"%.2g\" dan nilai kedua \"%.1f\" adalah \"%.2f\" \n", N1,N2,HASIL = N1 + N2 );

}       // # %g digunakan menampilkan angka sesuai yang kita inginkan, misal jika mnginput angka 14 pada variabel float maka hasilnya akan tetap 14
