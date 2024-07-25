#include <iostream>
#include <conio.h>
#include <stdlib.h>
#define n 10 
using namespace std;

int PIL,F,R;
char PILIHAN[1],HURUF;
char Q[n];

void INSERT() {
    if (R == n - 1) {
        cout << "Queue sudah Penuh" << endl;  
    } 

    else {
        if (F == -1) {
            F = 0;
        }
        cout << "Silahkan masukkan Huruf ke Queue: ";
        cin >> HURUF;

        R++;
        Q[R] = HURUF;

        cout << "Huruf " << Q[R] << " sudah berada didalam Queue" << endl;
    }
}

void DELETE() {
    if (F == -1 || F > R) {
        cout << "Isi queue kosong" << endl;
    } 

    else {
        cout << "Huruf yang dihapus dari dalam queue adalah " << Q[F] << endl;
        F++;
    }
}

void CETAKLAYAR() {
    if (F == -1 || F > R) {
        cout << "Isi Queue Kosong" << endl;
    } 

    else {
        cout << "Huruf-Huruf dalam Queue adalah ";
        for (int i = F; i <= R; i++) {
            cout << Q[i] << " ";
        }
        cout << endl;
    }
}

void Inisialisasi()  {
    F = -1;
    R = -1;
}

void RESET() {
    F = -1;
    R = -1;
}

int main(){
    Inisialisasi();
    do {
        cout << "QUEUE" << endl;
        cout << "==========" << endl;
        cout << "1. INSERT" << endl;
        cout << "2. DELETE" << endl;
        cout << "3. CETAK QUEUE" << endl;
        cout << "4. QUIT" << endl;
        cout << "PILIHAN : "; cin >> PILIHAN;
        PIL = atoi(PILIHAN);


        switch(PIL) {
            case 1:
                INSERT();
                break;
            case 2:
                DELETE();
                break;
            case 3:
                CETAKLAYAR();
                break;
            default:
                cout << "TERIMA KASIH" << endl;
                break;
        }

        cout << "Press any key to continue" << endl;
        getch();
        system("cls");
    }

    while (PIL < 4);

}


// KODE YANG ISEMPTY DAN ISFULLnya dipisah


// #include <iostream>
// #include <conio.h>
// #include <stdlib.h>
// #define n 10 
// using namespace std;

// int PIL,F,R;
// char PILIHAN[1],HURUF;
// char Q[n];

// bool penuh() {
//     if(R == n - 1) {
//         return true;
//     }
//     else {
//         return false;
//     }
// }

// bool kosong() {
//     if(F == -1 || F > R) {
//         return true;
//     }
//     else {
//         return false;
//     }
// }

// void INSERT() {
//     if (penuh()) {
//         cout << "Queue Overflow" << endl;  // rencananya ingin mengubah fungsi insert dan delete dengan memisahkan fungsi isfull dan isempty menjadi fungsi tersendiri
//     } 

//     else {
//         if (F == -1) {
//             F = 0;
//         }
//         cout << "Masukkan Huruf: ";
//         cin >> HURUF;
//         R++;
//         Q[R] = HURUF;
//         cout << "Huruf " << Q[R] << " dimasukkan ke dalam Queue" << endl;
//     }
// }

// void DELETE() {
//     if (kosong()) {
//         cout << "Queue Underflow" << endl;
//     } 

//     else {
//         cout << "Huruf yang dihapus adalah " << Q[F] << endl;
//         F++;
//     }
// }

// void CETAKLAYAR() {
//     if (kosong()) {
//         cout << "Queue kosong" << endl;
//     } 

//     else {
//         cout << "Huruf-Huruf dalam Queue adalah: ";
//         for (int i = F; i <= R; i++) {
//             cout << Q[i] << " ";
//         }
//         cout << endl;
//     }
// }

// void Inisialisasi()  {
//     F = R = -1;
// }

// void RESET() {
//     F = R = -1;
// }

// int main(){
//     Inisialisasi();
//     do {
//         cout << "QUEUE" << endl;
//         cout << "==========" << endl;
//         cout << "1. INSERT" << endl;
//         cout << "2. DELETE" << endl;
//         cout << "3. CETAK QUEUE" << endl;
//         cout << "4. QUIT" << endl;
//         cout << "PILIHAN : "; cin >> PILIHAN;
//         PIL = atoi(PILIHAN);


//         switch(PIL) {
//             case 1:
//                 INSERT();
//                 break;
//             case 2:
//                 DELETE();
//                 break;
//             case 3:
//                 CETAKLAYAR();
//                 break;
//             default:
//                 cout << "TERIMA KASIH" << endl;
//                 break;
//         }

//         cout << "Press any key to continue" << endl;
//         getch();
//         system("cls");
//     }

//     while (PIL < 4);

// }






