/*
Author: Nicole Hackler
Date: 11/15/2020

(Baby name popularity ranking) Write a program that enables the user to select a year, gender,
and enter a name to display the ranking of the name for the selected year and gender. Assume
the data files are stored at http://liveexample.pearsoncmg.com/data/babynamesranking2001.txtLinks
to an external site.,Links to an external site. . . . ,
and http://liveexample.pearsoncmg.com/data/babynamesranking2010.txtLinks to an external site. .
To achieve the best efficiency, create two arrays for boy’s names and girl’s names, respectively.
Each array has 10 elements for 10 years. Each element is a map that stores a name, and it's ranking
in a pair with the name as the key.
 */
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
    private Map<String, Integer>[] mapForBoy = new HashMap[10];
    private Map<String, Integer>[] mapForGirl = new HashMap[10];

    private Button btFindRanking = new Button("Find Ranking");
    private ComboBox<Integer> cboYear = new ComboBox<>();
    private ComboBox<String> cboGender = new ComboBox<>();
    private TextField tfName = new TextField();
    private Label lblResult = new Label();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        try
        {
            for (int i = 1; i < 10; i++) {
                URL url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking200" + i + ".txt");
                Scanner input = new Scanner(url.openStream());
                mapForBoy[i - 1] = new HashMap<>();
                mapForGirl[i - 1] = new HashMap<>();
                while (input.hasNext()){ //Read each line to end
                    int rank = Integer.parseInt(input.next());

                    String boy = input.next();
                    input.next(); //Skipping votes

                    String girl = input.next();
                    input.next(); //Skipping votes

                    mapForBoy[i - 1].put(boy, rank); //Placing rank and boys name in the map
                    mapForGirl[i - 1].put(girl, rank); //Placing rank and girls name in the map
                }
            }
        }
        catch(Exception ex) {
        }

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Select a year:"), 0, 0);
        gridPane.add(new Label("Boy or girl?"), 0, 1);
        gridPane.add(new Label("Enter a name:"), 0, 2);
        gridPane.add(cboYear, 1, 0);
        gridPane.add(cboGender, 1, 1);
        gridPane.add(tfName, 1, 2);
        gridPane.add(btFindRanking, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(lblResult);
        BorderPane.setAlignment(lblResult, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 370, 160);
        primaryStage.setTitle("Exercise21_11"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        for (int year = 2001; year <= 2010; year++) {
            cboYear.getItems().add(year);
        }
        cboYear.setValue(2001);

        cboGender.getItems().addAll("Male", "Female");
        cboGender.setValue("Male");

        btFindRanking.setOnAction(e->{ //Rank button handler
            int catRank = 0;
            int catYear = 0;
            //Rank button if male is selected
            if(cboGender.getSelectionModel().getSelectedItem().equals("Male")){//Rank button if male is selected
                catRank = mapForBoy[cboYear.getSelectionModel().getSelectedItem() - 2001].get(tfName.getText());
                catYear = cboYear.getValue();
                lblResult.setText("Boy name " + tfName.getText() + " is ranked #" + catRank + " in year " + catYear);
            }
            else{ //Rank button if female is selected
                catRank = mapForGirl[cboYear.getSelectionModel().getSelectedItem() - 2001].get(tfName.getText());
                catYear = cboYear.getValue();
                lblResult.setText("Girl name " + tfName.getText() + " is ranked #" + catRank + " in year " +  catYear);
            }
        });
    }
    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

