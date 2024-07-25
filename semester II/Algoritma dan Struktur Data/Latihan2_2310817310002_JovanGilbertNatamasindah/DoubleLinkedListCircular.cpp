#include <conio.h>
#include <iostream>
#include <stdlib.h>

using namespace std;

typedef struct Tnode {
    int data;
    Tnode *next;
    Tnode *prev;
};

Tnode *head, *tail;

int pil, menu;
char pilihan[1];
int dataBaru;

void initH(){
    head = NULL;
}
void initHT(){
    head = NULL;
    tail = NULL;
}
int isEmptyH(){
    if(head == NULL) return 1;
    else return 0;
}
int isEmptyHT(){
    if(tail == NULL) return 1;
    else return 0;
}
void tambahDepanH() {
    cout<<"Masukkan data ke bagian depan : ";
    cin>>dataBaru;

    Tnode *baru, *bantu;
    baru = new Tnode;
    baru->data = dataBaru;
    baru->next = baru;
    baru->prev = baru;
    if(isEmptyH()==1){
        head = baru;
        head->next = head;
        head->prev = head;
    } 
    else {
        bantu = head->prev;
        baru->next = head;
        head->prev = baru;
        head = baru;
        head->prev = bantu;
        bantu->next = head;
    }
    cout << "Data \""<<dataBaru<<"\" berhasil dimasukkan di bagian depan.";
}
void tambahDepanHT() {
    cout<<"Masukkan data ke bagian depan : ";
    cin>>dataBaru;

    Tnode *baru;
    baru = new Tnode;
    baru->data = dataBaru;
    baru->next = baru;
    baru->prev = baru;
    if(isEmptyHT() == 1) {
        head = baru;
        tail = baru;
        head->next=head;
        head->prev=head;
        tail->next=tail;
        tail->prev=tail;
    }
    else {
        baru->next = head;
        head->prev = baru;
        head = baru;
        head->prev = tail;
        tail->next = head;
    }
    cout << "Data \""<<dataBaru<<"\" berhasil dimasukkan di bagian depan.";
}
void tambahBelakangH() {
    cout<<"Masukkan data ke bagian belakang : ";
    cin>>dataBaru;

    Tnode *baru, *bantu;
    baru = new Tnode;
    baru->data = dataBaru;
    baru->next = baru;
    baru->prev = baru;
    if(isEmptyH() == 1) {
        head = baru;
        head->next = head;
        head->prev = head;
    } 
    else {
        bantu = head->prev;
        bantu->next = baru;
        baru->prev = bantu;
        baru->next = head;
        head->prev = baru;
    }
    cout << "Data \""<<dataBaru<<"\" berhasil dimasukkan di bagian belakang.";
}
void tambahBelakangHT() {
    cout<<"Masukkan data ke bagain belakang : ";
    cin>>dataBaru;

    Tnode *baru;
    baru = new Tnode;
    baru->data = dataBaru;
    baru->next = baru;
    baru->prev = baru;
    if(isEmptyHT() == 1) {
        head = baru;
        tail = baru;
        head->next = head;
        head->prev = head;

        tail->next=tail;
        tail->prev=tail;

    } else {
        tail->next = baru;
        baru->prev = tail;
        tail = baru;
        tail->next=head;
        head->prev = tail;
    }
    cout << "Data \""<<dataBaru<<"\" berhasil dimasukkan di bagian belakang.";
}
void tampilkanH() {
    Tnode *bantu;
    bantu = head;
    if(isEmptyH() == 0) {
        do{
            cout<<bantu->data<<" ";
            bantu = bantu->next;
        } 
        while(bantu != head);
        cout<<endl;
    } else cout<<"Tidak terdapat data pada Linked List";
}
void tampilkanHT() {
    Tnode *bantu;
    bantu = head;
    if(isEmptyHT() == 0) {
        do{
            cout<<bantu->data<<" ";
            bantu=bantu->next;
        }while(bantu!=tail->next);
        cout<<endl;
    } else cout<<"Tidak terdapat data pada Linked List";
}
void hapusDepanH() {
    Tnode *hapus, *bantu;
    int data;
    if(isEmptyH() == 0) {
        if(head->next != head) {
            hapus = head;
            data = hapus->data;
            bantu = head->prev;
            head = head->next;
            head->prev = bantu;
            bantu->next = head;
            delete hapus;
        } 
        else {
            data = head->data;
            initH();
        }
        cout<<"Data \""<<data<<"\" yang berada di depan berhasil dihapus.";
    } else cout<<"Tidak terdapat data pada Linked List";
}
void hapusDepanHT() {
    Tnode *hapus;
    int data;
    if(isEmptyHT() == 0) {
        if(head!=tail) {
            hapus = head;
            data = hapus->data;
            head = head->next;
            tail->next=head;
            head->prev=tail;
            delete hapus;
        } 
        else {
            data=head->data;
            initHT();
        }
        cout<<"Data \""<<data<<"\" yang berada di depan berhasil dihapus.";
    } else cout<<"Tidak terdapat data pada Linked List";
}
void hapusBelakangH() {
    Tnode *hapus, *bantu;
    int data;
    if(isEmptyH() == 0) {
        if (head->next != head){
            bantu = head;
            while (bantu->next->next !=head){
                bantu = bantu->next;
            }
            hapus = bantu->next;
            data = hapus->data;
            bantu->next = head;
            delete hapus;
            } 
            else {
                data = head->data;
                initH();
            }
            cout<<"Data \""<<data<<"\" yang berada di belakang berhasil dihapus.";
    } else cout<<"Tidak terdapat data pada Linked List";
}
void hapusBelakangHT() {
    Tnode *hapus;
    int data;
    if(isEmptyHT() == 0) {
        if(head != tail) {
            hapus = tail;
            data = hapus->data;
            tail=tail->prev;
            tail->next=head;
            head->prev=tail;
            delete hapus;
        } else {
            data = head -> data;
            initHT();
            delete hapus;
        }
        cout<<"Data \""<<data<<"\" yang berada di belakang berhasil dihapus.";
    } else cout<<"Tidak terdapat data pada Linked List";
}

