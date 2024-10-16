package array;

import java.util.Scanner;

public class arrayAngka {

    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);

        System.out.print("Masukkan ukuran dari array: ");
        int panjangArray = Inputan.nextInt();

        Inputan.nextLine();

        String[] Nama = new String[panjangArray];

        for(int i = 0 ; i < panjangArray ; i++) {
            System.out.print("Masukkan data ke-" + i + ": ");
            Nama[i] = Inputan.nextLine();
        } 

        System.out.print("Isi Array Nama = ");
        for(int i = 0 ; i < panjangArray ; i++) {
            System.out.print(Nama[i] + " ");
        }

        System.out.printf("\n\n");

        System.out.println("Panjang array: " + panjangArray);
        System.out.println("Nilai array: " + Nama[2]);
    }
}