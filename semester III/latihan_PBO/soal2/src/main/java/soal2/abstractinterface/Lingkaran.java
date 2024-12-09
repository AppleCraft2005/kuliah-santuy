package soal2.abstractinterface;

public class Lingkaran extends BangunDatar implements Keliling, simetri{
    public int jejari;
    public Lingkaran(int Jejari) {
        this.jejari = Jejari;
    }
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
        System.out.printf("Luas             : %f cm^2       keliling        : %f cm \n", hitungLuas(), hitungKeliling());
        System.out.printf("Simetri lipat    : %.1f               Simetri putar   : %.1f ", hitungSimLipat(), hitungSimPutar());
    }
}
