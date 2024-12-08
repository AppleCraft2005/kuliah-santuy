package soal1_polymorphism;

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