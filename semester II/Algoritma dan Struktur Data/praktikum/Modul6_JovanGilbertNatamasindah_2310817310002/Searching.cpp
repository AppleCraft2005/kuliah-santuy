#include <stdlib.h>
#include <stdio.h>
#include <iostream>
#include <time.h>
#include <conio.h>

using namespace std;

int random(int bil){
    int jumlah = rand() % bil;
    return jumlah;
}

void randomize(){
    srand(time(NULL));
}

void clrscr(){
    system("cls");
}

int SequentialSearching(){
    clrscr();
    int data[100];
    int cari = 20;
    int counter = 0;
    int flag = 0;
    int save;
    randomize();
    printf("generating 100 number . . .\n");
    for (int i = 0; i < 100; i++){
        data[i] = random(100) + 1;
        printf("%d ", data[i]);
    }
    printf("\ndone.\n");

    for (int i = 0; i < 100; i++){
        if(data[i] == cari){
            counter++;
            flag = 1;
            save = i;
        }
    }
    if (flag == 1){
        printf("Data ada, sebanyak %d!\n", counter);
        printf("pada indeks ke-%d", save);
    }
    else{
        printf("Data tidak ada!\n");
    }
    return 0;
}

int BinarySearching() {
    int n,kiri,kanan,tengah,temp,key;
    bool ketemu = false;

    cout << "Masukan jumlah data? ";
    cin >> n;
    int angka[n];
    for(int i=0 ; i<n ; i++) {
        cout << "Angka ke - [" << i << "] : ";
        cin >> angka[i];
    }

    for(int i=0; i<n ; i++) {
        for(int j = 0 ; j < n - 1 ; j++) {
            if(angka[j] > angka[j+1]) {
                temp = angka[j];
                angka[j] = angka[j+i];
                angka[j+1] = temp;
            }
        }
    }
    cout << "==================================================\n";
    cout << "Data yang telah diurutkan adalah:\n";
    for(int i = 0; i < n; i++) {
        cout << angka[i] << " ";
    }
    cout << "\n=================================================\n";
    cout << "Masukkan angka yang dicari: ";
    cin >> key;

    kiri = 0;
    kanan = n - 1;
    while(kiri <= kanan) {
        tengah = (kiri + kanan) / 2;
        if(key == angka[tengah]) {
            ketemu = true;
            break;
        }
        else if(key < angka[tengah]) {
            kanan = tengah - 1;
        }
        else {
            kiri = tengah + 1;
        }
    }
    if(ketemu == true) {
        cout << "Angka ditemukan! ";
    }
    else
        cout << "Angka tidak ditemukan!";
    return 0;
}

int main() {
    int Pilihan;

    do {
        cout << "Pilih menu" << endl;
        cout << "1. Sequential Searching" << endl;
        cout << "2. Binary Searching" << endl;
        cout << "3. Jelaskan Perbedaan Sequential Searching dan Binary Searching!" << endl;
        cout << "4. Exit" << endl;
        cout << "Masukkan Pilihan : ";
        cin >> Pilihan;
        system("cls");

            switch(Pilihan) {
                case 1:
                    SequentialSearching();
                    break;
                case 2 :
                    BinarySearching();
                    break;
                case 3 :
                    cout << "Sequential Searching merupakan metode pencarian di mana setiap elemen dalam daftar diperiksa satu per satu dari awal hingga akhir sampai elemen yang dicari ditemukan atau seluruh daftar telah diperiksa." << endl;
                    cout << "Binary Searching merupakan metode pencarian yang efisien untuk daftar yang sudah diurutkan. Algoritma ini menggunakan pendekatan divide and conquer untuk mempersempit jangkauan pencarian." << endl;
                    break;
                default :
                    cout << "\nTERIMA KASIH" << endl;                    
            }
        getch();
        clrscr();

    }
    while(Pilihan < 4);

} 