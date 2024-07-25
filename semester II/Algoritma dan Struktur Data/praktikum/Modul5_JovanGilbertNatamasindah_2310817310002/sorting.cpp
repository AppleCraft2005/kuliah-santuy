#include <iostream>
#include <conio.h>
#include <iomanip>
#include <stdlib.h>

using namespace std;

int bubbleSort();
int selectionSort();
int quickSort();
int insertionSort();
int mergeSort();
int shellSort();


int main() {
    int Pilihan;

    do {
        cout << "SORTING" << endl;
        cout << "1. Insertion Sort" << endl;
        cout << "2. Merge Sort" << endl;
        cout << "3. Shell Sort" << endl;
        cout << "4. Quick Sort" << endl;
        cout << "5. Bubble Sort" << endl;
        cout << "6. Selection Sort" << endl;
        cout << "7. Exit" << endl;
        cout << "Masukkan Pilihan : ";
        cin >> Pilihan;
        system("cls");

            switch(Pilihan) {
                case 1:
                    insertionSort();
                    break;
                case 2 :
                    mergeSort();
                    break;
                case 3 :
                    shellSort();
                    break;
                case 4 :   
                    quickSort();
                    break;
                case 5 :
                    bubbleSort();
                    break;
                case 6 :
                    selectionSort();
                    break;
                default :
                    cout << "\nTERIMA KASIH" << endl;                    
            }
        getch();
        system("cls");

    }
    while(Pilihan < 8);

} 

int bubbleSort() {
    string data;
    int swap;

    cout<<"========Bubble Sort========"<<endl;

    cout<<"Masukkan Data : ";
    cin >> data;
    cout<<endl;

    cout<<"Data sebelum diurutkan : "<< endl;
    for(int i=0 ; i<data.length() ; i++) {
        cout<<setw(3)<<data[i];
    }
    cout<<endl;

    for(int i=0 ; i<data.length()-1 ; i++) {
        for(int j=0 ; j<data.length()-1 ; j++) {
            if(data[j] > data[j+1]) {
                swap = data[j];
                data[j] = data[j+1];
                data[j+1] = swap;
            }
        }
    }
    cout<<"Data setelah diurutkan : "<< endl;
    for(int i=0 ; i<data.length() ; i++ ) {
        cout<<setw(3)<<data[i];
    }
    
}

int selectionSort() {
    string data;
    int terkecil;

    cout<<"========Selection Sort========"<<endl;

    cout<< "Masukkan data : ";
    cin >> data;

    cout<<"Data sebelum diurutkan : "<<endl;
    for(int i=0 ; i<data.length() ; i++) {
        cout<<setw(3)<<data[i];
    }
    cout<<endl;
    for(int i=0 ; i<data.length() ; i++) {
        terkecil = i;
        for(int j=i+1 ; j<data.length() ; j++) {
            if(data[terkecil] > data[j]) {
                terkecil = j;
            }
        }
        if(terkecil != i) {
            int swap = data[i];
            data[i] = data[terkecil];
            data[terkecil] = swap;
        }

    }
    cout<<"Data setelah diurutkan : "<<endl;
    for(int i=0 ; i<data.length() ; i++) {
        cout<<setw(3)<<data[i];
    }

}

int Partition(string& data, int Low , int High) {
    int pivot = data[High];
    int i = Low -1;

    for(int j = Low ; j < High ; j++) {
        if(data[j] <= pivot) {
            i++;
            int swap = data[i];
            data[i] = data[j];
            data[j] = swap;
        }
    }
    int swap = data[i+1];
    data[i+1]=data[High];
    data[High]=swap;

    return(i+1);
}

void QuickSort(string& data, int Low, int High) {
    if(Low < High) {
        int pi = Partition(data,Low,High);
        QuickSort(data, Low, pi-1);
        QuickSort(data, pi+1, High);
    }
}

