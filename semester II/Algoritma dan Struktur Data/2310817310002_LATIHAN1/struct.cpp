#include <iostream>
#include <string.h>

using namespace std;

int main() {
    
    struct Mahasiswa{
        string NIM;
        string Nama;
        string Alamat;
        string IPK;
    };

    Mahasiswa A;

    cout << "Profil Mahasiswa\n";
    cout << "Silahkan masukkan identitas diri Anda berikut: \n";

    cout << "NIM : " ; cin >> A.NIM;
    cout << "Nama : " ; cin >> A.Nama;
    cout << "Alamat : " ; cin >> A.Alamat;
    cout << "IPK Terakhir : " ; cin >> A.IPK;

    cout << "=============================" << endl;
    cout << "Berikut identitas Anda: \n";

    cout <<  "NIM :" << A.NIM << endl;
    cout <<  "Nama :" << A.Nama << endl;
    cout <<  "Alamat :" << A.Alamat << endl;
    cout <<  "IPK Terakhir :" << A.IPK << endl;


    return 0;
}


