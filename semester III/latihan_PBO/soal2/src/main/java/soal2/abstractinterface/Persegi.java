package soal2.abstractinterface;

public class Persegi extends BangunDatar implements Keliling, simetri{
    public int sisi;
    public Persegi(int Sisi){
        this.sisi = Sisi;
    }
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
    @Override
    public void tampilHasil() {
        System.out.printf("Luas             : %.1f cm^2               keliling        : %.1f cm \n", hitungLuas(), hitungKeliling());
        System.out.printf("Simetri lipat    : %.1f                    Simetri putar   : %.1f ", hitungSimLipat(), hitungSimPutar());
    }
}
