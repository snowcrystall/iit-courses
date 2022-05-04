/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/04
 * 
 * Lab7
 * 2. Write a Java program that will implement the Insertion Sort algorithm as a method and sort the following array of Strings:

    ```java
    {"cat", "fat", "dog", "apple", "bat", "egg"}
    ```

 */
package labs.lab7;

public class ExercisesTwo {
    public static void InsertionSort(String[] array) {
		for (int j=1; j<array.length; j++) {
			int i = j;
			while (i > 0 && array[i].compareTo(array[i-1]) < 0) {
				String temp = array[i];
				array[i] = array[i-1];
				array[i-1] = temp;
				i--;
			}
		}
	
	}

	public static void main(String[] args) {
		String[] str = {"cat", "fat", "dog", "apple", "bat", "egg"};
		
		InsertionSort(str);
		
		for (String l : str) {
			System.out.print(l + " ");
		}
	}
    
}
