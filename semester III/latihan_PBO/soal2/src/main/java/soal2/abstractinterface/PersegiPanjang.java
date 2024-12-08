package soal2.abstractinterface;

public class PersegiPanjang extends BangunDatar implements Keliling,simetri{
    public int panjang;
    public int lebar;
    @Override
    public double hitungLuas() {
        return this.panjang * this.lebar;
    }
    @Override
    public double hitungKeliling() {
        return 2 * (this.panjang + this.lebar);
    }
    @Override
    public double hitungSimPutar() {
        return 2.0;
    }
    @Override
    public double hitungSimLipat() {
        return 2.0;
    }
    @Override
    public void tampilHasil() {
        System.out.println("Luas : " + this.hitungLuas());
        System.out.println("Keliling : " + this.hitungKeliling());
        System.out.println("simetri lipat : " + this.hitungSimLipat());
        System.out.println("simetri putar : " + this.hitungSimPutar());
    }
}
