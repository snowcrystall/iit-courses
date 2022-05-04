/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/02/25
 * 
 * Question One: Data Types
 * Write a program that prompts the user for an integer, add 65 to it, 
 * convert the result to a character and print that character to the console.
 */
package exams.first;

import java.util.Scanner;

public class QuestionOne {
    public static void main(String[] args) {
        // create a variable for reading in user input
		Scanner input = new Scanner(System.in);
		
		// prompt the user for a number
		System.out.print("Input an integer: ");
		int number = Integer.parseInt(input.nextLine());
		
        // close our scanner
        input.close(); 

        number += 65;

        System.out.println("The character result: " + (char)number );
    }
}
