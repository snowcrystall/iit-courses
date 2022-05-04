/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/29
 * Question Three: ArrayLists
 * Write a Java program that prompts the user to enter a sequence of numbers, 
 * storing them in an ArrayList, and continues prompting the user for numbers until they enter "Done". 
 * When they have finished entering numbers, your program should return the minimum and maximum values entered.
 */

package exams.second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuestionThree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Double> numberList = new ArrayList<Double>();
        while(true){
            System.out.println("Please input a number , or 'Done' to quit.");
            String in = input.nextLine();
            if (in.equalsIgnoreCase("Done")){
                break;
            }
            try {
                double number = Double.parseDouble(in);
                numberList.add(number);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        input.close();
        Collections.sort(numberList);
        if (numberList.size() == 0 ){
            System.out.println("The input empty.");
        }else{
            System.out.println("The minimum : " + numberList.get(0)+ " The maximum : "+ numberList.get(numberList.size()-1));
        }
        
    }
}
