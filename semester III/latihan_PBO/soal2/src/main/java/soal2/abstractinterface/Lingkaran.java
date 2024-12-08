package soal2.abstractinterface;

public class Lingkaran extends BangunDatar implements Keliling, simetri{
    public int jejari;
    @Override
    public double hitungLuas() {
        return Math.PI * this.jejari * this.jejari;
    }
    @Override
    public double hitungKeliling() {
        return 2 * Math.PI * this.jejari;
    }
    @Override
    public double hitungSimPutar() {
        return Double.POSITIVE_INFINITY;
    }
    @Override
    public double hitungSimLipat() {
        return Double.POSITIVE_INFINITY;
    }
    @Override
    public void tampilHasil() {
        System.out.println("Luas : " + this.hitungLuas());
        System.out.println("Keliling : " + this.hitungKeliling());
        System.out.println("simetri lipat : " + this.hitungSimLipat());
        System.out.println("simetri putar : " + this.hitungSimPutar());
    }
}
