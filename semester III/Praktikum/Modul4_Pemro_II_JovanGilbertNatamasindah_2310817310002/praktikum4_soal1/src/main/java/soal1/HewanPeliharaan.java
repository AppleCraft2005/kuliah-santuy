package soal1;

class HewanPeliharaan {
    private String nama;
    private String ras;

    HewanPeliharaan(String r, String n) {
        this.ras = r;
        this.nama = n;
    }

    void display() {
        System.out.println("");
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : " + nama);
        System.out.println("Dengan ras : " + ras);
    }
}
