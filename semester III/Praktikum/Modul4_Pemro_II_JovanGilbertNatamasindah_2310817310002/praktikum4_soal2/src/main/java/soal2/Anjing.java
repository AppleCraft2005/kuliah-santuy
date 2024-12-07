package soal2;

public class Anjing extends HewanPeliharaan {
    private String warnaBulu;
    private String[] Kemampuan;

    public Anjing(String n, String r, String w, String[] Kemampuan) {
        super(n, r);
        this.warnaBulu = w;
        this.Kemampuan = Kemampuan;
    }

    public void displayDetailAnjing() {
        super.display();
        System.out.println("Memiliki warna bulu : " + warnaBulu);
        System.out.print("Memiliki Kemampuan :");
        for(int i = 0 ; i < Kemampuan.length ; i++) {
            System.out.print(" " + Kemampuan[i]);
        }
    }
}
