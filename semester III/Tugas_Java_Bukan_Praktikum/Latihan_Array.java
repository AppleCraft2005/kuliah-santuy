import java.util.ArrayList;
import java.util.Scanner;

public class Latihan_Array {
 public static void main(String[] args) {
   ArrayList<DataMahasiswa> ListMahasiswa = new ArrayList<>();
   Scanner Inputan = new Scanner(System.in);

   for(int i = 0 ; i < 999 ; i++) {
      System.out.print("Masukkan Nama Mahasiswa : ");
      String Nama = Inputan.nextLine();
      System.out.print("Masukkan NIM            : ");
      String NIM = Inputan.nextLine();
      System.out.print("Masukkan Nilai UTS      : ");
      double UTS = Inputan.nextDouble();
      System.out.print("Masukkan Nilai UAS      : ");
      double UAS = Inputan.nextDouble();

      System.out.println();
      Inputan.nextLine();

      System.out.print("ingin menambah data lagi?(y/n): ");
      String Pilihan = Inputan.nextLine();
      if(Pilihan.equals("n")) {
         break;
      }
      
      DataMahasiswa mhs = new DataMahasiswa(NIM, Nama, UTS, UAS);
      ListMahasiswa.add(mhs);

   }
    System.out.println("=======================================================");
    System.out.printf("%-4s %-5s %-10s %-5s %-5s %-12s %s\n", "No", "NIM", "Nama", "UTS", "UAS", "Nilai Akhir", "Index");
    for(int i = 0; i < ListMahasiswa.size(); i++) {
      DataMahasiswa mhsLagi = ListMahasiswa.get(i);
      System.out.printf("%-4d %-5s %-10s %-5.1f %-5.1f %-12.2f %c\n", i+1, mhsLagi.NIM, mhsLagi.Nama, mhsLagi.UTS, mhsLagi.UAS, mhsLagi.NilaiAkhir, mhsLagi.Index);
    }
    System.out.println("=======================================================");
 }

}

class DataMahasiswa {
   String NIM;
   String Nama;
   double UTS;
   double UAS;
   double NilaiAkhir;
   char Index;

   public DataMahasiswa(String NIM, String Nama, double UTS, double UAS) {
      this.NIM = NIM;
      this.Nama = Nama;
      this.UTS = UTS;
      this.UAS = UAS;
      this.NilaiAkhir = (UAS + UTS) / 2;
      this.Index = MenentukanIndex(this.NilaiAkhir);
   }

   public char MenentukanIndex(double NilaiAkhir) {
      if(NilaiAkhir >= 80) {
         return 'A';
      }
      else if(NilaiAkhir >= 70 ) {
         return 'B';
      }
      else if(NilaiAkhir >= 60) {
         return 'C';
      }
      else {
         return 'D';
      }
   }
}