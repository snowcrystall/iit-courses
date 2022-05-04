package labs.lab1;

import java.util.Scanner;
import java.util.*;

/*
 * 4. Write a program that will do the following:

   * Prompt the user for a temperature in Fahrenheit, convert the Fahrenheit to Celsius and display the result.
   * Prompt the user for a temperature in Celsius, convert the Celsius to Fahrenheit and display the result.
   * 
   * Test your program with various temperatures: low, high, middle. 
   * Use a test table with as many rows as needed to test your program. 
   * Are you satisfied that your program works as expected? Submit your test plan and its results.
   * 
   * test table
   * test value (Fahrenheit,Celsius)  |  results (Celsius,Fahrenheit)
   * (0,0)                            |  (32.0, -17.78)
   * (-100,-100)                      |  (-148.0,-73.33)
   * (200,200)                        |  (392.0,93.33)
*/
public class ExerciseFour {
    public static void main(String[] args) throws   InputMismatchException {
		// create a variable for reading in user input
		Scanner input = new Scanner(System.in);
		
		// Prompt the user for a temperature in Fahrenheit
		System.out.print("Input the temperature in Fahrenheit: ");
		// read in the next line of text typed by the user
		float tempFah = input.nextFloat();
		
        // print out 
		System.out.println("Temperature in Fahrenheit : " + tempFah + " , convert the Fahrenheit to Celsius : " + (32 + tempFah*1.8));
       
        // Prompt the user for a temperature in Celsius
        System.out.print("Input the temperature in Celsius: ");
		// read in the next line of text typed by the user
		float tempCel = input.nextFloat();

        System.out.printf("Temperature in Celsius : " + tempCel + " , convert the Celsius to Fahrenheit : %.2f\n" , ( (tempCel - 32)/1.8));
	
        // close our scanner
        input.close(); 
        
		}

}
