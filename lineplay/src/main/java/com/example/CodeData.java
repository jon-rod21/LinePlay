package com.example;

public class CodeData {
    int cnt;
    String fileContent;

    public CodeData(int cnt, String fileContent){
        this.cnt = cnt;
    
        this.fileContent = fileContent;
    }

    public int getCnt(){
        return cnt;
    }

    public String getFileContent(){
        return fileContent;
    }
}

