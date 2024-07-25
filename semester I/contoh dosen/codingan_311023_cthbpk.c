// function pada C

// return_type function_nama (parameter list) {
//     body of the function
// }

//pemanggilan fungsi

// function_name (argument list);

//contoh membuat kalkulator dengan fungsi

#include<stdio.h>

int aritmatika( int a, int OPERATOR, int b) {

    if(OPERATOR == '+') {
        return a + b;
    }
    else if(OPERATOR == '-') {
        return a - b;
    }
    else if(OPERATOR == '*') {
        return a * b;
    }
    else if(OPERATOR == '/') {
        return a / b;
    }
    else {
        printf("Invalid operator");
    }
}

void main() {
    int ANGKA1,ANGKA2;
    char OPERATOR;

    printf("\n=====KALKULATOR=====\n");
    printf("\nFormat input : angka operator angka\n\n");

    printf("Masukkan Angka dan Operasi : ");
    scanf("%d %c %d",&ANGKA1,&OPERATOR,&ANGKA2);

    printf("Hasilnya adalah %d ", aritmatika(ANGKA1, OPERATOR, ANGKA2));

}