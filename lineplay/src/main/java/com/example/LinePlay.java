package com.example;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LinePlay {
    File selectedFile;
    String enteredText = "";
    String finalResult = "";
    String option;

    public LinePlay(File selectedFile, String option){
        this.selectedFile = selectedFile;
        this.option = option;
    }

    public LinePlay(String enteredText, String option){
        this.enteredText = enteredText;
        this.option = option;
    }

    public String runReport() throws FileNotFoundException, IOException{
        Scanner fileScan = enteredText.isEmpty() ? new Scanner(selectedFile) : new Scanner(enteredText);
        CodeData fileData = new CodeData(fileScan);

        switch (option){
            case "Line":
                for (String cur : fileData.getTokenList()){
                    finalResult += cur + " ";
                }
                break;
            case "Diamond":
                OneDiamond diam = new OneDiamond(fileData);
                finalResult = diam.diamond();
                break;
            case "Diagonal":
                Diagonal diag = new Diagonal(fileData);
                finalResult = diag.diagonal();
                break;
            case "ZigZag":
                ZigZag zig = new ZigZag(fileData);
                finalResult = zig.zigZag();
                break;
        }
        return finalResult;
    }
}
