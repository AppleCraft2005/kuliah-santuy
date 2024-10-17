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
      //mengisi atribut class 
        jarakKampus.jarakKM = 5;
        jarakBandara.jarakKM = 28;

      //memanggil isi atribut 
        System.out.println("jarak yang harus ditempuh oleh Rizki dari rumah ke kampus adalah " + 
        jarakKampus.toMeter(jarakKampus.jarakKM) + " meter dan " + jarakKampus.toCentimeter(jarakKampus.jarakKM) + " centimeter");
        System.out.println("jarak yang harus ditempuh oleh Damar dari rumah ke Bandara adalah " + 
        jarakBandara.toMeter(jarakBandara.jarakKM) + " meter dan " + jarakBandara.toCentimeter(jarakBandara.jarakKM) + " centimeter");

    }
}