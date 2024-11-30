package soal2;

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
        System.out.println("Detail Hewan Peliharaan: ");
        System.err.println("Nama hewan peliharaanku adalah : " + nama);
        System.out.println("Dengan ras : " + ras);
     }
}

class Kucing extends HewanPeliharaan {
    String warnaBulu;

    Kucing(String r, String n, String w) {
        super(r, n);
        this.warnaBulu = w;
    }

    void displayDetailKucing() {
        super.display();
        System.out.println("Memiliki warna bulu: " + warnaBulu);
    }
}

class Anjing extends HewanPeliharaan {
    String warnaBulu;
    String[] Kemampuan;

    Anjing(String n, String r, String w, String[] Kemampuan) {
        super(n, r);
        this.warnaBulu = w;
        this.Kemampuan = Kemampuan;
    }

    void displayDetailAnjing() {
        super.display();
        System.out.println("Memiliki warna bulu : " + warnaBulu);
        System.out.print("Memiliki Kemampuan :");
        for(int i = 0 ; i < Kemampuan.length ; i++) {
            System.out.print(" " + Kemampuan[i]);
        }
    }
}

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