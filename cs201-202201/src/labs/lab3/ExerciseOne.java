/*
 * Xuemin Cheng , course 201 2022/02/09
 * 
 * ## Exercises
 * 1. You have been given a file called "src/labs/lab3/grades.csv". 
 * It contains a list of students and their exam grades. 
 * Write a program that reads in the file and computes the average grade for the class and then prints it to the console.
 */ 

package labs.lab3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ExerciseOne  {
    public static void main(String[] args)  {
        try {
            File file = new File("src/labs/lab3/grades.csv");

            // create scanner for file
            Scanner input = new Scanner(file);

            float sum = 0; // total grade
            int num = 0; // number of students
            String line; // one line of grade file
            float grade;// one grade

            while (input.hasNextLine()){
                line = input.nextLine();// get one line
                grade =  Integer.parseInt(line.substring(line.indexOf(',')+1)); // get grade
                sum += grade; 
                num++;
            }
            input.close();
            
            System.out.printf("The average grade for the class : %.2f\n" , sum/num);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
