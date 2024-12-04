package soal2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);

        System.out.println("Pilih jenis hewan yang ingin diinputkan: ");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");

        System.out.print("Masukkan pilihan: ");
        String Pilihan = Inputan.nextLine();

        System.out.print("Nama hewan peliharaan: ");
        String Nama = Inputan.nextLine();
        System.out.print("Ras: ");
        String Ras = Inputan.nextLine();

        if(Pilihan.equals("1")) {
            System.out.print("Warna Bulu: ");
            String warnaBulu = Inputan.nextLine();

            Kucing cat = new Kucing(Ras, Nama, warnaBulu);
            cat.displayDetailKucing();
        }
        else if(Pilihan.equals("2")) {
            System.out.print("Warna Bulu: ");
            String warnaBulu = Inputan.nextLine();
            System.out.print("Kemampuan : ");
            String[] KemampuanGabung = new String[1];
            KemampuanGabung[0] = Inputan.nextLine();
            String[] Kemampuan = KemampuanGabung[0].split(", ");

            Anjing dog = new Anjing(Ras, Nama, warnaBulu, Kemampuan);
            dog.displayDetailAnjing();
        }
        Inputan.close();
    }
}