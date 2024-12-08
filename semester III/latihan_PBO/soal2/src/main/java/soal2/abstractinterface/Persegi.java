package soal2.abstractinterface;

public class Persegi extends BangunDatar implements Keliling, simetri{
    public int sisi;
    @Override
    public double hitungLuas() {
        return this.sisi * this.sisi;
    }
    @Override
    public double hitungKeliling() {
        return 4 * this.sisi;
    }
    @Override
    public double hitungSimPutar() {
        return 4.0;
    }
    @Override
    public double hitungSimLipat() {
        return 4.0;
    }
    public void tampilHasil() {
        System.out.println("Luas : " + this.hitungLuas());
        System.out.println("Keliling : " + this.hitungKeliling());
        System.out.println("simetri lipat : " + this.hitungSimLipat());
        System.out.println("simetri putar : " + this.hitungSimPutar());
    }
}
