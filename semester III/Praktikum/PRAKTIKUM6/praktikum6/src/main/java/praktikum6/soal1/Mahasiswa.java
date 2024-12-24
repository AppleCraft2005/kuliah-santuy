package praktikum6.soal1;

public class Mahasiswa {
    private int id;
    private String nama;
    private String nim;

    public Mahasiswa(int id, String nama, String nim) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }
}