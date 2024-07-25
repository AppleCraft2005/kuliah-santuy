#include <stdio.h>

int maksimal(int a, int b){

    if (a > b) {

        return a;
    }

    else  {

        return b;
    }

}

int minimal(int a, int b){

    if (a < b) {

        return a;
    }

    else {
        return b;
    }

}


int main(){
    int batas = 0;
    int maks = -100000;
    int minim = 100000;
    int bilangan;

    printf("Masukkan bilangan : ");
    scanf("%d", &bilangan);

    while(batas < bilangan){

        int nilai;

        scanf("%d", &nilai); 
        maks = maksimal(maks, nilai);
        minim = minimal(minim, nilai);
        batas++;

    }
    
    printf("bilangan maksimal dan minimum adalah : %d %d",maks,minim); 
}

