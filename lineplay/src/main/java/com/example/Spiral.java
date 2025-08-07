package com.example;

import java.util.Arrays;
import java.util.List;

public class Spiral {
    static CodeData data;
    static int[][] shadowMatrix;
    static String[][] spiralMatrix;
    //static String returnString;
    // traverse both the shadw and the normal and replace with codeChunk

    //now have access to list and longest (longest is for a in r = atheta)
    public Spiral(CodeData data){
        Spiral.data = data;
        int size = (int)Math.ceil(Math.sqrt(Spiral.data.getCnt() * 2));
        // int size = 17;
        createMatrices(size % 2 == 0 ? size - 1 : size);
        
    }
    public void createMatrices(int size){
        createShadow(size);
        
        for (int[] temp : shadowMatrix){
            for (int cur : temp){
                System.out.print(cur + " ");
            }
            System.out.println();
        }
        
        createSpiral();
        printSpiral();
    }
    public String printSpiral(){
        String ret = "";
        for (int i = 0; i < spiralMatrix.length; i++) {
            for (int j = 0; j < spiralMatrix[i].length; j++){
                ret += spiralMatrix[i][j] + " ";
            }
            ret += "\n";
            System.out.println(Arrays.toString(spiralMatrix[i]));

        }
        return ret;
    }

    public void createSpiral(){
        spiralMatrix = new String[shadowMatrix.length][shadowMatrix.length];
        String space = "";
        for (int i = 0; i < Spiral.data.getLongest(); i++){
            space += " ";
        }
        for (String[] temp : spiralMatrix){
            Arrays.fill(temp, space);
        }
        List<String> tokenList = Spiral.data.getTokenList();
        int tokenListIndex = 0;
        for (int i = 0; i < shadowMatrix.length; i++){
            for (int j = 0; j < shadowMatrix[i].length; j++){
                if (tokenListIndex == tokenList.size()){
                    break;
                }
                if (shadowMatrix[i][j] == 1){
                    spiralMatrix[i][j] = tokenList.get(tokenListIndex);
                    
                    tokenListIndex++;
                }
                
            }
            if (tokenListIndex == tokenList.size()){
                break;
            }
        }
    }

    public void createShadow(int size){
        shadowMatrix = new int[size][size];
        for (int[] row : shadowMatrix){
            Arrays.fill(row, 0);
        }
        shadowMatrix[(size / 2) + 1][size / 2] = 1;
        createShadow(size / 2, (size / 2) + 1, 2, 1, 2, Spiral.data.getCnt());
    }
    public static void createShadow(int x, int y, int curLength, int direction, int directionLength, int lineCnt){
        
        if (x >= 0 && y >= 0 && x < shadowMatrix.length && y < shadowMatrix[x].length && lineCnt > 0) {
            shadowMatrix[x][y] = 1;
            
            if (curLength > 0) {
                switch (direction) {
                    case 0: // Right
                        createShadow(x, y + 1, curLength - 1, 0, directionLength, lineCnt - 1);
                        break;
                    case 1: // Up
                        createShadow(x - 1, y, curLength - 1, 1, directionLength, lineCnt - 1);
                        break;
                    case 2: // Left
                        createShadow(x, y - 1, curLength - 1, 2, directionLength, lineCnt - 1);
                        break;
                    case 3: // Down
                        createShadow(x + 1, y, curLength - 1, 3, directionLength, lineCnt - 1);
                        break;
                }
            } 
            else {
                int newDirection = (direction + 1) > 3 ? 0 : (direction + 1);
                createShadow(x, y, directionLength + 1, newDirection, directionLength + 1, lineCnt - 1);
            }
        }
    }
}
