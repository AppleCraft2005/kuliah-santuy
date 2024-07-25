#include <iostream>

using namespace std;

int main() {
    struct HurufAngka {
        string Huruf;
        string Kata;
        int Angka;
    };

    HurufAngka A;

    cout << "Masukkan sebuah huruf = ";
    cin >> A.Huruf;

    cout << "Masukan sebuah kata = ";
    cin >> A.Kata;

    cout << "Masukkan Angka = ";
    cin >> A.Angka;

    cout << "Huruf yang Anda masukkan adalah " << A.Huruf << endl;
    cout << "Kata yang Anda masukkan adalah " << A.Kata << endl;
    cout << "Angka yang Anda masukkan adalah " << A.Angka << endl;
}