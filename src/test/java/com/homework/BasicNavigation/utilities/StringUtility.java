package com.homework.BasicNavigation.utilities;

/*
   5. Create class StringUtility under utilities package.
   6. Create a public static method verifyEquals which takes two string arguments,
   expected and actual.
   7. The method prints `PASS` if both strings are equals to each other. Else it prints
   `FAIL` and it also prints the values of both arguments.
    */

public class StringUtility {

    public static String verifyEquals(String expected, String actual){
        if(expected.equals(actual)){
            return "PASS";
        }else{
            return "FAIL";
        }
    }

    public static String verifyStartWith(String URL, String str){
        if(URL.startsWith(str)){
            return "PASS";
        }else{
            return "FAIL";
        }
    }
    public static String verifyContains(String Url, String title) {
        if (Url.contains(title)) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }
}
