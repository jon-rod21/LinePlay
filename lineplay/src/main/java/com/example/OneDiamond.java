package com.example;

import java.util.List;

public class OneDiamond {
    CodeData data;
    
    public OneDiamond(CodeData data){
        this.data = data;
    }

    public String diamond(){

        int radius = (int)Math.ceil((((data.getCnt() * 1.0) / (2 * Math.PI)) + Math.round(data.getCnt() / 10.0))); // works until last point
        int maxLengthWord = 20;
        String print = "";

        List<String> tokens = data.getTokenList();

        int curRad = 0;
        boolean decrement = false;
        boolean rightCheck = false;
        boolean middleCheck = false;

        for (String curData : tokens) {  
            // Top and Bottom
            if (curRad == 0){
                for (int i = 0; i < radius - curData.length() + 1 + maxLengthWord; i++){
                    print += " ";
                }
                print += curData + "\n";
                curRad++;
            }
            // Middle 
            else if(curRad == radius){
                // Middle right check
                if (middleCheck){
                    print += curData + "\n";
                    curRad--;
                    decrement = true;
                }
                else{
                    for (int i = 0; i < maxLengthWord - curData.length() + 1; i++){
                        print += " ";
                    }
                    print += curData;

                    for (int i = 0 ; i < (radius * 2 - 1); i++){
                        print += " ";
                    } 
                    middleCheck = true;
                }
                
                
            }
            // Everything else
            else{
                // Ends Checking for repeated shapes (radius limit is to be changed for repeated diamond shapes instead of setting final radius at beginning)
                if (curRad == 0){
                    decrement = false;
                    continue;
                }

                // Right insertion and decrement check 
                if (rightCheck){
                    for (int i = 0; i < curRad; i++){
                        print += " ";
                    }
                    print += curData + "\n";
                    rightCheck = false;

                    if (decrement){
                        curRad--;
                    }
                    else{
                        curRad++;
                    }
                    
                }
                else{
                    // Left Spacing
                    for (int i = curRad; i < radius - curData.length() + 1 + maxLengthWord; i++){
                        print += " ";
                    }
                    print += curData;

                    // Space between
                    for (int i = 1; i < curRad; i++){
                        print += " ";
                    }

                    rightCheck = true;
                }
            }    
        }
        return print;
    }
}
