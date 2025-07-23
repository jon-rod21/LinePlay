# Welcome to Line Play

## About
Java has this cool feature where the entirety of a program can be written in one line if written in the proper format/spacing
```
// Preferrable
if (something == 10) {
    return true;
}

// Not Preferrable
if (something == 10) return true;
```

This program takes in user code, either a file or typing input, and rearranges it in fun shapes chosen by the user.

## Different Shapes

### Line (Original)
```
package com.example; import java.util.Scanner; public class ZigZag { CodeData data; public ZigZag(CodeData data){ this.data = data; } public String zigZag(){ String finalString; try (Scanner dataScanner = new Scanner(data.fileContent)) { String codeChunk; String toWrite = ""; boolean reverse = false; boolean open = false; boolean quote = false; int cnt = 0; String quoteString = ""; while (dataScanner.hasNext()){ codeChunk = dataScanner.next(); if (!quote){ if (cnt == data.cnt / 5 || reverse){ reverse = true; if (cnt == 1){ reverse = false; } else{ for (int i = 0; i < cnt; i++){ toWrite += " "; } } cnt--; } else{ for (int i = 0; i < cnt; i++){ toWrite += " "; } cnt++; } } if (codeChunk.contains("\"") && !open){ open = true; quote = true; quoteString += codeChunk + " "; } else if(open){ if (codeChunk.contains("\"")){ open = false; quote = false; quoteString += codeChunk + "\n"; toWrite += quoteString; quoteString = ""; continue; } quoteString += codeChunk + " "; } else{ toWrite += codeChunk + "\n"; } } finalString = toWrite; } return finalString; } } 
```
>is one line trust

### Diamond
```
                                                        package
                                                  com.example; import
                                           java.util.Scanner;   public
                                                       class     ZigZag
                                                          {       CodeData
                                                     data;         public
                                          ZigZag(CodeData           data){
                                               this.data             =
                                                  data;               }
                                                public                 String
                                            zigZag(){                   String
                                        finalString;                     try
                                           (Scanner                       dataScanner
                                                 =                         new
                       Scanner(data.fileContent))                           {
                                          String                             codeChunk;
                                         String                               toWrite
                                             =                                 ""; boolean reverse = false; boolean open = false; boolean quote = false; int cnt = 0; String quoteString = "";
                                        while                                   (dataScanner.hasNext()){
                                   codeChunk                                     =
                        dataScanner.next();                                       if
                                 (!quote){                                         if
                                     (cnt                                           ==
                                data.cnt                                             /
                                      5                                               ||
                             reverse){                                                 reverse
                                    =                                                   true;
                                  if                                                     (cnt
                                 ==                                                       1){
                           reverse                                                         =
                           false;                                                           }
                           else{                                                             for
                           (int                                                               i
                             =                                                                 0;
                            i                                                                   <
                        cnt;                                                                     i++){
                    toWrite                                                                       +=
                      " ";                                                                         }
                        }                                                                           cnt--;
                       }                                                                             else{
                    for                                                                               (int
                     i                                                                                 =
                   0;                                                                                   i
                     <                                                                                 cnt;
                  i++){                                                                               toWrite
                      +=                                                                             " ";
                        }                                                                           cnt++;
                         }                                                                         }
                         if                                                                       (codeChunk.contains("\"") && !open){ open = true; quote = true; quoteString += codeChunk + "
"; } else if(open){ if (codeChunk.contains("\"")){                                                                     open
                            =                                                                   false;
                         quote                                                                 =
                         false;                                                               quoteString
                              +=                                                             codeChunk
                                +                                                           "\n"; toWrite += quoteString; quoteString = "";
                         continue;                                                         }
                        quoteString                                                       +=
                           codeChunk                                                     +
                                 " ";                                                   }
                                 else{                                                 toWrite
                                     +=                                               codeChunk
                                       +                      
```


### Diagonal

### ZigZag