int main()
{
    menu:
    cout<<"Double linked List Circular (DLLC)"<<endl;
    cout<<"======================================="<<endl;
    cout<<"Silahkan pilih program DLLC yang ingin dijalankan"<<endl;
    cout<<"1. DLLC dengan Head"<<endl;
    cout<<"2. DLLC dengan Head dan Tail"<<endl;
    cout<<"3. Quit"<<endl;
    cout<<"Pilihan : ";
    cin>>menu;
    system("cls");
    if (menu==1){
        do {
            cout<<"Double Linked List Circular (DLLC) (Head)"<<endl;
            cout<<"==============================================="<<endl;
            cout<<"1. Tambah Depan"<<endl;
            cout<<"2. Tambah Belakang"<<endl;
            cout<<"3. Tampilkan Data"<<endl;
            cout<<"4. Hapus Depan"<<endl;
            cout<<"5. Hapus Belakang"<<endl;
            cout<<"6. Kembali ke Menu"<<endl;
            cout<<"Pilihan : ";
            cin>>pilihan;
            pil=atoi(pilihan);
            
            switch(pil) {
            case 1:
                tambahDepanH();
                break;
            case 2:
                tambahBelakangH();
                break;
            case 3:
                tampilkanH();
                break;
            case 4:
                hapusDepanH();
                break;
            case 5:
                hapusBelakangH();
                break;
            default:
                system("cls");
                goto menu;
            }

            cout<<"\npress any key to continue"<<endl;
            getch();
            system("cls");

        } while (pil<7);
    } else if(menu==2){
        do {
            cout<<"Double Linked List Circular (DLLC) (Head dan Tail)"<<endl;
            cout<<"========================================================="<<endl;
            cout<<"1. Tambah Depan"<<endl;
            cout<<"2. Tambah Belakang"<<endl;
            cout<<"3. Tampilkan Data"<<endl;
            cout<<"4. Hapus Depan"<<endl;
            cout<<"5. Hapus Belakang"<<endl;
            cout<<"6. Kembali ke Menu"<<endl;
            cout<<"Pilihan : ";
            cin>>pilihan;
            pil=atoi(pilihan);

            switch(pil) {
            case 1:
                tambahDepanHT();
                break;
            case 2:
                tambahBelakangHT();
                break;
            case 3:
                tampilkanHT();
                break;
            case 4:
                hapusDepanHT();
                break;
            case 5:
                hapusBelakangHT();
                break;
            default:
                system("cls");
                goto menu;
            }

            cout<<"\npress any key to continue"<<endl;
            getch();
            system("cls");

        } while (pil<7); 
    } else {
        cout<<"\nTerima kasih"<<endl;
        cout<<"Program was made by : Jovan Gilbert Natamasindah (2310817310002)"<<endl;
    }
}




