package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
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

    private Stage primaryStage;
    private File selectedFile;
    private String textInput = "";
    private String option;
    private String result;
    private boolean hasFile = false;
    private boolean hasText = false;
    private boolean success = false;

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        
        stage.setTitle("Line Play Application");
        showMainScene();
        stage.show();
    }

    /*================================= */
    // Main Scene
    /*================================= */

    private void showMainScene() {
        GridPane main_gp = new GridPane();
        Scene main_scene = new Scene(main_gp, 600, 400);
        main_scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        main_gp.setStyle("-fx-background-color: #A3D5FF;");
        main_gp.setPadding(new Insets(10));
        main_gp.setVgap(5);
        main_gp.setHgap(5);

        // Setup grid constraints
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

        // Create UI components
        Text main_appTitle = new Text("Line Play"); 
        main_appTitle.getStyleClass().add("title");
        Text main_byLine = new Text("By: Jon"); 
        main_byLine.getStyleClass().add("byline");
        Text main_about = new Text("Rearrange code in fun ways!"); 
        main_about.getStyleClass().add("about");
        
        Button main_enterFile = new Button("Choose File");
        Button main_enterText = new Button("Enter Text");
         
        // Set alignments
        GridPane.setHalignment(main_appTitle, HPos.CENTER);
        GridPane.setValignment(main_appTitle, VPos.BOTTOM);
        GridPane.setHalignment(main_byLine, HPos.CENTER);
        GridPane.setValignment(main_byLine, VPos.TOP);
        GridPane.setHalignment(main_about, HPos.CENTER);
        GridPane.setValignment(main_about, VPos.TOP);
        GridPane.setHalignment(main_enterFile, HPos.RIGHT);
        GridPane.setHalignment(main_enterText, HPos.LEFT);

        // Add components to grid
        main_gp.add(main_appTitle, 1, 0);
        main_gp.add(main_byLine, 1, 2);
        main_gp.add(main_about, 1, 1);
        main_gp.add(main_enterFile, 0, 3);
        main_gp.add(main_enterText, 2, 3);

        // Set button actions
        main_enterFile.setOnAction(e -> showFileChooser());
        main_enterText.setOnAction(e -> showTextInput());

        primaryStage.setScene(main_scene);
    }

    /*================================= */
    // Open File Explorer
    /*================================= */

    private void showFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        selectedFile = fileChooser.showOpenDialog(primaryStage);
        
        showFileConfirmation();
        // if (selectedFile != null) {
        //     showFileConfirmation();
        // } else {
        //     showFileConfirmation(); // Show error message
        // }
    }

    /*================================= */
    // File Confirmation Scene
    /*================================= */

    private void showFileConfirmation() {
        GridPane file_gp = new GridPane();
        Scene file_scene = new Scene(file_gp, 600, 400);
        file_scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        file_gp.setStyle("-fx-background-color: #A3D5FF;");
        file_gp.setPadding(new Insets(10));
        file_gp.setVgap(5);
        file_gp.setHgap(5);

        // Setup grid constraints
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

        Text file_question = new Text("Is this the right stuff?");
        file_question.getStyleClass().add("title");
        
        Text file_message;
        if (selectedFile != null) {
            file_message = new Text(selectedFile.getAbsolutePath());
        } 
        else {
            file_message = new Text("There was nothing there :(");
        }
        file_message.getStyleClass().add("about");

        Button file_goNext = new Button("Yes!");
        Button file_goBack = new Button("Nope");

        GridPane.setHalignment(file_question, HPos.CENTER);
        GridPane.setHalignment(file_message, HPos.CENTER);
        GridPane.setHalignment(file_goNext, HPos.RIGHT);
        GridPane.setHalignment(file_goBack, HPos.LEFT);
        GridPane.setValignment(file_goNext, VPos.TOP);
        GridPane.setValignment(file_goBack, VPos.TOP);

        file_gp.add(file_question, 1, 1);
        file_gp.add(file_message, 1, 2);
        file_gp.add(file_goNext, 1, 3);
        file_gp.add(file_goBack, 1, 3);

        file_goNext.setOnAction(e -> {
            if (selectedFile != null) {
                hasFile = true;
                hasText = false;
                showSelection();
            }
        });

        file_goBack.setOnAction(e -> showMainScene());

        primaryStage.setScene(file_scene);
    }

    private void showTextInput() {
        GridPane text_gp = new GridPane();
        Scene text_scene = new Scene(text_gp, 600, 400);
        text_scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        text_gp.setStyle("-fx-background-color: #A3D5FF;");
        text_gp.setPadding(new Insets(40));
        text_gp.setVgap(5);
        text_gp.setHgap(5);

        Text text_message = new Text("Type your code in here!"); 
        text_message.getStyleClass().add("about");
        TextArea text_area = new TextArea();
        Button text_enter = new Button("Enter");

        text_area.getStyleClass().add("text-field");
        text_area.setWrapText(true);

        RowConstraints rc = new RowConstraints();
        rc.setPercentHeight(33.33); 
        rc.setVgrow(Priority.ALWAYS); 
        text_gp.getRowConstraints().add(rc);

        ColumnConstraints cc = new ColumnConstraints();
        cc.setPercentWidth(100); 
        cc.setHgrow(Priority.ALWAYS); 
        text_gp.getColumnConstraints().add(cc);

        GridPane.setValignment(text_message, VPos.BOTTOM);
        GridPane.setValignment(text_area, VPos.TOP);

        text_gp.add(text_message, 0, 0);
        text_gp.add(text_area, 0, 1);
        text_gp.add(text_enter, 0, 2);

        text_enter.setOnAction(e -> {
            textInput = text_area.getText();
            if (!textInput.trim().isEmpty()) {
                hasText = true;
                hasFile = false;
                showSelection();
            }
        });

        primaryStage.setScene(text_scene);
    }

    private void showSelection() {
        GridPane selection_gp = new GridPane();
        Scene selection_scene = new Scene(selection_gp, 600, 400);
        selection_scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        selection_gp.setStyle("-fx-background-color: #A3D5FF;");
        selection_gp.setPadding(new Insets(10));
        selection_gp.setVgap(5);
        selection_gp.setHgap(5);

        Text selection_message = new Text("Choose your design!"); 
        selection_message.getStyleClass().add("about");
        ComboBox<String> selection_choice = new ComboBox<>();
        Button selection_enter = new Button("Change My Code");

        selection_choice.getItems().addAll("Line", "Diamond", "Diagonal", "ZigZag");
        selection_choice.setValue("Line"); // Set default value

        RowConstraints rc = new RowConstraints();
        rc.setPercentHeight(33.33); 
        rc.setVgrow(Priority.ALWAYS); 
        selection_gp.getRowConstraints().add(rc);

        ColumnConstraints cc = new ColumnConstraints();
        cc.setPercentWidth(25); 
        cc.setHgrow(Priority.ALWAYS); 
        selection_gp.getColumnConstraints().add(cc);

        selection_gp.add(selection_message, 0, 0);
        selection_gp.add(selection_choice, 0, 1);
        selection_gp.add(selection_enter, 0, 2);

        selection_enter.setOnAction(e -> {
            option = selection_choice.getValue();
            processCodeTransformation();
        });

        primaryStage.setScene(selection_scene);
    }

    private void processCodeTransformation() {
        try {
            LinePlay linePlay;
            if (hasFile && selectedFile != null) {
                linePlay = new LinePlay(selectedFile, option);
            } 
            else if (hasText && !textInput.trim().isEmpty()) {
                linePlay = new LinePlay(textInput, option);
            } 
            else {
                throw new IllegalStateException("No valid input provided");
            }
            
            result = linePlay.runReport();
            success = true;
            
        } catch (IOException ex) {
            result = ex.toString();
            success = false;
        }
        
        showResults();
    }

    private void showResults() {
        GridPane results_gp = new GridPane();
        Scene results_scene = new Scene(results_gp, 600, 400);
        results_scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        results_gp.setStyle("-fx-background-color: #A3D5FF;");
        results_gp.setPadding(new Insets(10));
        results_gp.setVgap(5);
        results_gp.setHgap(5);

        Text results_message;
        if (success) {
            results_message = new Text("Download file or copy text?");
            results_message.getStyleClass().add("about");
            
            // figure out formatting later
            Button results_download = new Button("Download");
            Button results_copy = new Button("Copy to Clipboard");
            Button results_return = new Button("Back to Main");
            
            results_gp.add(results_message, 1, 0);
            results_gp.add(results_download, 1, 1);
            results_gp.add(results_copy, 2, 1);
            results_gp.add(results_return, 0, 1);

            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(33.33); 
            cc.setHgrow(Priority.ALWAYS); 
            results_gp.getColumnConstraints().add(cc);

            GridPane.setHalignment(results_download, HPos.CENTER);
            GridPane.setHalignment(results_copy, HPos.LEFT);
            GridPane.setHalignment(results_return, HPos.RIGHT);
            
            results_download.setOnAction(e -> {
                String userHome = System.getProperty("user.home");
                String downloadsFolder = userHome + File.separator + "Downloads";
                String fileName = "LinePlayOutput";
                String extension = ".txt";

                File file = getUniqueFile(downloadsFolder, fileName, extension);
                
                try(FileWriter writer = new FileWriter(file)){
                    writer.write(result);
                } catch (IOException ex) {
                }
            });

            results_copy.setOnAction(e -> {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(result);
                clipboard.setContent(content);
                
                results_copy.setText("Copied!");
                new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                        javafx.application.Platform.runLater(() -> results_copy.setText("Copy to Clipboard"));
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            });

            results_return.setOnAction(e -> {
                // Reset state
                hasFile = false;
                hasText = false;
                success = false;
                textInput = "";
                selectedFile = null;
                showMainScene();
            });
            
        } else {
            results_message = new Text("Oh no, " + result);
            results_message.getStyleClass().add("about");
            
            Button backBtn = new Button("Back to Main");
            results_gp.add(results_message, 0, 0);
            results_gp.add(backBtn, 0, 1);
            
            backBtn.setOnAction(e -> showMainScene());
        }

        primaryStage.setScene(results_scene);
    }
    private static File getUniqueFile(String directory, String name, String extension){
        File outputFile = new File(directory, name + extension);
        int cnt = 1;

        if (!outputFile.exists()) {
            return outputFile;
        }

        while (true) {
            String newName = name + "(" + cnt + ")" + extension;
            File outputFileWithCount = new File(directory, newName);
            if (!outputFileWithCount.exists()) {
                return outputFileWithCount;
            }
            cnt++;
        }
    }

    public static void main(String[] args) {
        launch();
    }


}