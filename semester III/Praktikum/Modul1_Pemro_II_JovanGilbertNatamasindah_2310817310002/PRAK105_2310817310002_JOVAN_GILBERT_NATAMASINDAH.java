import java.text.DecimalFormat;
import java.util.Scanner;

public class PRAK105_2310817310002_JOVAN_GILBERT_NATAMASINDAH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jari-jari: ");
        float Jari_jari = scanner.nextFloat();
        System.out.print("Masukkan tinggi: ");
        float Tinggi = scanner.nextFloat();

        DecimalFormat df = new DecimalFormat("#.###");

        double volumeTabung = 3.14 * Jari_jari * Jari_jari * Tinggi;

        System.out.print("Volume tabung dengan jari-jari " + Jari_jari + " cm dan tinggi " + Tinggi + " cm adalah " + df.format(volumeTabung) + " m3");

        scanner.close();

    }
}