int quickSort() {
    string data;
    int Low = 0;

    cout<<"========Quick Sort========"<<endl;

    cout<< "Masukkan data : ";
    cin >> data;

    cout<<"Data sebelum diurutkan : "<<endl;
    for(int i=0 ; i<data.length() ; i++) {
        cout<<setw(3)<<data[i];
    }
    cout<<endl;

    QuickSort(data, Low, data.length()-1);

    cout<<"Data setelah diurutkan : "<<endl;
    for(int i=0 ; i<data.length() ; i++) {
        cout<<setw(3)<<data[i];
    }
}

int insertionSort() {
    string data;
    int i, key, j;
    cout<<"========Insertion Sort========"<<endl;

    cout<< "Masukkan data : ";
    cin >> data;

    cout<<"Data sebelum diurutkan : "<<endl;
    for(int i=0 ; i<data.length() ; i++) {
        cout<<setw(3)<<data[i];
    }
    cout<<endl;

    for( i=1 ; i<data.length() ; i++) {
        key = data[i];
        j = i-1;

        while(j >= 0 && data[j] > key) {
            data[j+1] = data[j];
            j = j - 1;
        }
        data[j+1] = key;
    }


    cout<<"Data setelah diurutkan : "<<endl;
    for(int i=0 ; i<data.length() ; i++) {
        cout<<setw(3)<<data[i];
    }
}

void Merge(string& data, int Low, int Mid,int High) {
    int SubArr1 = Mid - Low + 1;
    int SubArr2 = High - Mid;
    char L[SubArr1], R[SubArr2];

    for(int i=0 ; i<SubArr1 ; i++ ) {
        L[i] = data[Low + i];
    }
    for(int j=0 ; j<SubArr2 ; j++) {
        R[j] = data[Mid + 1 + j];
    }

    int i = 0;
    int j = 0;
    int k = Low;

    while(i < SubArr1 && j < SubArr2) {
        if(L[i] <= R[j]) {
            data[k] = L[i];
            i++;
        }
        else {
            data[k] = R[j];
            j++;
        }
        k++;
    }

    while(i < SubArr1) {
        data[k] = L[i];
        i++;
        k++;
    }

    while(j < SubArr2) {
        data[k] = R[j];
        j++;
        k++;
    }
}

void MergeSort(string& data, int Low, int High) {
    if(Low < High) {
        int Mid = Low + (High - Low) / 2;
        MergeSort(data, Low, Mid);
        MergeSort(data, Mid + 1, High);
        Merge(data, Low, Mid, High);
    }
}

int mergeSort() {
    string data;
    int Low = 0;

    cout<<"========Merge Sort========"<<endl;

    cout<< "Masukkan data : ";
    cin >> data;

    cout<<"Data sebelum diurutkan : "<<endl;
    for(int i=0 ; i<data.length() ; i++) {
        cout<<setw(3)<<data[i];
    }
    cout<<endl;

    MergeSort(data, Low, data.length()-1);

    cout<<"Data setelah diurutkan : "<<endl;
    for(int i=0 ; i<data.length() ; i++) {
        cout<<setw(3)<<data[i];
    }
}

int shellSort() {
    string data;

    cout<<"========Shell Sort========"<<endl;

    cout<< "Masukkan data : ";
    cin >> data;

    cout<<"Data sebelum diurutkan : "<<endl;
    for(int i=0 ; i<data.length() ; i++) {
        cout<<setw(3)<<data[i];
    }
    cout<<endl;

    for(int Gap = data.length()/2 ; Gap>0 ; Gap /= 2 ) {
        for(int i = Gap ; i < data.length() ; i += 1) {
            char temp = data[i];
            int j;
            for(j = i ; j >= Gap && data[j-Gap] > temp ; j -= Gap) {
                data[j] = data[j-Gap];
            }
            data[j] = temp;
        }
    }

    cout<<"Data setelah diurutkan : "<<endl;
    for(int i=0 ; i<data.length() ; i++) {
        cout<<setw(3)<<data[i];
    }
}