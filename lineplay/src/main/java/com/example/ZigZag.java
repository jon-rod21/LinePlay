package com.example;

import java.util.Scanner;

public class ZigZag {
    CodeData data;

    public ZigZag(CodeData data){
        this.data = data;
    }

    public String zigZag(){
        String finalString;
        try (Scanner dataScanner = new Scanner(data.fileContent)) {
            String codeChunk;
            String toWrite = "";
            
            boolean reverse = false;
            boolean open = false;
            boolean quote = false;

            int cnt = 0;
            
            String quoteString = "";

            while (dataScanner.hasNext()){
                codeChunk = dataScanner.next();
                if (!quote){
                    if (cnt == data.cnt / 5 || reverse){
                        reverse = true;
                        if (cnt == 1){
                            reverse = false;
                        }
                        else{
                            for (int i = 0; i < cnt; i++){
                                toWrite += " ";
                            }
                        }
                        cnt--;
                    }
                    else{
                        for (int i = 0; i < cnt; i++){
                            toWrite += " ";
                        }
                        cnt++;
                    }  
                } 
                
                if (codeChunk.contains("\"") && !open){
                    open = true;
                    quote = true;
                    quoteString += codeChunk + " ";
                }
                else if(open){
                    if (codeChunk.contains("\"")){
                        open = false;
                        quote = false;
                        quoteString += codeChunk + "\n";
                        toWrite += quoteString;
                        quoteString = "";
                        continue;
                    }
                    quoteString += codeChunk + " ";
                }
                else{
                    toWrite += codeChunk + "\n";
                }   
            }  
            finalString = toWrite; 
        }
        return finalString;
    }
}

