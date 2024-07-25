#include <conio.h>
#include <iostream>
#include <stdlib.h>

using namespace std;

typedef struct TNode {
    int data;
    TNode *next;
};

TNode *head, *tail;

int pil, menu;
char pilihan[1];

int databaru;

int isEmptyH() {
    if(head == NULL) return 1;
    else return 0;
}
void tambahDepanH() {
    cout << "Masukkan data dari depan : ";
    cin>>databaru;

    TNode *baru;
    baru = new TNode;
    baru->data = databaru;
    baru->next = NULL;

    if (isEmptyH() == 1) {
        head = baru;
        head->next = NULL;
    } 
    else {
        baru->next = head;
        head = baru;
    }
    cout << "Data \""<<databaru<<"\" berhasil dimasukkan di dibagian depan."<<endl;
}
void tambahBelakangH() {
    cout << "Masukkan data dari belakang : ";
    cin>>databaru;

    TNode *baru, *bantu;
    baru = new TNode;
    baru->data = databaru;
    baru->next = NULL;
    if(isEmptyH() == 1) {
        head = baru;
        head->next = NULL;
    } 
    else {
        bantu = head;
        while(bantu->next != NULL){
            bantu = bantu->next;
        }
        bantu->next = baru;
    }
    cout << "Data \""<<databaru<<"\" berhasil dimasukkan di bagian belakang."<< endl;
}
void hapusDepanH() {
    TNode *hapus;
    int data;
    if(isEmptyH() == 0) {
        if(head->next != NULL){
            hapus = head;
            data = hapus->data;
            head = head -> next;
            delete hapus;
        } 
        else {
            data = head->data;
            head = NULL;
        }
        cout<<"Data \""<<data<<"\" yang berada di depan telah berhasil dihapus.";
    } 
    else cout<<"Tidak terdapat data pada Linked List";    
}
void hapusBelakangH() {
    TNode *hapus, *bantu;
    int data;
    if(isEmptyH()== 0) {
        if(head->next != NULL) {
            bantu = head;
            while(bantu -> next -> next != NULL) {
                bantu = bantu->next;
            }
            hapus = bantu->next;
            data = hapus->data;
            bantu->next=NULL;
            delete hapus;
        } else {
            data = head->data;
            delete head;
            head=NULL;
        }
        cout<<"Data \""<<data<<"\" yang berada di belakang telah berhasil dihapus.";
    } 
    else cout << "Tidak terdapat data pada Linked List";
}
void tampilkanH() {
    TNode *bantu;
    bantu = head;
    if(isEmptyH() == 0) {
        while(bantu != NULL) {
            cout<<bantu->data<<' ';
            bantu = bantu->next;
        }
        cout<<endl;
    } else cout<<"Tidak terdapat data pada Linked List";
}
void clearH() {
    TNode *bantu, *hapus;
    bantu = head;
    while(bantu != NULL) {
        hapus = bantu;
        bantu = bantu ->next;
        delete hapus;
    }
    head = NULL;
    cout<<"Seluruh data pada Linked List telah dibersihkan.";
}


