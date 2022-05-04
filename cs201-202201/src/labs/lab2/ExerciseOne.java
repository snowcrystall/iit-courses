package labs.lab2;

import java.util.Scanner;
/*
 * 1. Write a Java program that will prompt the user for a number and print out a square with those dimensions. 
 * For example, if the user enters 5, return the following:

  ```text
      * * * * *
      * * * * *
      * * * * *
      * * * * *
      * * * * *
  ```
*/

public class ExerciseOne {
    public static void main(String[] args) {
		// create a variable for reading in user input
		Scanner input = new Scanner(System.in);
		
		// prompt the user for a number
		System.out.print("number: ");
		int number = Integer.parseInt(input.nextLine());
		
        // close our scanner
        input.close(); 
        
		// output for each line
		for (int i=0;i<number;i++){
            // output for each col
            for (int j=0;j<number;j++){
                
                System.out.print("* ");
                
            }
            System.out.println();
                
        }
	}

}
