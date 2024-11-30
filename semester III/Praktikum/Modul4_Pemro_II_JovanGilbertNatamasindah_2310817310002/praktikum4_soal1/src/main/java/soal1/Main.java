package soal1;

import java.util.Scanner;

class HewanPeliharaan {
    String nama;
    String ras;

    HewanPeliharaan(String r, String n) {
        this.ras = r;
        this.nama = n;
    }

    void display() {
        System.out.println("");
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : " + nama);
        System.out.println("Dengan ras : " + ras);
    }
}

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