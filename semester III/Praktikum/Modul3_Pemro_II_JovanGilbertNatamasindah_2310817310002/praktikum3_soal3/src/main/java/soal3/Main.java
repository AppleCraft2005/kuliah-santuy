package soal3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);
        ArrayList<Mahasiswa> listMhs = new ArrayList<>();
        int Pilihan;

        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
    
            System.out.print("Pilihan: ");
            Pilihan = Inputan.nextInt();
    
            Inputan.nextLine();

            if(Pilihan == 1) {
                System.out.print("Masukkan Nama Mahasiswa: ");
                String Nama = Inputan.nextLine();
                System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                String NIM = Inputan.nextLine();
    
                Mahasiswa mhs = new Mahasiswa(Nama, NIM);
                listMhs.add(mhs);
    
                System.out.println("Mahasiswa " + Nama + " ditambahkan");
                
            }
            else if(Pilihan == 2) {
                System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                String nimTemp = Inputan.nextLine();
                for(int j = 0 ; j < listMhs.size() ; j++) {
                    if(nimTemp.equals(listMhs.get(j).getNim())) {
                        listMhs.remove(j);
                    }
                }
                System.out.println("Mahasiswa dengan NIM " + nimTemp + " dihapus");
            }
            else if(Pilihan == 3) {
                System.out.print("Masukkan NIM dari Mahasiswa yang ingin dicari: ");
                String nimSearch = Inputan.nextLine();

                for(int j = 0 ; j < listMhs.size() ; j++) {
                    if(nimSearch.equals(listMhs.get(j).getNim())) {
                        System.out.println("NIM: " + listMhs.get(j).getNim() + ", Nama: " + listMhs.get(j).getNama());
                    }
                }
            }
            else if(Pilihan == 4) {
                System.out.println("Daftar Mahasiswa:");
                for(int j = 0 ; j < listMhs.size() ; j++) {
                    System.out.println("NIM: " + listMhs.get(j).getNim() + ", Nama: " + listMhs.get(j).getNama());
                }
            }
            else {
                System.out.println("Terima kasih!");
            }
        }
        while(Pilihan != 0);

        Inputan.close();
    }
}