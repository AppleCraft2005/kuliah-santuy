package soal1_polymorphism;

abstract class CelciusConvert {
    void Celcius() {
        System.out.println("Suhu Sebelum konversi = 50°C");
    }
    abstract double convert(); 
    abstract void hasil();
}

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

public class Main {
    public static void main(String[] args) {
        CelciusConvert celcius1;

        celcius1 = new toKelvin(50);
        celcius1.Celcius();
        celcius1.hasil();

        celcius1 = new toFahrenheit(50);
        celcius1.hasil();
    }
}