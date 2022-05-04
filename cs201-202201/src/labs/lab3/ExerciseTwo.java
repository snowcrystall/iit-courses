/*
 * Xuemin Cheng , course 201 2022/02/09
 * 
 * 
 * 2. Write a program that will continue to prompt the user for numbers, 
 * storing them in an array, until they enter "Done" to finish, 
 * then prompts the user for a file name so that these values can be saved to that file. 
 * For example, if the user enters "output.txt", 
 * then the program should write the numbers that have been read to "output.txt".
 */
package labs.lab3;


import java.util.Scanner;
import java.io.FileWriter;


public class ExerciseTwo {
    public static void main(String[] args) {
        //create scanner for user input
        Scanner input = new Scanner(System.in);

        //prompt the user for numbers,until they enter "Done" to finish
        System.out.println("Please input numbers,enter Done to finish.");

        //create array to store numbers
        int SIZE = 2;
        int[] numbers = new int[SIZE];
        //index of array
        int i = 0;
        // the input 
        String line ;
        boolean running = true;
        while (running){
            System.out.print("input a number: ");
            line = input.nextLine();
            if (line.equalsIgnoreCase("done")){
                running = false;
                continue;
            }
            // Handling input exceptions
            try{
                if (i == numbers.length) {
                    // resize the array
                    int[] bigger = new int[2 * numbers.length];
                    for (int j=0; j<numbers.length; j++) {
                        bigger[j] = numbers[j];
                    }
                    numbers = bigger;
                    bigger = null;
                }
                numbers[i] = Integer.parseInt(line);
                i++;
            }catch (Exception e){
                System.out.println("Invalid Input. '" + numbers[i] + "' is not a valid number.");
                continue;
            }
        }

        //prompts the user for a file name
        System.out.println("Input filename: ");
        String filename = input.nextLine();

        input.close();
        FileWriter f ;
        try {
            // create filewriter 
			f = new FileWriter("src/labs/lab3/" + filename);
			
            // i is the real counts of numbers array
			for (int  j=0; j<i; j++) {
				f.write(numbers[j] + "\n");
			}
			f.flush();
			f.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Finished Writing");
    }
}
