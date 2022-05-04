/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/04
 * 
 * Lab7
 * 4. Write a Java program that will implement the Binary Search algorithm as a recursive method and be able to search the following array of Strings for a specific value, input by the user:

    ```java
    {"c", "html", "java", "python", "ruby", "scala"}
    ```

 */

package labs.lab7;

import java.util.Scanner;
public class ExercisesFour {
    public static int BinarySearch(String[] array ,int lo, int hi, String value){
        int mid = (lo+hi)/2;
        System.out.printf("lo %d, hi %d ,mid %d\n", lo ,hi,mid);
        if (lo>=hi) {
            return -1;
        }
        
        if (array[mid].compareTo(value) == 0){
            return mid;
        }else if (array[mid].compareTo(value) > 0){
            //System.out.printf(" 1 find %d array[find] %s , %s\n", mid, array[mid],value);
            return BinarySearch(array, lo , mid, value);
        }else {
            //System.out.printf("-1 find %d array[find] %s , %s\n", mid, array[mid],value);
            return BinarySearch(array, mid+1, hi, value);
        }
        
    }
    public static void main(String[] args) {
		String[] lang = {"c", "html", "java", "python", "ruby", "scala"};
		
		Scanner input = new Scanner(System.in);
		System.out.print("Search term: ");
		String value = input.nextLine();
		int index = BinarySearch(lang, 0, lang.length ,value);
		if (index == -1) {
			System.out.println(value + " not found.");
		} else {
			System.out.println(value + " found at index " + index + ".");
		}

		input.close();
	}
	
}
