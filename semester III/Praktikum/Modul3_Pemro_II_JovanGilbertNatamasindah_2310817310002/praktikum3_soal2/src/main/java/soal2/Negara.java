package soal2;

class Negara {
    String nama;
    String jenis_kepemimpinan;
    String nama_pemimpin;
    String tanggal_kemerdekaan;
    String bulan_kemerdekaan;
    String tahun_kemerdekaan;

    Negara(String Nama, String Jenis_kepemimpinan, String Nama_pemimpin, String Tanggal_kemerdekaan, String Bulan_kemerdekaan, String Tahun_kemerdekaan) {
        this.nama = Nama;
        this.jenis_kepemimpinan = Jenis_kepemimpinan;
        this.nama_pemimpin = Nama_pemimpin;
        this.tanggal_kemerdekaan = Tanggal_kemerdekaan;
        this.bulan_kemerdekaan = Bulan_kemerdekaan;
        this.tahun_kemerdekaan = Tahun_kemerdekaan;
    }

    void showDetail() {
        if(jenis_kepemimpinan.equals("monarki")) {
            System.out.println("Negara " + nama + " mempunyai Raja bernama " + nama_pemimpin );
            System.out.println("");
        }
        else {
            System.out.println("Negara " + nama + " mempunyai " + jenis_kepemimpinan + " bernama " + nama_pemimpin);
            System.out.println("Deklarasi Kemerdekaan pada Tanggal " + tanggal_kemerdekaan + " " + bulan_kemerdekaan + " " + tahun_kemerdekaan);
            System.out.println("");
        }
    }
}