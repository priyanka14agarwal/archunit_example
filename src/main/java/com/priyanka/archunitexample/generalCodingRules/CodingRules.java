package com.priyanka.archunitexample.generalCodingRules;

public class CodingRules {

    public void throwGenericException(){
        //throws generic exception
        try{
            new Throwable();
        }catch(Exception e){
            throwGenericException();
        }
    }

    public void useSystemOut(){
        System.out.println("Using java stream for output");
    }
}
