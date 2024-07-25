#include <iostream>
#include <conio.h>
#include <iomanip>

using namespace std;

int main() {
    int data[10];
    int swap;

    for(int i=0 ; i<10 ; i++) {
        cout<< "Masukkan data ke-"<< i+1 << " : ";
        cin >> data[i];
    }
    cout<<endl;

    cout<<"Data sebelum diurutkan : "<< endl;
    for(int i=0 ; i<10 ; i++) {
        cout<<setw(3)<<data[i];
    }
    cout<<endl;

    for(int i=0 ; i<10 ; i++) {
        for(int j=0 ; j<10 ; j++) {
            if(data[j] > data[j+1]) {
                swap = data[j];
                data[j] = data[j+1];
                data[j+1] = swap;
            }
        }
    }
    cout<<"Data setelah diurutkan : "<< endl;
    for(int i=0 ; i<10 ; i++ ) {
        cout<<setw(3)<<data[i];
    }
    getch();
} 