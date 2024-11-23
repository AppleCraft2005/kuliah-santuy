package soal2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class Negara {
    String nama;
    String jenis_kepemimpinan;
    String nama_pemimpin;
    String tanggal_kemerdekaan;
    String bulan_kemerdekaan;
    String tahun_kemerdekaan;

    Negara(String Nama, String Jenis_kepemimpinan, String Nama_pemimpin, String Tanggal_kemerdekaan, String Bulan_kemerdekaan, String Tahun_kemerdekaan) {
        this.nama = Nama;
        this.jenis_kepemimpinan = Jenis_kepemimpinan;
        this.nama_pemimpin = Nama_pemimpin;
        this.tanggal_kemerdekaan = Tanggal_kemerdekaan;
        this.bulan_kemerdekaan = Bulan_kemerdekaan;
        this.tahun_kemerdekaan = Tahun_kemerdekaan;
    }

    void showDetail() {
        if(jenis_kepemimpinan.equals("monarki")) {
            System.out.println("Negara " + nama + " mempunyai Raja bernama " + nama_pemimpin );
        }
        else {
            System.out.println("Negara " + nama + " mempunyai " + jenis_kepemimpinan + " bernama " + nama_pemimpin + " Deklarasi Kemerdekaan pada Tanggal " + tanggal_kemerdekaan + " " + bulan_kemerdekaan + " " + tahun_kemerdekaan);

        }
    }

}

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
        System.out.print("Masukkan jumlah negara: ");
        int jumlahNegara = Inputan.nextInt();

        Inputan.nextLine();

        LinkedList<Negara> listNegara = new LinkedList<>();
        for(int i = 0 ; i < jumlahNegara ; i++) {
            String Nama = Inputan.nextLine();
            String jenisKepemimpinan = Inputan.nextLine().toLowerCase();
            String namaPemimpin = Inputan.nextLine();
            if(jenisKepemimpinan.equals("monarki")) {
                Negara Country = new Negara(Nama, jenisKepemimpinan, namaPemimpin, " ", " ", " ");
                listNegara.add(Country);
            }
            else {
                String tanggalKemerdekaan = Inputan.nextLine();
                String bulanKemerdekaan = Inputan.nextLine();
                String tahunKemerdekaan = Inputan.nextLine();

                Negara Country = new Negara(Nama, jenisKepemimpinan, namaPemimpin, tanggalKemerdekaan, namaBulan.get(bulanKemerdekaan), tahunKemerdekaan);
                listNegara.add(Country);
            }
        }

        for(int j = 0 ; j < listNegara.size() ; j++) {
            Negara country = listNegara.get(j);
            country.showDetail();
        }
    }
}