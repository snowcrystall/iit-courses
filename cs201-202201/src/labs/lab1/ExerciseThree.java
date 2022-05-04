package labs.lab1;

import java.util.Scanner;

/*
 * Exercises
 * 3. _Getting a char from keyboard input:_ 
 * Prompt a user for a first name; 
 * display the user's first initial to the screen. (Hint: Use the String method charAt(0)).
 */

public class ExerciseThree {

	public static void main(String[] args) {
		// create a variable for reading in user input
		Scanner input = new Scanner(System.in);
		
		// prompt the user to type the name
		System.out.print("Your first name: ");
		
		// read in the next line of text typed by the user
		String name = input.nextLine();
		
        // close our scanner
        input.close(); 
        
		// print out what the user entered
		System.out.println("Your first initial: " + name.charAt(0));
	}

}
