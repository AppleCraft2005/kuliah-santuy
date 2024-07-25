#include <iostream>
using namespace std;

// int main() {
//     int *pc, c;

//     c = 5;
//     cout << "Alamat dari c (&c) = " << &c << endl;
//     cout << "Nilai dari c = " << c << endl << endl;

//     pc = &c;
//     cout << "Alamat dari pointer pc (pc) = " << pc << endl;
//     cout << "isi dari alamat pointer pc (*pc) = " << *pc << endl << endl;

//     c = 11;
//     cout << "Alamat dari pointer pc (pc) = " << pc << endl;
//     cout << "isi dari alamat pointer pc dari (*pc) = " << *pc << endl << endl;  

//     *pc = 2;
//     cout << "Alamat dari c (&c) = " << &c << endl;
//     cout << "Nilai dari c = " << c << endl << endl << endl;  



//     float *pd,d;

//     d = 5.5;
//     pd = &d;
//     *pd = *pd + 2.5;

//     cout << "nilai d adalah " << d << endl; 
//     cout << "nilai *pd adalah " << pd; 


//     return 0;
// }


// #include <conio.h> // untuk konvert tipe data

// int main() {

//     void *ptr;
//     int vint = 50;
//     float vfl = 51.5;

//     ptr = &vint;
//     cout << "Nilai yang ditunjuk oleh ptr: " << *(int*)ptr << endl;

//     ptr = &vfl;
//     cout << "Nilai yang ditunjuk oleh ptr: " << *(float*)ptr << endl;

// }


// int main() {
//     static int tgl_lahir[] = {16,4,1974};
//     int *a;
//     a = tgl_lahir;

//     printf("Nilai yang ditunjuk oleh a = %d\n", *a);
//     printf("Nilai dari tgl_lahir[0] = %d\n", tgl_lahir[0]);
// }


struct Distance {
    int feet;
    float inch;
};

int main() {
    Distance *ptr,d;

    ptr = &d;

    cout << "Enter feet: ";
    cin >> (*ptr).feet;
    cout << "Enter inch: ";
    cin >> (*ptr).inch;

    cout << "Displaying information." << endl;
    cout << "Distance = " << ptr -> feet << " feet " << (*ptr).inch << " inches";

    return 0;
}
