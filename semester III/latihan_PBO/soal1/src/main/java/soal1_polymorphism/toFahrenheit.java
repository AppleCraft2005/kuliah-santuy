package soal1_polymorphism;

class toFahrenheit extends CelciusConvert {
    double celcius;
    toFahrenheit(double celcius) {
        this.celcius = celcius;
    }
    @Override
    double convert() {
        return (celcius * 9/5) + 32;
    }
    @Override
    void hasil() {
        System.out.println("Hasil konversi dari celcius ke Fahrenhiet adalah " + convert() + "°F");
    }
}
