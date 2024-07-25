#include <stdio.h>
#include <string.h>     //berfungsi untuk memanggil dungsi yang berkaitan dengan string

// Fungsi untuk menghitung nilai MCXI dari string, fungsi calculateMCXIValue digunakan untuk menerima parameter str, yaitu string MCXI 
int calculateMCXIValue(char *str) {
    int value = 0, multiplier = 1, i; // value untuk menyimpan hasil perhitungan dan multiplier sebagai faktor pengali awal

    for (i = 0; i < strlen(str); i++) {
        if (str[i] >= '2' && str[i] <= '9') {
            multiplier = str[i] - '0'; // Mengambil angka sebagai multiplier
        } 
        else {
            switch (str[i]) {
                case 'm': value += multiplier * 1000; 
                break;
                case 'c': value += multiplier * 100; 
                break;
                case 'x': value += multiplier * 10; 
                break;
                case 'i': value += multiplier * 1; 
                break;
            }
            multiplier = 1; // Reset multiplier ke 1 setelah digunakan
        }
    }

    return value;
}

// Fungsi untuk mengonversi nilai MCXI ke dalam bentuk string
void convertToMCXIString(char *result, int value) {
    char symbols[] = "mcxi";
    int multipliers[] = {1000, 100, 10, 1};
    int i;

    for (i = 0; i < 4; i++) {
        int count = value / multipliers[i];
        if (count > 1) {
            result[strlen(result)] = count + '0';
        }
        if (count > 0) {
            result[strlen(result)] = symbols[i];
        }
        value %= multipliers[i];
    }
}

int main() {
    int n;
    scanf("%d", &n);

    while (n--) {
        char s1[10], s2[10], result[10] = "";
        scanf("%s %s", s1, s2);

        int value1 = calculateMCXIValue(s1);
        int value2 = calculateMCXIValue(s2);

        int sum = value1 + value2;
        convertToMCXIString(result, sum);

        printf("%s\n", result);
    }

    return 0;
}


// #include <stdio.h>

// int charToValue(char c) {       //untuk mengonversi M,C,X,I menjadi nilai numerik
//     switch (c) {
//         case 'm': 
//         return 1000;
//         case 'c': 
//         return 100;
//         case 'x': 
//         return 10;
//         case 'i': 
//         return 1;
//         default: 
        
//         return 0;
//     }
// }

// int MCXItoValue(char *mcxi) {       //untuk mengoversi string M,C,X,I ke nilai numerik, jika karakter berupa angka antara '2' dan '9' maka nilai 
//     int value = 0;                      //tersebut akan diperbarui dengan angka tersebut, tetapi jika karakter 'M','C','X','I' maka nilai akan dihitung 
//     int multiplier = 1;                 //dengan mengalikan karakter tersebut dengan multiplier dan ditambahkan ke nilai total dan multiplier diatur kembali menjadi 1 setelah digunakan

//     for (int i = 0; mcxi[i] != '\0'; i++) {
//         int currentVal = charToValue(mcxi[i]);

//         if (currentVal == 0) {
//             multiplier = mcxi[i] - '0';
//         } else {
//             value += currentVal * multiplier;
//             multiplier = 1;
//         }
//     }

//     return value;
// }

// void valueToMCXI(int value) {           //untuk mengonversi nilai numerik menjadi bentuk string M,C,X,I, fungsi ini melakukan proses pengulangan dalam menyelesaikan 
//     char symbols[] = "mcxi";                // masalah melalui karakter-karakter MCXI dan mencetak jumlah dari masing-masing karakter berdasarkan nilai. jika karakternya lebih dari satu maka akan mencetak jumlahnya terlebih dahulu baru karakter MCXInya
//     int units[] = {1000, 100, 10, 1};       // Tapi jika hanya ada satu karakter yang harus dicetak maka karakter tersebut yang akan dicetak
//     int printed = 0;                        //

//     for (int i = 0; i < 4; i++) {
//         int count = value / units[i];
//         value %= units[i];

//         if (count > 1) {
//             printf("%d%c", count, symbols[i]);
//             printed = 1;
//         } 
//         else if (count == 1) {
//             printf("%c", symbols[i]);
//             printed = 1;
//         } 
//         if (printed) {
//             printf("0");
//         }
//     }
//     printf("\n");
// }

// int main() {
//     int n;
//     scanf("%d", &n);

//     while (n--) {
//         char mcxi1[10], mcxi2[10];
//         scanf("%s %s", mcxi1, mcxi2);

//         int value1 = MCXItoValue(mcxi1);
//         int value2 = MCXItoValue(mcxi2);
//         int sum = value1 + value2;

//         valueToMCXI(sum);
//     }

//     return 0;
// }