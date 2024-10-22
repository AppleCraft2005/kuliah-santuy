package praktikum2.soal1;

class Buah {
    String Nama;
    double Berat;
    double Harga;
    double jumlahBeli;
    double sebelumDiskon;
    double totalDiskon;
    double setelahDiskon;

    void showInfo() {
        System.out.println("Nama buah: " + Nama);
        System.out.println("Berat: " + Berat);
        System.out.println("Harga: " + Harga);
        System.out.println("Jumlah Beli: " + jumlahBeli + " kg");
        System.out.println("Harga Sebelum Diskon: " + hargaSebelumDiskon());
        System.out.println("Total Diskon: " + TotalDiskon());
        System.out.println("Harga Setelah Diskon: " + hargaSetelahDiskon());
    }
    double hargaSebelumDiskon() {
        return jumlahBeli / Berat * Harga;
    }
    double TotalDiskon() {
        // double persenDiskon = Math.floor(jumlahBeli / 4) * 0.02;
        // return persenDiskon * hargaSebelumDiskon();

        double persenDiskon = Math.floor(jumlahBeli / 4) * 0.02;
        return persenDiskon * Harga * 4;

        // double jumlah4KG = (jumlahBeli / 4);
        // double hargaPer4KG = Harga * (4 / Berat);
        // return jumlah4KG * hargaPer4KG * 0.02;
    }
    double hargaSetelahDiskon() {
        return hargaSebelumDiskon() - TotalDiskon();
    }
}

public class Main {
    public static void main(String[] args) {
        Buah buah1 = new Buah();
        buah1.Nama = "Apel";
        buah1.Berat = 0.4;
        buah1.Harga = 7000;
        buah1.jumlahBeli = 40;
        buah1.showInfo();

        System.out.println();

        Buah buah2 = new Buah();
        buah2.Nama = "mangga";
        buah2.Berat = 0.2;
        buah2.Harga = 3500;
        buah2.jumlahBeli = 15;
        buah2.showInfo();

        System.out.println();

        Buah buah3 = new Buah();
        buah3.Nama = "alpukat";
        buah3.Berat = 0.25;
        buah3.Harga = 10000;
        buah3.jumlahBeli = 12;
        buah3.showInfo();
    }
}