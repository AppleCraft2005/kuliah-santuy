package soal2.abstractinterface;

public class segitiga extends BangunDatar {
    public int alas;
    public int tinggi;
    @Override
    public double hitungLuas() {
        return this.alas * this.tinggi / 2.0;
    }
    @Override
    public void tampilHasil() {
        System.out.println("Luasnya : " + this.hitungLuas());
    }
}
