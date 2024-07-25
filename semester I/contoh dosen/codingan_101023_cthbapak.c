/*ARRAY

* cara mendeklarasikan array :
    tipe_data nama_array [ukuran_array];
*/ 

#include <stdio.h>

void main () {
    int angka[6] = {1,2,3,4,5,6};

    printf("%d\n", angka[3]);      //memanggil hanya satu array
    
    for(int i = 0; i < 6; i++) {    // memanggil semua array
        printf("%d", angka[i]);
    }
}

