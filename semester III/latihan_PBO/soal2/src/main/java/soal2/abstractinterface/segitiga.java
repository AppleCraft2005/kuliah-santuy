package soal2.abstractinterface;

public class segitiga extends BangunDatar {
    public int alas;
    public int tinggi;
    public segitiga(int Alas, int Tinggi) {
        this.alas = Alas;
        this.tinggi = Tinggi;
    }
    @Override
    public double hitungLuas() {
        return this.alas * this.tinggi / 2.0;
    }
    @Override
    public void tampilHasil() {
        System.out.printf("Luas             : %f cm^2", hitungLuas());
    }
}
