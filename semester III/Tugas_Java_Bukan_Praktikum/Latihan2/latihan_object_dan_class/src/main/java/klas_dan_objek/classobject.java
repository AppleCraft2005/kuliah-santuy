package klas_dan_objek;

class KonversiJarak {
    int jarakKM;

    public int toMeter(int jarakKM){
      int Hasil = jarakKM * 1000;
      return Hasil;
    }

    public int toCentimeter(int jarakKM) {
      int Hasil = jarakKM * 100000;
      return Hasil;
    }
}

public class classobject {
    public static void main(String[] args) {
        KonversiJarak jarakKampus = new KonversiJarak();
        KonversiJarak jarakBandara = new KonversiJarak();
        KonversiJarak jarakULMBJB = new KonversiJarak();
      //mengisi atribut class 
        jarakKampus.jarakKM = 5;
        jarakBandara.jarakKM = 23;
        jarakULMBJB.jarakKM = 32;

      //memanggil isi atribut 
        System.out.println("jarak yang harus ditempuh oleh Rizki dari rumah ke kampus adalah " + 
        jarakKampus.toMeter(jarakKampus.jarakKM) + " meter dan " + jarakKampus.toCentimeter(jarakKampus.jarakKM) + " centimeter");
        System.out.println("jarak yang harus ditempuh oleh Damar dari rumah ke Bandara adalah " + 
        jarakBandara.toMeter(jarakBandara.jarakKM) + " meter dan " + jarakBandara.toCentimeter(jarakBandara.jarakKM) + " centimeter");
        System.out.println("jarak yang harus ditempuh oleh Jovan dari rumah ke ULM Banjarbaru adalah " + 
        jarakULMBJB.toMeter(jarakULMBJB.jarakKM) + " meter dan " + jarakULMBJB.toCentimeter(jarakULMBJB.jarakKM) + " centimeter");
    }
}