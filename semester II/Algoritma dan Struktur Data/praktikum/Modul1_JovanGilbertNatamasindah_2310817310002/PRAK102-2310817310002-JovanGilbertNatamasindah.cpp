#include <iostream>

using namespace std;

int main() {
    
    struct Kendaraan{
        string Plat;
        string Jenis;
        string Nama;
        string Alamat;
        string Kota;
    };

    Kendaraan A;

    A.Plat = "DA1234MK";
    A.Jenis = "RUSH";
    A.Nama = "Andika Hartanto";
    A.Alamat = "jl.Kayu Tangi 1";
    A.Kota = "Banjarmasin";

    cout <<  "Plat Nomor Kendaraan : " << A.Plat << endl;
    cout <<  "Jenis Kendaraan : " << A.Jenis << endl;
    cout <<  "Nama Pemilik : " << A.Nama << endl;
    cout <<  "Alamat : " << A.Alamat << endl;
    cout <<  "Kota : " << A.Kota << endl;

    return 0;
}


