package soal2;

public class HewanPeliharaan {
    private String nama;
    private String ras;

    public HewanPeliharaan(String r, String n) {
        this.ras = r;
        this.nama = n;
    }
    public void display() {
        System.out.println("");
        System.out.println("Detail Hewan Peliharaan: ");
        System.err.println("Nama hewan peliharaanku adalah : " + nama);
        System.out.println("Dengan ras : " + ras);
     }
}
