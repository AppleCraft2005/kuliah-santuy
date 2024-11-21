package soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);

        int jumlahDadu = Inputan.nextInt();

        LinkedList<Dadu> listDadu = new LinkedList<>();

        for(int i = 0 ; i < jumlahDadu ; i++) {
            Dadu dice = new Dadu();
            listDadu.add(dice);
        }

        int totalAngkaDadu = 0;

        for(int j = 0 ; j < listDadu.size() ; j++) {
            System.out.println("Dadu ke-" + (j+1) + " bernilai " + listDadu.get(j).Nilai);
            totalAngkaDadu += listDadu.get(j).Nilai;
        }

        System.out.println("Total nilai dadu keseluruhan " + totalAngkaDadu);

        Inputan.close();
    }
}