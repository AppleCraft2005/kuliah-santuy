module praktikum6.soal1 {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens praktikum6.soal1 to javafx.fxml;
    exports praktikum6.soal1;
}
