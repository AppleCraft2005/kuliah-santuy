package soal2.abstractinterface;

public class PersegiPanjang extends BangunDatar implements Keliling,simetri{
    public int panjang;
    public int lebar;
    public PersegiPanjang(int Panjang, int Lebar) {
        this.panjang = Panjang;
        this.lebar = Lebar;
    }
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
        System.out.printf("Luas             : %.1f cm^2              keliling        : %.1f cm \n", hitungLuas(), hitungKeliling());
        System.out.printf("Simetri lipat    : %.1f                    Simetri putar   : %.1f ", hitungSimLipat(), hitungSimPutar());
    }
}
