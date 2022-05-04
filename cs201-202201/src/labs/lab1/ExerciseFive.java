package labs.lab1;

import java.util.Scanner;

/*
 * 5. Write a program that will do the following:

   * Prompt the user for the length, width, and depth in inches of a box.
   * Calculate the amount of wood (square feet) needed to make the box.
   * Display the result to the screen with a descriptive message.
   * Test your program with various inputs. Use a test table like above with as many rows as needed to test your program.
   * 
   * test table
   * test value (length,width,depth)  |  results square feet
   * (3,4,5)                          |  7.83
   * (2,300,45.3)                     |  2380.10
   * (0,34,3)                         |  invalid input
   * (-3,3,4)                         |  invalid input
*/

public class ExerciseFive {
    public static void main(String[] args) {
		// create a variable for reading in user input
		Scanner input = new Scanner(System.in);
		
		// prompt the user to type length
		System.out.print("The length in inches of a box: ");
		float length = input.nextFloat();
		
        // prompt the user to type width
		System.out.print("The width in inches of a box: ");
		float width = input.nextFloat();

        // prompt the user to type depth
		System.out.print("The depth in inches of a box: ");
		float depth = input.nextFloat();
		
        // close our scanner
        input.close(); 

		if (length <=0 || width <= 0 || depth<=0){
			System.out.println("invalid input");
			return ;
		} 
        //Calculate the amount of wood (square feet) needed to make the box.
        float squareFeet = (length*width + length*depth + depth*width)/6;

		// print out 
		System.out.printf("The amount of wood (square feet) needed to make the box: %.2f\n" , squareFeet);
	}
}
