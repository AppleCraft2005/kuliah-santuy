package praktikum6.soal1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Table extends Application {

    @Override
    public void start(Stage stage) {
        TableView<Mahasiswa> tableView = new TableView<>();
        
        TableColumn<Mahasiswa, String> Nim = new TableColumn<>("NIM");
        Nim.setCellValueFactory(new PropertyValueFactory<>("nim"));
        tableView.getColumns().add(Nim);

        TableColumn<Mahasiswa, String> Nama = new TableColumn<>("Nama");
        Nama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        tableView.getColumns().add(Nama);

        tableView.getItems().add(new Mahasiswa(0, "Kaguya Shinomiya", "231081710002"));
        tableView.getItems().add(new Mahasiswa(1, "Miyuki Shirogane", "231081710003"));
        tableView.getItems().add(new Mahasiswa(2, "Chika Fujiwara ", "231081710004"));
        tableView.getItems().add(new Mahasiswa(3, "Yū Ishigami e", "231081710005"));
        tableView.getItems().add(new Mahasiswa(4, "Miko Iino", "231081710006"));
        tableView.getItems().add(new Mahasiswa(5, "Ai Hayasaka", "231081710007"));
        tableView.getItems().add(new Mahasiswa(6, "Nagisa Kashiwagi", "231081710008"));
        tableView.getItems().add(new Mahasiswa(7, "Kei Shirogane", "231081710009"));
        tableView.getItems().add(new Mahasiswa(8, "Kobachi Osaragi", "231081710010"));
        tableView.getItems().add(new Mahasiswa(9, "Tsubame Koyasu", "231081710012"));

        Scene scene1 = new Scene(tableView, 220, 300);
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}