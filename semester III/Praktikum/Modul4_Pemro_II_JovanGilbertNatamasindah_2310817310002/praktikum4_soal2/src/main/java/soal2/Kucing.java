package soal2;

class Kucing extends HewanPeliharaan {
    private String warnaBulu;

    Kucing(String r, String n, String w) {
        super(r, n);
        this.warnaBulu = w;
    }

    void displayDetailKucing() {
        super.display();
        System.out.println("Memiliki warna bulu: " + warnaBulu);
    }
}
