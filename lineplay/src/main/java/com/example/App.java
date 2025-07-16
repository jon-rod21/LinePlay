package com.example;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    @Override
    public void start(Stage stage) throws IOException {
        

        // main Stage
        Text main_appTitle = new Text("LinePlay"); main_appTitle.getStyleClass().add("title");
        Text main_byLine = new Text("By: Jon"); main_byLine.getStyleClass().add("byline");

        Text main_about = new Text("Rearrange code in fun ways!"); main_about.getStyleClass().add("about");
        
        Button main_enterFile = new Button("Choose File");
        Button main_enterText = new Button ("Enter Text");
         
      
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setStyle("-fx-background-color: #A3D5FF;");

        
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
            gridPane.getColumnConstraints().add(cc);
        }
        

        for (int i = 0; i < 4; i++){
            RowConstraints rc = new RowConstraints();
            rc.setPercentHeight(25); 
            rc.setVgrow(Priority.ALWAYS); 
            gridPane.getRowConstraints().add(rc);
        }
        

        gridPane.add(main_appTitle, 1, 0);
        gridPane.add(main_byLine, 1, 1);
        gridPane.add(main_about, 1, 2);
        gridPane.add(main_enterFile, 0, 3);
        gridPane.add(main_enterText, 2, 3);


        // File Stage

        GridPane file_gp = new GridPane();
        Scene file_scene = new Scene(file_gp, 600, 400);
        file_scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        
        
        file_gp.setPadding(new Insets(10));
        file_gp.setVgap(5);
        file_gp.setHgap(5);
        file_gp.setStyle("-fx-background-color: #A3D5FF;");

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
            file_gp.add(new Text("Is this the right stuff?"), 1, 0);
            file_gp.add(file_message, 1, 1);
            
            stage.setScene(file_scene);
        });



        // TextBox Stage

        Text textBox_message = new Text(150, 150, "text box message");
        Group root2 = new Group(textBox_message);
        Scene textBox_scene = new Scene(root2, 600, 400);          

        main_enterText.setOnAction(e -> {
            stage.setScene(textBox_scene);
        });


        

        Scene scene = new Scene(gridPane, 600, 400);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); // Load CSS
        stage.setTitle("Sample Aplication");
        stage.setScene(scene);
        stage.show();
    }

    

    public static void main(String[] args) {
        launch();
    }

}