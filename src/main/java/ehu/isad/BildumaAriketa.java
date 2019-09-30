package ehu.isad;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ListView;


import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class BildumaAriketa extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("Bilduma Ariketa");

        ComboBox comboBox = new ComboBox();

        comboBox.getItems().add("Bilduma 1");
        comboBox.getItems().add("Bilduma 2");
        comboBox.getItems().add("Bilduma 3");

        comboBox.setEditable(false);

       /* comboBox.getItems().addAll(List.of(
                new Argazki("Bilduma1","elefantea.jpg")
                ));*/

      /*

        ObservableList<Bilduma> bildumaList = FXCollections.observableArrayList();
        bildumak.forEach(elem) -> {
            bildumaList.add(new Bilduma(elem));


        ObservableList<Argazki> argazkiList = FXCollections.observableArrayList();
        argazkiList.addAll(bildumaMap.get("abereak"));

            comboBox.setItems(bildumaList);
       comboBox.getSelectionModel().selectFirst();  //defektuz lehena agartzeko
        }*/

        ListView listView = new ListView();

        comboBox.setOnAction(e -> {
            listView.getItems().clear();
            if (comboBox.getValue().equals("Bilduma 1")){
                listView.getItems().add("argazki 11");
                listView.getItems().add("argazki 12");
                listView.getItems().add("argazki 13");
            }
            else if (comboBox.getValue().equals("Bilduma 2")){
                listView.getItems().add("argazki 21");
                listView.getItems().add("argazki 22");
                listView.getItems().add("argazki 23");
            }
            else if (comboBox.getValue().equals("Bilduma 3")){
                listView.getItems().add("argazki 31");
                listView.getItems().add("argazki 32");
                listView.getItems().add("argazki 33");
            }
        });



        listView.setOnMouseClicked(e -> {
            System.out.println(listView.getSelectionModel().getSelectedItem().toString());
        });


        /*FileInputStream input = new FileInputStream("/home/endika/perro.jpg");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);*/



        VBox vbox = new VBox(comboBox,listView);

        Scene scene = new Scene(vbox, 200, 120);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
