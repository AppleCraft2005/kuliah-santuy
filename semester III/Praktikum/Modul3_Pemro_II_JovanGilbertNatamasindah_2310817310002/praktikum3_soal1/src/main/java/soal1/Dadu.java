package soal1;

class Dadu {
    int Nilai;

    Dadu() {
        acakNilai();
    }

    int acakNilai() {
        return Nilai = (int)(Math.random() * 6) + 1;
    }

}
