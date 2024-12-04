package soal2;

class HewanPeliharaan {
    String nama;
    String ras;

    HewanPeliharaan(String r, String n) {
        this.ras = r;
        this.nama = n;
    }
    void display() {
        System.out.println("");
        System.out.println("Detail Hewan Peliharaan: ");
        System.err.println("Nama hewan peliharaanku adalah : " + nama);
        System.out.println("Dengan ras : " + ras);
     }
}
