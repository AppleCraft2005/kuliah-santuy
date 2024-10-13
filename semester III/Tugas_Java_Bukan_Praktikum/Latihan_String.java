import java.util.Scanner;
import java.util.HashMap;

public class Latihan_String {
    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);

        System.out.print("Masukkan Angka Romawi: ");
        String Romawi = inputan.nextLine().toUpperCase();

        int Hasil = 0, NilaiSebelum = 0;

        HashMap<Character,Integer> ListRomawi = new HashMap<>();
        ListRomawi.put('I', 1);
        ListRomawi.put('V', 5);
        ListRomawi.put('X', 10);
        ListRomawi.put('L', 50);

        for(int i = Romawi.length()-1 ; i >= 0 ; i--) {
            int NilaiSekarang = ListRomawi.get(Romawi.charAt(i));

            if(NilaiSebelum > NilaiSekarang) {
                Hasil -= NilaiSekarang;
            }
            else if(NilaiSebelum <= NilaiSekarang) {
                Hasil += NilaiSekarang;
            }

            NilaiSebelum = NilaiSekarang;
        }


        System.out.println("Hasil konversi angka romawi dari " + Romawi + " adalah " + Hasil);


    }
    

}
