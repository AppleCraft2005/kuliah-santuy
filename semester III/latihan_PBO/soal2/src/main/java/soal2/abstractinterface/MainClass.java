package soal2.abstractinterface;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("PERSEGI");
        Persegi p1 = new Persegi(3);
        p1.tampilHasil();

        System.out.println("\n\nPERSEGI PANJANG");
        PersegiPanjang pp1 = new PersegiPanjang(3,9);
        pp1.tampilHasil();

        System.out.println("\n\nLINGKARAN");
        Lingkaran l1 = new Lingkaran(19);
        l1.tampilHasil();

        System.out.println("\n\nSEGITIGA");
        segitiga s1 = new segitiga(3,8);
        s1.tampilHasil();
    }
}