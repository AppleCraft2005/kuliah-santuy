package soal1_polymorphism;

class toKelvin extends CelciusConvert {
    double celcius;
    toKelvin(double celcius) {
        this.celcius = celcius;
    }
    @Override
    double convert() {
        return celcius + 273.15;
    }
    @Override
    void hasil() {
        System.out.println("Hasil konversi dari celcius ke kelvin adalah " + convert() + "°K");
    }
}