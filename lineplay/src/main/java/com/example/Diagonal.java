package com.example;

import java.util.List;

public class Diagonal {
    CodeData data;

    public Diagonal(CodeData data){
        this.data = data;
    }

    public String diagonal(){
        String finalString = "";
        List<String> tokens = data.getTokenList();
        int cnt = 1;
        
        for (String codeChunk : tokens){
            
            String strToWrite = "";
           
            strToWrite += codeChunk + "\n";
            for (int i = 0; i < cnt; i++){
                strToWrite += " ";
            }

            finalString += strToWrite;
            cnt++; 
        }
        
        return finalString;
    }
}

