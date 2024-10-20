package praktikum2.soal2;

class Kopi {
    String nama;
    String namaKopi;
    String ukuran;
    double harga;

    public void info() {
        System.out.println("Nama Kopi: " + namaKopi);
        System.out.println("Ukuran: " + ukuran);
        System.out.println("Harga: " + harga);        
    }
    public void setPembeli(String Nama) {
         this.nama = Nama;
    }
    public String getPembeli() {
        return nama;
    }
  
    public double getPajak() {
        return harga * 11/100;
    }
}

public class Soal2Main {
    public static void main(String[] args) {
        Kopi kopi1 = new Kopi();
        kopi1.namaKopi = "Espresso";
        kopi1.ukuran = "Medium";
        kopi1.harga = 25000;

        kopi1.info();
        kopi1.setPembeli("Alice");
        System.out.println("Pembeli Kopi: " + kopi1.getPembeli());
        System.out.println("Pajak Kopi: Rp. " + kopi1.getPajak());

    }
}