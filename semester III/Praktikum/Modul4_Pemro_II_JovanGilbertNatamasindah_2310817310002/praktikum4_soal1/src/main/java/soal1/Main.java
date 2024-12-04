package soal1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);

        System.out.print("Nama Hewan Peliharaan: ");
        String Nama = Inputan.nextLine();
        System.out.print("Ras: ");
        String Ras = Inputan.nextLine();

        HewanPeliharaan pet = new HewanPeliharaan(Ras, Nama);
        pet.display();
        Inputan.close();
    }
}