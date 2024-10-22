package praktikum2.soal1;

public class PRAK201_2310817310014_MuhammadRizkiSaputra {

    static class Buah {
        String nama;
        double harga;
        double berat;
        double jumlahBeli;

        double hargaSebelumDiskon() {
            return jumlahBeli / berat * harga;
        }

        double totalDiskon() {
            return (jumlahBeli / 4) * (harga * 4 * 0.02);
        }

        double hargaSetelahDiskon() {
            return hargaSebelumDiskon() - totalDiskon();
        
        
        }
        String infoBuah() {
            return "Nama Buah: " + nama + "\nBerat: " + berat + "\nHarga: Rp" + harga + "\nJumlah Beli: " + jumlahBeli + "kg" + "\nHarga Sebelum Diskon: Rp" + hargaSebelumDiskon() + "\nTotal Diskon: Rp" + totalDiskon() + "\nHarga Setelah Diskon: Rp" + hargaSetelahDiskon();
    }
    public static void main(String[] args) {
        Buah apel = new Buah();
        apel.nama = "Apel";
        apel.harga = 7000.0;
        apel.berat = 0.4;
        apel.jumlahBeli = 14.0;

        Buah mangga = new Buah();
        mangga.nama = "Mangga";
        mangga.harga = 3500.0;
        mangga.berat = 0.2;
        mangga.jumlahBeli = 15.0;

        Buah alpukat = new Buah();
        alpukat.nama = "Alpukat";
        alpukat.harga = 10000.0;
        alpukat.berat = 0.25;
        alpukat.jumlahBeli = 12.0;

        System.out.println(apel.infoBuah());

        System.out.println(mangga.infoBuah());
        
        System.out.println(alpukat.infoBuah());
        }
    }
}
