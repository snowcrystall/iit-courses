package labs.lab2;

import java.util.Scanner;

/*
 * 2. Write a Java program that will prompt the user for the grades for an exam, computes the average, and returns the result. 
 * Your program must be able to handle an unspecified number of grades.

   * Be sure to test your code with a variety of values and number of grades.
   * (Hint: Tell the user to enter -1 when they finished entering grades)
*/
public class ExerciseTwo {
    public static void main(String[] args) {

        // create a variable for reading in user input
        Scanner input = new Scanner(System.in);

        // initialize flag
		boolean running = true; 
		System.out.println("Input the grades for an exam,enter -1 when you finished entering grades:");

        int average = 0; //the average 
        int num = 0; // the number of grades

		while(running) {
			// print user menu
			System.out.println("Input a grade: enter -1  finished : ");
			int in = Integer.parseInt(input.nextLine());
			
            if (in >= 0) {
                average += in;
                num++;
            }else if (in == -1 ){
                running = false;
                System.out.println("Your input is done. ");
            }else {
                System.out.println("Ingore invalide grade.");
            }
		}
		input.close();

        
        if (num > 0){
		    average  = average/num;
        }
		System.out.println("The average : " + average);
    }
    
}
