package array;

import java.util.Scanner;

public class arrayAngka {

    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);

        System.out.print("Masukkan ukuran dari array: ");
        int panjangArray = Inputan.nextInt();

        int[] angka = new int[panjangArray];

        for(int i = 0 ; i < panjangArray ; i++) {
            System.out.print("Masukkan data ke-" + i + ": ");
            angka[i] = Inputan.nextInt();
        } 

        System.out.print("Isi Array Angka = ");
        for(int i = 0 ; i < panjangArray ; i++) {
            System.out.print(angka[i] + " ");
        }

        System.out.printf("\n\n");

        System.out.println("Panjang array: " + panjangArray);
        System.out.println("Nilai array: " + angka[2]);
    }
}