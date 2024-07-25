#include <iostream>
#include <string.h>

using namespace std;

int main() {
    
        string NIM;
        string Nama;
        string Alamat;
        string IPK;

    cout << "Profil Mahasiswa\n" ;
    cout << "Silahkan masukkan identitas diri Anda berikut:\n";

    cout << "NIM : " ; cin >> NIM;
    cout << "Nama : " ; cin >> Nama;
    cout << "Alamat : " ; cin >> Alamat;
    cout << "IPK Terakhir : " ; cin >> IPK;

    cout << "=============================" << endl;
    cout << "Berikut identitas Anda: \n";

    cout <<  "NIM :" << NIM << endl;
    cout <<  "Nama :" << Nama << endl;
    cout <<  "Alamat :" << Alamat << endl;
    cout <<  "IPK Terakhir :" << IPK << endl;


    return 0;
}