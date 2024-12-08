package soal2.abstractinterface;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("PERSEGI");
        Persegi p1 = new Persegi();
        p1.sisi = 3;
        p1.tampilHasil();

        System.out.println("\n\nPERSEGI PANJANG");
        PersegiPanjang pp1 = new PersegiPanjang();
        pp1.panjang = 3;
        pp1.lebar = 9;
        pp1.tampilHasil();

        System.out.println("\n\nLINGKARAN");
        Lingkaran l1 = new Lingkaran();
        l1.jejari = 19;
        l1.tampilHasil();

        System.out.println("\n\nSEGITIGA");
        segitiga s1 = new segitiga();
        s1.alas = 3;
        s1.tinggi = 8;
        s1.tampilHasil();
    }
}