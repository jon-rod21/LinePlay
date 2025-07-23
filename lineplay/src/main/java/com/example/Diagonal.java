package com.example;

import java.util.Scanner;

public class Diagonal {
    CodeData data;

    public Diagonal(CodeData data){
        this.data = data;
    }

    public String diagonal(){
        String finalString = "";
        try (Scanner dataScanner = new Scanner(data.getFileContent())) {
            String codeChunk;
            String quoteString = "";
            int cnt = 1;
            boolean open = false;
            
            while (dataScanner.hasNext()){
                codeChunk = dataScanner.next();
                String strToWrite = "";
                if (codeChunk.contains("\"\"")){
                    // "" case and FIX NO NEW LINE AND SPACES AFTER QUOTES FOR BOTH THIS ONE AND ZIG ZAG
                }
                if (codeChunk.contains("\"") && !open){
                    open = true;
                    quoteString += codeChunk + " ";
                }
                else if (open){
                    if (codeChunk.contains("\"")){
                        open = false;
                        quoteString += codeChunk + "\n";
                        for (int i = 0; i < cnt; i++){
                            quoteString += " ";
                        }
                        finalString += quoteString;
                        quoteString = "";
                        cnt++;
                        continue;
                    }
                    quoteString += codeChunk + " ";
                }
                else{
                    strToWrite += codeChunk + "\n";
                    for (int i = 0; i < cnt; i++){
                        strToWrite += " ";
                    }

                    finalString += strToWrite;
                    cnt++; 
                }
            }
        }
        return finalString;
    }
}

