package soal2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {   
        HashMap<String, String> namaBulan = new HashMap<>();
        namaBulan.put("1", "Januari");
        namaBulan.put("2", "Februari");
        namaBulan.put("3", "Maret");
        namaBulan.put("4", "April");
        namaBulan.put("5", "Mei");
        namaBulan.put("6", "Juni");
        namaBulan.put("7", "Juli");
        namaBulan.put("8", "Agustus");
        namaBulan.put("9", "September");
        namaBulan.put("10", "Oktober");
        namaBulan.put("11", "November");
        namaBulan.put("12", "Desember");

        Scanner Inputan = new Scanner(System.in);
        int jumlahNegara = Inputan.nextInt();

        Inputan.nextLine();

        LinkedList<Negara> listNegara = new LinkedList<>();
        for(int i = 0 ; i < jumlahNegara ; i++) {
            String Nama = Inputan.nextLine();
            String jenisKepemimpinan = Inputan.nextLine().toLowerCase();
            String jenisKepemimpinanNew = jenisKepemimpinan.substring(0,1).toUpperCase() + jenisKepemimpinan.substring(1);
            String namaPemimpin = Inputan.nextLine();
            if(jenisKepemimpinan.equals("monarki")) {
                Negara Country = new Negara(Nama, jenisKepemimpinan, namaPemimpin, " ", " ", " ");
                listNegara.add(Country);
            }
            else {
                String tanggalKemerdekaan = Inputan.nextLine();
                String bulanKemerdekaan = Inputan.nextLine();
                String tahunKemerdekaan = Inputan.nextLine();

                Negara Country = new Negara(Nama, jenisKepemimpinanNew, namaPemimpin, tanggalKemerdekaan, namaBulan.get(bulanKemerdekaan), tahunKemerdekaan);
                listNegara.add(Country);
            }
        }

        for(int j = 0 ; j < listNegara.size() ; j++) {
            Negara country = listNegara.get(j);
            country.showDetail();
        }

        Inputan.close();
    }
}