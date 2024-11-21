package com.inheritance;

class Mhs {
    String ProgramStudi = "Teknologi Informasi";
    String Fakultas = "Teknik";
    String Universitas = "Lambung Mangkurat";
}

class MhsDetail extends Mhs {
    String Nama = "Jovan Gilbert Natamasindah";
    String NIM = "2310817310002";
    String Semester = "3";

    void ShowDetail() {
        System.out.printf("Nama             : %s\n", Nama);
        System.out.printf("NIM              : %s\n", NIM);
        System.out.printf("Semester         : %s\n", Semester);
        System.out.printf("Program Studi    : %s\n", ProgramStudi);
        System.out.printf("Fakultas         : %s\n", Fakultas);
        System.out.printf("Universitas      : %s\n", Universitas);

    };
}

public class Main {
    public static void main(String[] args) {
        MhsDetail Mahasiswa1 = new MhsDetail();
        Mahasiswa1.ShowDetail();
    }
}