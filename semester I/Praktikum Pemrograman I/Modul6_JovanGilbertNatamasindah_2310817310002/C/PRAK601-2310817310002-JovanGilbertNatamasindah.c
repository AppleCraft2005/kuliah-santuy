#include <stdio.h>

void main() {
    int V,H;

    printf("Masukkan ukuran Vertikal (V) dan Horizontal (H) matriks : ");
    scanf("%d %d", &V,&H);
    printf("Masukkan angka matriks : ");

    int arr[V][H];
        
        for(int i = 0 ; i < V ; i++) {
            for(int j = 0 ; j < H ; j++) {
                scanf("%d", &arr[i][j]);
            }
        }

        printf("\nMatriks %d x %d : \n\n",V,H);

        for(int i = 0 ; i < V ; i++) {
            for(int j = 0 ; j < H ; j++) {
                printf("%d ", arr[i][j]);
            }
            printf("\n");
        }
}



