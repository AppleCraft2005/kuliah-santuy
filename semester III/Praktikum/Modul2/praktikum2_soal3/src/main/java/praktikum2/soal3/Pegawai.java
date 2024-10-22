package praktikum2.soal3;

// nama class tidak sama dengan nama file
// public class Employee
public class Pegawai {
    public String nama;
    // atribut harusnya bertipe String bukan char, karena outputnya berupa string
    // public char asal;
    public String asal;
    public String jabatan;
    public int umur;

    public String getNama() {
        return nama;
    }
    public String getAsal() {
        return asal;
    }
    // tidak terdapat argumen
    // public void setJabatan()
    public void setJabatan(String j) {
        this.jabatan = j;
    }
}
