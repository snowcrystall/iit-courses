package labs.lab1;

import java.util.Scanner;

/*
 * Exercises
 * 1. _Reading input and writing output:_ 
 * Writing a Java program that will prompt a user for a name; 
 * save the input and echo the name to the console.
 */

public class ExerciseOne {

	public static void main(String[] args) {
		// create a variable for reading in user input
		Scanner input = new Scanner(System.in);
		
		// prompt the user to type the name
		System.out.print("name: ");
		
		// read in the next line of text typed by the user
		String name = input.nextLine();
		
        // close our scanner
        input.close(); 
        
		// print out what the user entered
		System.out.println("Name: " + name);
	}

}
