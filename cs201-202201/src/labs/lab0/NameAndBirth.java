package labs.lab0;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
//import java.text.*;
import java.util.*;
/*
 * Name and Birthdate program
 */

public class NameAndBirth {
    
    public static void main(String[] args) {
        // name
        String name = "Xuemin Cheng";
        
        // birthdate
        // use my birthdate instance Date object
        Date birth = new SimpleDateFormat("yyyy-MM-dd").parse("1985-12-27",new ParsePosition(0));
        // format Date object to string
        String strBirth = new SimpleDateFormat("MMM. dd, yyyy",new Locale("en")).format(birth);
        //output
        System.out.printf("My name is %s and my birthdate is %s." , name, strBirth);
    }
}
