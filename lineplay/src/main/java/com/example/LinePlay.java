package com.example;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LinePlay {
    File selectedFile;
    String enteredText = "";
    static String finalResult;
    String option;

    public LinePlay(File selectedFile, String option){
        this.selectedFile = selectedFile;
        this.option = option;
        finalResult = "";
    }

    public LinePlay(String enteredText, String option){
        this.enteredText = enteredText;
        this.option = option;
        finalResult = "";

    }

    public String runReport() throws FileNotFoundException, IOException{
        Scanner fileScan = enteredText.isEmpty() ? new Scanner(selectedFile) : new Scanner(enteredText);
        CodeData fileData = fileReaderCounter(fileScan);

        switch (option){
            case "Line":
                finalResult = fileData.getFileContent();
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
    
    

    private static CodeData fileReaderCounter(Scanner fileScan) throws IOException{
        String codeChunk = fileScan.next();
        String retString = "";
        int cnt = 1;
        boolean open = false;

        while (!codeChunk.equals("iquit")){
            if (codeChunk.contains("\"\"")){
                cnt++;
            }
            else if (codeChunk.contains("\"") && !open){
                open = true;
            }
            else if (open){
                if (codeChunk.contains("\"")){
                    open = false;
                    cnt++;
                }                   
            }
            else{
                cnt++; 
            }
            retString += codeChunk + " ";
            codeChunk = fileScan.next();
        }
        return new CodeData(cnt, retString);
    }

    
}
