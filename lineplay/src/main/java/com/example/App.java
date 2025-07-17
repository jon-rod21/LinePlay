package com.example;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private File selectedFile;
    private String textInput;
    static boolean hasFile;
    static boolean hasText;
    static boolean success = false;
    private String option;
    private String result;

    @Override
    public void start(Stage stage) throws IOException {


        /*================================= */
        // Initialize Scenes and GridPanes
        /*================================= */

        GridPane main_gp = new GridPane();
        Scene main_scene = new Scene(main_gp, 600, 400);
        main_scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        main_gp.setStyle("-fx-background-color: #A3D5FF;");
        main_gp.setPadding(new Insets(10));
        main_gp.setVgap(5);
        main_gp.setHgap(5);
        
        GridPane file_gp = new GridPane();
        Scene file_scene = new Scene(file_gp, 600, 400);
        file_scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        file_gp.setStyle("-fx-background-color: #A3D5FF;");
        file_gp.setPadding(new Insets(10));
        file_gp.setVgap(5);
        file_gp.setHgap(5);
        
        
        GridPane text_gp = new GridPane();
        Scene text_scene = new Scene(text_gp, 600, 400);
        text_scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        text_gp.setStyle("-fx-background-color: #A3D5FF;");
        text_gp.setPadding(new Insets(10));
        text_gp.setVgap(5);
        text_gp.setHgap(5);

        GridPane selection_gp = new GridPane();
        Scene selection_scene = new Scene(selection_gp, 600, 400);
        selection_scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        selection_gp.setStyle("-fx-background-color: #A3D5FF;");
        selection_gp.setPadding(new Insets(10));
        selection_gp.setVgap(5);
        selection_gp.setHgap(5);

        GridPane end_gp = new GridPane();
        Scene end_scene = new Scene(end_gp, 600, 400);
        end_scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        end_gp.setStyle("-fx-background-color: #A3D5FF;");
        end_gp.setPadding(new Insets(10));
        end_gp.setVgap(5);
        end_gp.setHgap(5);

        /*================================= */
        // Main Stage
        /*================================= */

        Text main_appTitle = new Text("LinePlay"); main_appTitle.getStyleClass().add("title");
        Text main_byLine = new Text("By: Jon"); main_byLine.getStyleClass().add("byline");
        Text main_about = new Text("Rearrange code in fun ways!"); main_about.getStyleClass().add("about");
        
        Button main_enterFile = new Button("Choose File");
        Button main_enterText = new Button ("Enter Text");
         
        GridPane.setHalignment(main_appTitle, HPos.CENTER);
        GridPane.setValignment(main_appTitle, VPos.BOTTOM);
        GridPane.setHalignment(main_byLine, HPos.CENTER);
        GridPane.setValignment(main_byLine, VPos.TOP);
        GridPane.setHalignment(main_about, HPos.CENTER);
        GridPane.setValignment(main_about, VPos.TOP);
        GridPane.setHalignment(main_enterFile, HPos.RIGHT);
        GridPane.setHalignment(main_enterText, HPos.LEFT);


        for (int i = 0; i < 3; i++){
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(33.33); 
            cc.setHgrow(Priority.ALWAYS); 
            main_gp.getColumnConstraints().add(cc);
        }
        

        for (int i = 0; i < 4; i++){
            RowConstraints rc = new RowConstraints();
            rc.setPercentHeight(25); 
            rc.setVgrow(Priority.ALWAYS); 
            main_gp.getRowConstraints().add(rc);
        }
        

        main_gp.add(main_appTitle, 1, 0);
        main_gp.add(main_byLine, 1, 1);
        main_gp.add(main_about, 1, 2);
        main_gp.add(main_enterFile, 0, 3);
        main_gp.add(main_enterText, 2, 3);

        /*================================= */
        // File Stage
        /*================================= */
        
        

        for (int i = 0; i < 3; i++){
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(33.33); 
            cc.setHgrow(Priority.ALWAYS); 
            file_gp.getColumnConstraints().add(cc);
        }
        

        for (int i = 0; i < 4; i++){
            RowConstraints rc = new RowConstraints();
            rc.setPercentHeight(25); 
            rc.setVgrow(Priority.ALWAYS); 
            file_gp.getRowConstraints().add(rc);
        }

        main_enterFile.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            // Optionally set initial directory and extension filters
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
            );

            selectedFile = fileChooser.showOpenDialog(stage);
            String fileLocation = "" + selectedFile.getAbsolutePath();
            Text file_message;
            if (selectedFile != null) {
                file_message = new Text(fileLocation);
                
            } else {
                file_message = new Text( "there was nothing there :()");
                
            }
        
            Text file_question = new Text("Is this the right stuff?");
            file_question.getStyleClass().add("title");
            file_message.getStyleClass().add("about");
            
            file_gp.add(file_question, 1, 0); 
            file_gp.add(file_message, 1, 1);

            GridPane.setHalignment(file_question, HPos.CENTER);
            GridPane.setHalignment(file_message, HPos.CENTER);
            
            stage.setScene(file_scene);
        });

        Button file_goNext = new Button("Yes!");
        Button file_goBack = new Button("Nope");
        GridPane.setHalignment(file_goNext, HPos.LEFT);
        GridPane.setHalignment(file_goBack, HPos.RIGHT);
        file_gp.add(file_goNext, 2, 3);
        file_gp.add(file_goBack, 0, 3);


        file_goNext.setOnAction(e -> {
            hasFile = true;
            stage.setScene(selection_scene);
        });

        file_goBack.setOnAction(e -> {
            stage.setScene(main_scene);
        });



        /*================================= */
        // TextBox Stage
        /*================================= */

        text_gp.setStyle("-fx-background-color: #A3D5FF;");
        text_gp.setPadding(new Insets(10));
        text_gp.setVgap(5);
        text_gp.setHgap(5);
        

        main_enterText.setOnAction(e -> {
            stage.setScene(text_scene);
        });

        Text text_message = new Text("Type your code in here!"); text_message.getStyleClass().add("about");
        TextArea text_area = new TextArea();
        Button text_enter = new Button("Enter");

        text_area.getStyleClass().add("text-field");
        text_area.setWrapText(true);
        

        text_gp.add(text_message, 0, 0);
        text_gp.add(text_area, 0, 1);
        text_gp.add(text_enter, 0, 2);

        RowConstraints rc = new RowConstraints();
        rc.setPercentHeight(33.33); 
        rc.setVgrow(Priority.ALWAYS); 
        text_gp.getRowConstraints().add(rc);

        ColumnConstraints cc = new ColumnConstraints();
        cc.setPercentWidth(100); 
        cc.setHgrow(Priority.ALWAYS); 
        text_gp.getColumnConstraints().add(cc);

        
        text_enter.setOnAction(e -> {
            textInput = text_area.getText();
            hasText = true;
            stage.setScene(selection_scene);
        });

        /*================================= */
        // Selection Stage
        /*================================= */
        
        Text selection_message = new Text("Choose your design!"); selection_message.getStyleClass().add("about");
        ComboBox<String> selection_choice = new ComboBox<>();
        Button selection_enter = new Button("Change My Code");

        selection_choice.getItems().addAll("Line", "Diamond", "Diagonal", "ZigZag");

        
        selection_gp.add(selection_message, 0, 0);
        selection_gp.add(selection_choice, 0, 1);
        selection_gp.add(selection_enter, 0, 2);
        // GridPane.setValignment(selection_choice, VPos.TOP);

        RowConstraints rcc = new RowConstraints();
        rcc.setPercentHeight(33.33); 
        rcc.setVgrow(Priority.ALWAYS); 
        selection_gp.getRowConstraints().add(rcc);

        ColumnConstraints ccc = new ColumnConstraints();
        ccc.setPercentWidth(25); 
        ccc.setHgrow(Priority.ALWAYS); 
        selection_gp.getColumnConstraints().add(ccc);

        selection_enter.setOnAction(e ->{
            option = selection_choice.getValue();
            LinePlay linePlay = hasFile ? new LinePlay(selectedFile, option) : new LinePlay(textInput, option);
            stage.setScene(end_scene);
            try {
                result = linePlay.runReport();
                success = true;
            } catch (IOException ex) {
                success = false;
            }

        });

        /*================================= */
        // End Stage
        /*================================= */

        
        // have to test the other group of classes befoer trying it here. am getting nosuchelementexception error on lineplay line 77, aka error reading file

        
        
        stage.setTitle("Sample Aplication");
        stage.setScene(main_scene);
        stage.show();
    }

    

    public static void main(String[] args) {
        launch();
    }

}