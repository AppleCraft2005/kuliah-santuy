package soal1_polymorphism;

abstract class CelciusConvert {
    void Celcius() {
        System.out.println("Suhu Sebelum konversi = 50°C");
    }
    abstract double convert(); 
    abstract void hasil();
}