void initHT(){
  head = NULL;
  tail = NULL;
}
int isEmptyHT(){
  return (tail == NULL);
}
void tambahDepanHT(){
  cout << "Masukkan data dari depan :  ";
  cin >> databaru;

  TNode *baru = new TNode;
  baru->data = databaru;
  baru->next = NULL;
  if (isEmptyHT()){
    head = baru;
    tail = baru;
  }
  else{
    baru->next = head;
    head = baru;
  }
  cout << "Data \"" << databaru << "\" berhasil dimasukkan di bagian depan" << endl;
}
void tambahBelakangHT(){
  cout << "Masukkan data dari belakang :  ";
  cin >> databaru;

  TNode *baru = new TNode;
  baru->data = databaru;
  baru->next = NULL;
  if (isEmptyHT()){
    head = baru;
    tail = baru;
  }
  else{
    tail->next = baru;
    tail = baru;
  }
  cout << "Data \"" << databaru << "\" berhasil dimasukkan di bagian belakang" << endl;
}
void tampilkanHT(){
  if (!isEmptyHT()){
    TNode *bantu = head;
    while (bantu != NULL){
      cout << bantu->data << ' ';
      bantu = bantu->next;
    }
    cout << endl;
  }
  else{
    cout << "Tidak terdapat data pada linked list";
  }
}
void hapusDepanHT() {
  if (!isEmptyHT()){
    TNode *hapus = head;
    int data = hapus->data;
    head = head->next;
    if (head == NULL){
      tail = NULL;
    }
    delete hapus;
    cout << "Data \"" << data << "\" yang berada di depan telah berhasil dihapus";
  }
  else{
    cout << "Tidak terdapat data pada linked list";
  }
}
void hapusBelakangHT(){
  if (!isEmptyHT()){
    TNode *hapus = tail;
    if (head == tail){
      head = tail = NULL;
    }
    else{
      TNode *bantu = head;
      while (bantu->next != tail){
        bantu = bantu->next;
      }
      bantu->next = NULL;
      tail = bantu;
    }
    cout << "Data \"" << hapus->data << "\" yang berada di belakang telah berhasil dihapus";
    delete hapus;
  }
  else
  {
    cout << "Tidak terdapat data pada linked list";
  }
}
void clearHT() {
  while (head != NULL){
    TNode *hapus = head;
    head = head->next;
    delete hapus;
  }
  tail = NULL;
  cout << "Seluruh data pada Linked List telah dibersihkan.";
}


int main()
{
    menu:
    cout<<"Single Linked List Non Circular (DLLNC)"<<endl;
    cout<<"======================================="<<endl;
    cout<<"Silahkan pilih program DLLNC yang ingin dijalankan!"<<endl;
    cout<<"1. DLLNC dengan Head"<<endl;
    cout<<"2. DLLNC dengan Head dan Tail"<<endl;
    cout<<"3. Quit"<<endl;
    cout<<"Pilihan : ";
    cin>>menu;
    system("cls");
    if(menu==1){
        do {
            cout<<"Single Linked List Non Circular (DLLNC) (Head)"<<endl;
            cout<<"====================================="<<endl;
            cout<<"1. Tambah Depan"<<endl;
            cout<<"2. Tambah Belakang"<<endl;
            cout<<"3. Tampilkan Data"<<endl;
            cout<<"4. Hapus Depan"<<endl;
            cout<<"5. Hapus Belakang"<<endl;
            cout<<"6. Reset"<<endl;
            cout<<"7. Kembali ke Menu"<<endl;
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
                case 6:
                    clearH();
                    break;
                default:
                    system("cls");
                    goto menu;
            }

            cout<<"Press any key to continue"<<endl;
            getch();
            system("cls");

        } while (pil<7);
    } 
    else if(menu==2){
        do {
            cout<<"Single Linked List Non Circular (DLLNC) (Head dan Tail)"<<endl;
            cout<<"======================================================="<<endl;
            cout<<"1. Tambah Depan"<<endl;
            cout<<"2. Tambah Belakang"<<endl;
            cout<<"3. Tampilkan Data"<<endl;
            cout<<"4. Hapus Depan"<<endl;
            cout<<"5. Hapus Belakang"<<endl;
            cout<<"6. Reset"<<endl;
            cout<<"7. Kembali ke Menu"<<endl;
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
                case 6:
                    clearHT();
                    break;
                default:
                    system("cls");
                    goto menu;
            }

            cout<<"Press any key to continue"<<endl;
            getch();
            system("cls");

        } while (pil<7);
    } else {
        cout<<"TERIMA KASIH"<<endl;
        cout<<"Program was made by Jovan Gilbert Natamasindah (2310817310002)."<<endl;
    }
}

