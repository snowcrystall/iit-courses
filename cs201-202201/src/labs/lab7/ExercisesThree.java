/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/04
 * 
 * Lab7
 * 3. Write a Java program that will implement the Selection Sort algorithm as a method and sorts the following array of doubles:

    ```java
    {3.142, 2.718, 1.414, 1.732, 1.202, 1.618, 0.577, 1.304, 2.685, 1.282}
    ```

 */
package labs.lab7;

public class ExercisesThree {
    public static void SelectionSort(double[] array) {
		for (int i=0; i<array.length - 1; i++) {
			int min = i;
			for (int j=i+1; j<array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			
			if (min != i) {
				double temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
	
	}

	public static void main(String[] args) {
		double[] arr = {3.142, 2.718, 1.414, 1.732, 1.202, 1.618, 0.577, 1.304, 2.685, 1.282};
		
		SelectionSort(arr);
		
		for (double l : arr) {
			System.out.print(l + " ");
		}
	}

}
