package soal3;

class Mahasiswa {
    private String nama;
    private String nim;
    
    Mahasiswa(String Nama, String NIM) {
        this.nama = Nama;
        this.nim = NIM;
    }

    String getNama() {
        return nama;
    }

    String getNim() {
        return nim;
    }
}
