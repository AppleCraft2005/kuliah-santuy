class Mobiltest {
    String warna;
    int tahunProduksi;
}

public class Latihan_Object_dan_Class {
    public static void main(String[] args) {
        Mobiltest mobilku = new Mobiltest();
        mobilku.tahunProduksi = 2007;
        mobilku.warna = "Merah";

        System.out.println("Warna mobil: " + mobilku.warna);
        System.out.println("Tahun produksi: " + mobilku.tahunProduksi);
    }
}
