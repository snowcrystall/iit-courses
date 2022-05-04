/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/02/25
 * 
 * Question Two: Selection
 * 
 * Write a program that prompts the user for an integer. 
 * If the integer is divisible by 2 print out "foo", and if the integer is divisible by 3 print out "bar". 
 * If the integer is divisible by both, your program should print out "foobar" and if the integer is not divisible by either, 
 * then your program should not print out anything.
 */
package exams.first;

import java.util.Scanner;
public class QuestionTwo {
    public static void main(String[] args) {
        // create a variable for reading in user input
		Scanner input = new Scanner(System.in);
		
		// prompt the user for a number
		System.out.print("Input an integer: ");
		int number = Integer.parseInt(input.nextLine());
		
        // close our scanner
        input.close(); 

        int divisible2 = number%2;
        int divisible3 = number%3;
        if (divisible2 == 0 && divisible3 == 0){ //the integer is divisible by both
            System.out.println("foobar");
        }else if (divisible2 == 0){    //the integer is divisible by 2
            System.out.println("foo");
        }else if (divisible3 == 0){    //the integer is divisible by 3
            System.out.println("bar");
        }
    }
}
