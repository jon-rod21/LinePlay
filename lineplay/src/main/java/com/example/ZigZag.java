package com.example;

import java.util.List;

public class ZigZag {
    CodeData data;

    public ZigZag(CodeData data){
        this.data = data;
    }

    public String zigZag(){
        String toWrite = "";
        List<String> tokens = data.getTokenList();
        boolean reverse = false;
        int cnt = 0;
        
        for (String codeChunk : tokens){
            if (cnt == data.getCnt() / 5 || reverse){
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
            toWrite += codeChunk + "\n";  
        }         
        return toWrite;
    }
}

