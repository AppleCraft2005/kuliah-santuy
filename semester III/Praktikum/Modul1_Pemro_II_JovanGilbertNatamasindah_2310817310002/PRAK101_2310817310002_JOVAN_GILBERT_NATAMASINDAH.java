import java.util.Scanner;

public class PRAK101_2310817310002_JOVAN_GILBERT_NATAMASINDAH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Lengkap: ");
        String Nama = scanner.nextLine();

        System.out.print("Masukkan Tempat Lahir: ");
        String TempatLahir = scanner.nextLine();

        System.out.print("Masukkan Tanggal Lahir: ");
        String TanggalLahir = scanner.nextLine();

        System.out.print("Masukkan Bulan Lahir: ");
        String BulanLahir = scanner.nextLine();

        System.out.print("Masukkan Tahun Lahir: ");
        String TahunLahir = scanner.nextLine();

        System.out.print("Masukkan Tinggi Badan: ");
        String TinggiBadan = scanner.nextLine();

        System.out.print("Masukkan Berat Badan: ");
        String BeratBadan = scanner.nextLine();

        scanner.close();

        switch (BulanLahir) {
            case "1":
                BulanLahir = "Januari";
                break;
            case "2":
                BulanLahir = "Februari";
                break;
            case "3":
                BulanLahir = "Maret";
                break;
            case "4":
                BulanLahir = "April";
                break;
            case "5":
                BulanLahir = "Mei";
                break;
            case "6":
                BulanLahir = "Juni";
                break;
            case "7":
                BulanLahir = "Juli";
                break;
            case "8":
                BulanLahir = "Agustus";
                break;
            case "9":
                BulanLahir = "September";
                break;
            case "10":
                BulanLahir = "Oktober";
                break;
            case "11":
                BulanLahir = "November";
                break;
            case "12":
                BulanLahir = "Desember";
                break;

        }

        System.out.println("Nama Lengkap " + Nama + ", Lahir di " + TempatLahir + " pada Tanggal " + TanggalLahir + " " + BulanLahir + " " + TahunLahir  + " Tinggi Badan " + TinggiBadan + " cm" + " dan Berat Badan " + BeratBadan + " kilogram");

        scanner.close();
        
    }
}
