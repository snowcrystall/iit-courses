package labs.lab2;

import java.util.Scanner;

/*
 * 3. Write a Java program that will repeatedly display a menu of choices to a user and prompt them to enter an option. 
 * You should use the following options:

    1. Say Hello - This should print "Hello" to console.
    2. Addition - This should prompt the user to enter 2 numbers and return the sum of the two.
    3. Multiplication - This should prompt the user to enter 2 numbers and return the product of the two.
    4. Exit - Leave the program

    The program should continue to return to the menu until the user enters 4.

*/

public class ExerciseThree {
    public static void main(String[] args) {

		// create a variable for reading in user input
        Scanner input = new Scanner(System.in);

        // initialize flag
		boolean running = true; 
		
		while(running) {
			// print user menu
			System.out.println("1. Print 'Hello'");
			System.out.println("2. Addition (enter 2 numbers and return the sum of the two) :");
			System.out.println("3. Multiplication (enter 2 numbers and return the product of the two) : ");
			System.out.println("4. Done, exit program.");
			System.out.print("Choice: ");

			String choice = input.nextLine(); // get user's choice
            
		    running = !choice.equals("4"); // flag control variable
			
            float number1 = 0;
            float number2 = 0;

			// handle user menu option
			switch (choice) {
				case "1":
					System.out.println("Hello");
					break;
				case "2":
					System.out.println("Addition");
                    System.out.println("Input first number : ");
                    number1 = Float.parseFloat(input.nextLine());
                    
                    System.out.println("Input second number : ");
                    number2 = Float.parseFloat(input.nextLine());
                    
                    System.out.println("The sum of the two :" + (number1+number2) );
					break;
				case "3":
					System.out.println("Multiplication");
                    System.out.println("Input first number : ");
                    number1 = Float.parseFloat(input.nextLine());
                    
                    System.out.println("Input second number : ");
                    number2 = Float.parseFloat(input.nextLine());

                    System.out.println("The sum of the two :" + number1*number2);
					break;
				case "4":
					break;
				default:
					System.out.println("That is not a valid choice.");
			}
		}
		
		input.close();
		
		System.out.println("Goodbye");
	}

    
}
