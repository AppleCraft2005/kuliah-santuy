package com.visibilitymodifier;

class MhsDetail extends Mhs {
    public String Nama = "Jovan Gilbert Natamasindah";
    private String NIM = "2310817310002";
    private String Semester = "3";

    public String getNIM() {
        return NIM;
    }

    public String getSemester() {
        return Semester;
    }

    void ShowDetail() {
        System.out.printf("Nama             : %s\n", Nama);
        System.out.printf("NIM              : %s\n", getNIM());
        System.out.printf("Semester         : %s\n", getSemester());
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