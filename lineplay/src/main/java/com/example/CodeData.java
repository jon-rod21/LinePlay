package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* works with multi-line comments too! */
public class CodeData {    
    List<String> tokenList;

    public CodeData(Scanner content) throws IOException{    
        tokenList = tokenizeInput(content);
    }

    public int getCnt(){
        return tokenList.size();
    }
    
    public List<String> getTokenList(){
        return tokenList;
    }

    // Currently gets everything but comments
    public static List<String> tokenizeInput(Scanner fileContent) throws IOException {
        List<String> tokens = new ArrayList<>();
        
        StringBuilder content = new StringBuilder();
        while (fileContent.hasNextLine()){
            content.append(fileContent.nextLine());
            if (fileContent.hasNextLine()){
                content.append("\n");
            }
        }

        String processedContent = convertSingleLineComments(content.toString());
        
        Pattern pattern = Pattern.compile("//.*?(?=\\n|$)|/\\*[\\s\\S]*?\\*/|\"([^\"\\\\]|\\\\.)*\"|\\S+");
        Matcher matcher = pattern.matcher(processedContent);
        
        while (matcher.find()) {
            tokens.add(matcher.group());
            // String token = matcher.group();
            // tokens.add(token);
            // System.out.println("Token: '" + token + "'");
        }
        
        return tokens;
    }

    private static String convertSingleLineComments(String content) {
        StringBuilder result = new StringBuilder();
        boolean inString = false;
        boolean inMultiLineComment = false;
        boolean escaped = false;
        
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            char next = (i + 1 < content.length()) ? content.charAt(i + 1) : '\0';
            
            if (escaped) {
                result.append(c);
                escaped = false;
            } 
            else if (c == '\\' && inString) {
                result.append(c);
                escaped = true;
            } 
            else if (c == '"' && !inMultiLineComment) {
                result.append(c);
                inString = !inString;
            } 
            else if (!inString && !inMultiLineComment && c == '/' && next == '*') {
                result.append(c);
                inMultiLineComment = true;
            } 
            else if (inMultiLineComment && c == '*' && next == '/') {
                result.append(c);
                result.append(next);
                inMultiLineComment = false;
                i++;
            } 
            else if (!inString && !inMultiLineComment && c == '/' && next == '/') {
                result.append("/* "); i++; i++;
                while (i < content.length() && content.charAt(i) != '\n') {
                    result.append(content.charAt(i));
                    i++;
                }
                result.append(" */");

                if (i < content.length() && content.charAt(i) == '\n') {
                    result.append('\n');
                }
            } 
            else {
                result.append(c);
            }
        }
        return result.toString();
    }
}

