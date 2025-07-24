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
More shapes will come in the future!
>ps. there are cases with /* and /** that dont work properly and are still being worked on :D

## Different Shapes

### Line (Original)
```
package com.example; import java.io.File; import java.io.FileNotFoundException; import java.io.IOException; import java.util.Scanner; public class LinePlay { File selectedFile; String enteredText = "" ; String finalResult = "" ; String option; public LinePlay(File selectedFile, String option){ this.selectedFile = selectedFile; this.option = option; } public LinePlay(String enteredText, String option){ this.enteredText = enteredText; this.option = option; } public String runReport() throws FileNotFoundException, IOException{ Scanner fileScan = enteredText.isEmpty() ? new Scanner(selectedFile) : new Scanner(enteredText); CodeData fileData = new CodeData(fileScan); switch (option){ case "Line" : for (String cur : fileData.getTokenList()){ finalResult += cur + " " ; } break; case "Diamond" : OneDiamond diam = new OneDiamond(fileData); finalResult = diam.diamond(); break; case "Diagonal" : Diagonal diag = new Diagonal(fileData); finalResult = diag.diagonal(); break; case "ZigZag" : ZigZag zig = new ZigZag(fileData); finalResult = zig.zigZag(); break; } return finalResult; } } 
```
>is one line trust

### Diamond
```
                                           package
                                     com.example; import
                                 java.util.List;   public
                                          class     ZigZag
                                             {       CodeData
                                        data;         public
                             ZigZag(CodeData           data){
                                  this.data             =
                                     data;               }
                                   public                 String
                               zigZag(){                   String
                                toWrite                     =
                                    ""                       ;
                         List<String>                         tokens
                                   =                           data.getTokenList();
                            boolean                             reverse
                                 =                               false;
                              int                                 cnt
                               =                                   0;
                            for                                     (String
                     codeChunk                                       :
                     tokens){                                         if
                        (cnt                                           ==
              data.getCnt()                                             /
                         5                                               ||
                reverse){                                                 reverse
                       =                                                   true;
                     if                                                     (cnt
                    ==                                                       1){
              reverse                                                         =
                false;                                                       }
                  else{                                                     for
                    (int                                                   i
                        =                                                 0;
                         i                                               <
                       cnt;                                             i++){
                     toWrite                                           +=
                          " "                                         ;
                             }                                       }
                         cnt--;                                     }
                           else{                                   for
                             (int                                 i
                                 =                               0;
                                  i                             <
                                cnt;                           i++){
                              toWrite                         +=
                                   " "                       ;
                                      }                     cnt++;
                                       }                   toWrite
                                       +=                 codeChunk
                                         +               "\n"
                                          ;             }
                                      return           toWrite;
                                            }         }
                 
```


### Diagonal
```
import
 java.util.Scanner;
  class
   Main
    {
     public
      static
       void
        main(String[]
         args)
          {
           char
            operator;
             Double
              number1,
               number2,
                result;
                 /*  create an object of Scanner class */
                  Scanner
                   input
                    =
                     new
                      Scanner(System.in);
                       /*  ask users to enter operator */
                        System.out.println("Choose
                         an
                          operator:
                           +,
                            -,
                             *,
                              or
                               /");
                                operator
                                 =
                                  input.next().charAt(0);
                                   /*  ask users to enter numbers */
                                    System.out.println("Enter
                                     first
                                      number");
                                       number1
                                        =
                                         input.nextDouble();
                                          System.out.println("Enter
                                           second
                                            number");
                                             number2
                                              =
                                               input.nextDouble();
                                                switch
                                                 (operator)
                                                  {
                                                   /*  performs addition between numbers */
                                                    case
                                                     '+':
                                                      result
                                                       =
                                                        number1
                                                         +
                                                          number2;
                                                           System.out.println(number1
                                                            +
                                                             " + "
                                                              +
                                                               number2
                                                                +
                                                                 " = "
                                                                  +
                                                                   result);
                                                                    break;
                                                                     /*  performs subtraction between numbers */
                                                                      case
                                                                       '-':
                                                                        result
                                                                         =
                                                                          number1
                                                                           -
                                                                            number2;
                                                                             System.out.println(number1
                                                                              +
                                                                               " - "
                                                                                +
                                                                                 number2
                                                                                  +
                                                                                   " = "
                                                                                    +
                                                                                     result);
                                                                                      break;
                                                                                       /*  performs multiplication between numbers */
                                                                                        case
                                                                                         '*':
                                                                                          result
                                                                                           =
                                                                                            number1
                                                                                             *
                                                                                              number2;
                                                                                               System.out.println(number1
                                                                                                +
                                                                                                 " * "
                                                                                                  +
                                                                                                   number2
                                                                                                    +
                                                                                                     " = "
                                                                                                      +
                                                                                                       result);
                                                                                                        break;
                                                                                                         /*  performs division between numbers */
                                                                                                          case
                                                                                                           '/':
                                                                                                            result
                                                                                                             =
                                                                                                              number1
                                                                                                               /
                                                                                                                number2;
                                                                                                                 System.out.println(number1
                                                                                                                  +
                                                                                                                   " / "
                                                                                                                    +
                                                                                                                     number2
                                                                                                                      +
                                                                                                                       " = "
                                                                                                                        +
                                                                                                                         result);
                                                                                                                          break;
                                                                                                                           default:
                                                                                                                            System.out.println("Invalid
                                                                                                                             operator!");
                                                                                                                              break;
                                                                                                                               }
                                                                                                                                input.close();
                                                                                                                                 }
                                                                                                                                  }
```

### ZigZag
```
package
 com.example;
  import
   java.util.List;
    public
     class
      OneDiamond
       {
        CodeData
         data;
          public
           OneDiamond(CodeData
            data){
             this.data
              =
               data;
                }
                 public
                  String
                   diamond(){
                    int
                     radius
                      =
                       (int)Math.ceil((((data.getCnt()
                        *
                         1.0)
                          /
                           (2
                            *
                             Math.PI))
                              +
                               Math.round(data.getCnt()
                                /
                                 10.0)));
                                  /*  works until last point */
                                   int
                                    maxLengthWord
                                     =
                                      20;
                                       String
                                        print
                                         =
                                          ""
                                           ;
                                            List<String>
                                             tokens
                                              =
                                               data.getTokenList();
                                                int
                                                 curRad
                                                  =
                                                   0;
                                                    boolean
                                                   decrement
                                                  =
                                                 false;
                                                boolean
                                               rightCheck
                                              =
                                             false;
                                            boolean
                                           middleCheck
                                          =
                                         false;
                                        for
                                       (String
                                      curData
                                     :
                                    tokens)
                                   {
                                  /*  Top and Bottom */
                                 if
                                (curRad
                               ==
                              0){
                             for
                            (int
                           i
                          =
                         0;
                        i
                       <
                      radius
                     -
                    curData.length()
                   +
                  1
                 +
                maxLengthWord;
               i++){
              print
             +=
            " "
           ;
          }
         print
        +=
       curData
      +
     "\n"
    ;
   curRad++;
  }
/*  Middle  */
else
 if(curRad
  ==
   radius){
    /*  Middle right check */
     if
      (middleCheck){
       print
        +=
         curData
          +
           "\n"
            ;
             curRad--;
              decrement
               =
                true;
                 }
                  else{
                   for
                    (int
                     i
                      =
                       0;
                        i
                         <
                          maxLengthWord
                           -
                            curData.length()
                             +
                              1;
                               i++){
                                print
                                 +=
                                  " "
                                   ;
                                    }
                                     print
                                      +=
                                       curData;
                                        for
                                         (int
                                          i
                                           =
                                            0
                                             ;
                                              i
                                               <
                                                (radius
                                                 *
                                                  2
                                                   -
                                                    1);
                                                   i++){
                                                  print
                                                 +=
                                                " "
                                               ;
                                              }
                                             middleCheck
                                            =
                                           true;
                                          }
                                         }
                                        /*  Everything else */
                                       else{
                                      /*  Ends Checking for repeated shapes (radius limit is to be changed for repeated diamond shapes instead of setting final radius at beginning) */
                                     if
                                    (curRad
                                   ==
                                  0){
                                 decrement
                                =
                               false;
                              continue;
                             }
                            /*  Right insertion and decrement check  */
                           if
                          (rightCheck){
                         for
                        (int
                       i
                      =
                     0;
                    i
                   <
                  curRad;
                 i++){
                print
               +=
              " "
             ;
            }
           print
          +=
         curData
        +
       "\n"
      ;
     rightCheck
    =
   false;
  if
(decrement){
curRad--;
 }
  else{
   curRad++;
    }
     }
      else{
       /*  Left Spacing */
        for
         (int
          i
           =
            curRad;
             i
              <
               radius
                -
                 curData.length()
                  +
                   1
                    +
                     maxLengthWord;
                      i++){
                       print
                        +=
                         " "
                          ;
                           }
                            print
                             +=
                              curData;
                               /*  Space between */
                                for
                                 (int
                                  i
                                   =
                                    1;
                                     i
                                      <
                                       curRad;
                                        i++){
                                         print
                                          +=
                                           " "
                                            ;
                                             }
                                              rightCheck
                                               =
                                                true;
                                                 }
                                                  }
                                                   }
                                                    return
                                                   print;
                                                  }
                                                 }
```