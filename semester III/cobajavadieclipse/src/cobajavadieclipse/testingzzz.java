package cobajavadieclipse;

class Mobiltest {
    String warna;
    int tahunProduksi;
    String merk;
}

public class classobject {
    public static void main(String[] args) {
        Mobiltest mobilku = new Mobiltest();
      //mengisi atribut class 
        mobilku.tahunProduksi = 2007;
        mobilku.warna = "Merah";

      //memanggil isi atribut 
        System.out.println("Warna mobil: " + mobilku.warna);
        System.out.println("Tahun produksi: " + mobilku.tahunProduksi);
    }
}