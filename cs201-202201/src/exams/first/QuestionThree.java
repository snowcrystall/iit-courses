/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/02/25
 * 
 * Question Three: Repetition
 * Write a program that prompts the user for an integer and then prints out a Triangle of that height and width. 
 * For example, if the user enters 3, then your program should print the following:

```java
* * *
  * *
    *
```
 */

package exams.first;

import java.util.Scanner;
public class QuestionThree {
    public static void main(String[] args) {
        // create a variable for reading in user input
		Scanner input = new Scanner(System.in);
		
		// prompt the user for a number
		System.out.print("Input an integer: ");
		int number = Integer.parseInt(input.nextLine());
		
        // close our scanner
        input.close(); 
        //prints out a Triangle of that height and width

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (j < i){
                    System.out.print("  ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

    }
}
