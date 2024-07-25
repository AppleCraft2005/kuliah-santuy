// #include <iostream>

// using namespace std;

// // contoh pendeklarasian array
// int main() {
//     int Angka[7] = {2,4,6,8,10,12,14};

//     cout << Angka[2];

//     return 0;
// }




// #include <iostream>

// using namespace std;

// enum class JENIS_KELAMIN { LAKI_LAKI, PEREMPUAN };

// int main() {
//   JENIS_KELAMIN jk = JENIS_KELAMIN::LAKI_LAKI;

//   if (jk == JENIS_KELAMIN::LAKI_LAKI) {
//     cout << "Laki-laki" << endl;
//   } else {
//     cout << "Perempuan" << endl;
//   }
  
//   return 0;
// }

// #include <iostream>
// using namespace std;
// int main() {
//     int numbers[5];
//     int *p;
//     p = numbers; *p = 10 ;
//     p++; *p = 20;
//     p = &numbers[2]; *p =30;
//     p = numbers +3; *p = 40;
//     p = numbers; *(p+4) = 50;
//     for (int n=0;n<3;n++)
//     cout<<numbers[n]<<",";
//     return 0;
// }


// #include <iostream>
// using namespace std;

// void tambah(int *angka){
//     *angka +=20;
// }
// int main() {
//     int nilai = 10;
//     cout<<"Nilai Variabel Nilai A ="<<nilai<<endl;
//     tambah(&nilai);
//     cout<<"Nilai Variabel Nilai B ="<<nilai<<endl;
//     return 0;
// }

// #include <iostream>
// using namespace std;

// float LUAS(int r) {
//     float HASIL_LUAS = 3.14 * r * r;
//     return HASIL_LUAS;
// };

// float KELILING(int r) {
//     float HASIL_KELILING = 2 * 3.14 * r;
//     return HASIL_KELILING;
// };

// int main() {
//     int JARI_JARI;

//     cout << "Masukkan jari-jari lingkaran : ";
//     cin >> JARI_JARI;

//     cout << "Luas = " << LUAS(JARI_JARI) << " cm^2" << endl;
//     cout << "Keliling = " << KELILING(JARI_JARI) << " cm" << endl;

//     return 0;
// };

// #include <iostream>

// using namespace std;

// enum HEWAN {
//     Kucing,
//     Anjing,
//     Sapi,
//     Domba,
//     Kelinci,
//     Burung,
//     Ular
// };

// int main() {
//     HEWAN bertelur = Burung;
        
//     if (bertelur == Burung) {
//         cout << "Burung merupakan hewan yang bertelur" << endl;
//     }
    
//     return 0;
// }

#include <iostream>

using namespace std;

struct Biodata {
    string nama;
    string asal;
    string TTL;
};

int main() {
    Biodata orang1;
    
    orang1.nama = "Jovan";
    orang1.asal = "Banjarmasin";
    orang1.TTL = "Banjarmasin, 17 Juni 2005";
    
    cout << "Nama: " << orang1.nama << endl;
    cout << "Asal: " << orang1.asal << endl;
    cout << "Tempat/Tanggal lahir: " << orang1.TTL << endl;
    
    return 0;
}
