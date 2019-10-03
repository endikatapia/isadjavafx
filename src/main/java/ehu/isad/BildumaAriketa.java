package ehu.isad;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ListView;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BildumaAriketa extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("Bilduma Ariketa");

        ComboBox comboBilduma = new ComboBox();


        ImageView imageView = new ImageView();

        List<String> bildumak=List.of("abereak", "landareak","frutak");

        ObservableList<Bilduma> bildumaList = FXCollections.observableArrayList();

        bildumak.forEach((elem) ->{
            bildumaList.addAll(new Bilduma(elem));
        });

        comboBilduma.setItems(bildumaList);
        comboBilduma.getSelectionModel().selectFirst();  //defektuz lehena agartzeko
        //comboBilduma.setEditable(false);

        Map<String,List<Argazki>> bildumaMap = new HashMap<>();
        
        bildumaMap.put("abereak",List.of(
           new Argazki("Elefantea","elefantea.jpg"),
           new Argazki("Txakurra","txakurra.jpg"),
           new Argazki("Untxia","untxia.jpg")
        ));

        bildumaMap.put("landareak",List.of(
                new Argazki("Kaktusa","kaktusa.jpg"),
                new Argazki("Girasola","girasola.jpg"),
                new Argazki("Pinoa","pinoa.jpg")
        ));

        bildumaMap.put("frutak",List.of(
                new Argazki("Fresa","fresa.jpg"),
                new Argazki("Sagarra","sagarra.jpg"),
                new Argazki("Madaria","madaria.jpg")
        ));
        
        ObservableList<Argazki> argazkiList = FXCollections.observableArrayList();
        argazkiList.addAll(bildumaMap.get("abereak"));
        /*argazkiList.addAll(bildumaMap.get("landareak"));
        argazkiList.addAll(bildumaMap.get("frutak"));*/

        ListView<Argazki> listViewOfArgazki = new ListView<>(argazkiList);

        comboBilduma.setOnAction(e->{
            listViewOfArgazki.getItems().clear();
            argazkiList.addAll(bildumaMap.get(comboBilduma.getValue().toString()));
        });

        listViewOfArgazki.getSelectionModel().selectedItemProperty().addListener(  (observable, oldValue, newValue) -> {
            if (observable.getValue() == null) return;

            String fitx = observable.getValue().getFitx();

            try {
                imageView.setImage(lortuIrudia(fitx /* 48x48 */));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });



        

       /* comboBox.getItems().add("Bilduma 1");
        comboBox.getItems().add("Bilduma 2");
        comboBox.getItems().add("Bilduma 3");
                                    */


       /* comboBox.getItems().addAll(List.of(
                new Argazki("Bilduma1","elefantea.jpg")
                ));*/



       /* ListView listView = new ListView();

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
        });*/


        /*FileInputStream input = new FileInputStream("/home/endika/perro.jpg");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);*/



        VBox vbox = new VBox(comboBilduma,listViewOfArgazki,imageView);

        Scene scene = new Scene(vbox, 220, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Image lortuIrudia(String location) throws IOException {

        InputStream is = getClass().getResourceAsStream("/" + location);
        BufferedImage reader = ImageIO.read(is);
        return SwingFXUtils.toFXImage(reader, null);

    }
}
