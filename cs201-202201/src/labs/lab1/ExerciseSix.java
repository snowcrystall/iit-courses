package labs.lab1;

import java.util.Scanner;

/*
 * 6. Write a program that will convert inches to centimeters:

   * Prompt the user for inches.
   * Convert inches to centimeters
   * Display the result to the console.
   * Test your program with various inputs. Use a test table like above with as many rows as needed to test your program.
   * test talbe
   *  test value inches | results centimeters
   *  23 | 58.42
   *  0  | 0.0
   *  -23 | -58.42
*/

public class ExerciseSix {
    public static void main(String[] args) {
		// create a variable for reading in user input
		Scanner input = new Scanner(System.in);
		
		// Prompt the user for inches.
		System.out.print("inches: ");
		
		// read in the inches
		float inches = input.nextFloat();
		
        // close our scanner
        input.close(); 
        
		// Convert inches to centimeters and print out 
		System.out.println("inches to centimeters: " + inches*2.54);
	}
}
