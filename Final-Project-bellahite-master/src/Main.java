import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application {

    String[] types = {"grass", "fire", "water", "bug", "normal", "poison", "electric", "ground", "fairy", "fighting", "psychic", "rock", "ghost", "ice", "dragon", "dark", "steel", "flying"};
    ComboBox<String> drop1 = new ComboBox<>();

    ComboBox<String> drop2 = new ComboBox<>();
    ComboBox<String> drop3 = new ComboBox<>();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {

        VBox vbox = new VBox();
        vbox.getChildren().addAll(getHeader(),getQ1(),separator(),getQ2(),separator(),getQ3());


        Scene scene = new Scene(vbox, 580, 468);


        primaryStage.setTitle("Welcome to the Alola Region");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public HBox getQ1() throws IOException {
        HBox hBox = new HBox();
        ArrayList<Pokemon> pokemons = Pokemon.readDataFile("data/alolan_pokemon.csv");

        Label label = new Label("\t\t\t    Find out who the\t\n\t\t\tstrongest Pokémon is\t\n\t\t\t of the selected type!\t");

        ObservableList<String> items = FXCollections.observableArrayList(types);
        drop1.getItems().addAll(items);
        drop1.setVisibleRowCount(18);

        GridPane gridPane = new GridPane();
        gridPane.setPrefWidth(200);

        gridPane.add(new Label("   is the strongest\n\t\ttype!"), 10, 1);

        Label name1 = new Label("   Pokémon");
        Label type1 = new Label("\n     Type");

        gridPane.add(name1, 10, 0);
        gridPane.add(type1, 10, 1);

        hBox.getChildren().addAll(label, drop1, gridPane);

        drop1.setOnAction(e -> {
            String output = (String) drop1.getValue();
            String strongest = Pokemon.getStrongestPokemon(pokemons,output);
            String[] strong = strongest.split(" ");
            name1.setText("\t" + strong[0]);
            type1.setText("\n    "+ strong[1]);
        });
        return hBox;
    }

    public HBox getHeader() {
        HBox hBox = new HBox();
        Pane paneForText = new Pane();
        Text text = new Text(10,47, "\uD83C\uDF34Welcome to the Alola Region \uD83C\uDF34");
        Font font1 = Font.font("Comic Sans MS", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 35);
        text.setFont(font1);
        text.setFill(Color.DARKSEAGREEN);
        paneForText.getChildren().add(text);
        hBox.getChildren().add(paneForText);
        return hBox;
    }

    public HBox separator(){
        HBox h = new HBox();

        Pane paneForText = new Pane();
        Text text1 = new Text(10, 30,"----------------------------------------");
        Font font1 = Font.font("Comic Sans MS", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 35);
        text1.setFont(font1);
        text1.setFill(Color.DARKSEAGREEN);
        paneForText.getChildren().add(text1);
        h.getChildren().add(paneForText);

        return h;
    }


    public HBox getQ3() throws IOException {
        HBox hbox = new HBox();
        ArrayList<Pokemon> pokemons = Pokemon.readDataFile("data/alolan_pokemon.csv");

        Pane paneForText = new Pane();
        Text text = new Text(10,47, "Choose two types of\nPokémon to all battle\neachother. See who's\nthe winner!");

        paneForText.getChildren().add(text);
        //hbox.getChildren().add(paneForText);

        Label label = new Label("Type 1:");
        Label labe = new Label("Type 2:");

        ObservableList<String> items = FXCollections.observableArrayList(types);
        drop2.getItems().addAll(items);
        drop2.setVisibleRowCount(6);
        drop3.getItems().addAll(items);
        drop3.setVisibleRowCount(6);

        //drop2.setLayoutX(500);

        GridPane gridPane = new GridPane();
        gridPane.setPrefWidth(140);

        gridPane.add(new Label("Type1 Wins: "), 100, 0);
        gridPane.add(new Label("Type1 Losses: "), 100, 1);
        gridPane.add(new Label("Type1 Ties: "), 100, 2);

        gridPane.add(new Label("Type2 Wins: "), 100, 4);
        gridPane.add(new Label("Type2 Losses: "), 100, 5);
        gridPane.add(new Label("Type2 Ties: "), 100, 6);

        Label wins1 = new Label("   ");
        Label losses1 = new Label("   ");
        Label ties1 = new Label("   ");

        Label wins2 = new Label("   ");
        Label losses2 = new Label("   ");
        Label ties2 = new Label("   ");

        gridPane.add(wins1, 102, 0);
        gridPane.add(losses1, 102, 1);
        gridPane.add(ties1, 102, 2);

        gridPane.add(wins2, 102, 4);
        gridPane.add(losses2, 102, 5);
        gridPane.add(ties2, 102, 6);

        hbox.getChildren().add(paneForText);
        hbox.getChildren().addAll(label, drop2, labe, drop3, gridPane);



        drop2.setOnAction(e -> {
            String u1 = (String) drop2.getValue();
            String u2 = (String) drop3.getValue();

            String stats = Pokemon.pokemonBattle(pokemons, u1, u2);
            String[] s = stats.split(" ");

        });
        drop3.setOnAction(e -> {
            String u1 = (String) drop2.getValue();
            String u2 = (String) drop3.getValue();

            String stats = Pokemon.pokemonBattle(pokemons, u1, u2);
            String[] s = stats.split(" ");

            wins1.setText(s[0]);
            losses1.setText(s[1]);
            ties1.setText(s[2]);

            wins2.setText(s[3]);
            losses2.setText(s[4]);
            ties2.setText(s[5]);
        });
        return hbox;
    }

    public BorderPane getQ2() throws IOException {
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setLeft(new Label("Enter a height to find\nout how many\nPokémon are taller,\nshorter, or the same :)"));
        ArrayList<Pokemon> pokemons = Pokemon.readDataFile("data/alolan_pokemon.csv");
        HBox hb = new HBox();

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        tf.setPrefWidth(400);

        //paneForTextField.setCenter(tf);
        hb.getChildren().add(tf);



        GridPane gridPane = new GridPane();
        gridPane.setPrefWidth(600);

        Label tall = new Label("\t\t\t\t\t\t____ are taller");
        Label shrt = new Label("\t\t\t\t\t\t\t\t\t\t____ are shorter");
        Label same = new Label("\t\t\t\t\t\t\t\t\t\t\t\t\t\t____ are equal");

        gridPane.add(tall, 500, 11);
        gridPane.add(shrt, 500, 12);
        gridPane.add(same, 500, 13);


        tf.setOnAction(e -> {

            String str = tf.getText();
            int a = Integer.parseInt(str);
            String heights = Pokemon.whatHeights(pokemons, a);
            String[] hite = heights.split(" ");
            tall.setText("\t\t\t\t\t\t" + hite[0]+" are taller");
            shrt.setText("\t\t\t\t\t\t\t\t\t\t" + hite[1]+" are shorter");
            same.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + hite[2]+" are equal");
        });
        paneForTextField.setCenter(hb);
        paneForTextField.setBottom(gridPane);
        return paneForTextField;
    }
}