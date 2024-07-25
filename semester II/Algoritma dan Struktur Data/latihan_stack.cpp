#include <iostream>

#define MAX_STACK 10

using namespace std;

struct STACK {
    int top;
    int data[10];
};

struct STACK tumpuk;

void inisialisasi() {
    tumpuk.top = -1;
}

bool isFull() {
    if(tumpuk.top == MAX_STACK -1) {
        return 1;
    }
    else {
        return 0;
    }
}

bool isEmpty() {
    if(tumpuk.top == -1) {
        return 1;
    }
    else {
        return 0;
    }
}

void Push(int a) {
    if(tumpuk.top == MAX_STACK - 1) {
        cout << "data sudah peunh" << endl;
    }
    else {
        tumpuk.top++;
        tumpuk.data[tumpuk.top] = a;
        cout << "data yang ditambahkan = " << tumpuk.data[tumpuk.top] << endl;
    }
}

void Print() {
    if(!isEmpty) {
        cout << "data kosong" << endl;
    }
    else {
        for(int i = 0 ; i <= tumpuk.top ; i++ ) {
            cout << "data = " <<tumpuk.data[i] << endl;
        }
        cout << endl;
    }
}

void Pop() {
    if(tumpuk.top == -1) {
        cout << "data koosong" << endl;
    }
    else {
        tumpuk.top--;
        cout <<"satu data telah dihapus" << endl;

    }
}

int main(){
    inisialisasi();
    Push(1);
    Push(2);
    Push(3);
    Push(4);
    Push(5);
    Push(6);
    Print();
    Pop();
    Print();
    Push(6);
    Print();
}
