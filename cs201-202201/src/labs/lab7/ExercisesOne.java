/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/04
 * 
 * Lab7
 * 
 *1. Write a Java program that will implement the Bubble Sort algorithm as a method and sort the following array of integers:

    ```java
    {10, 4, 7, 3, 8, 6, 1, 2, 5, 9}
    ```

 */

package labs.lab7;

public class ExercisesOne {
    public static void main(String[] args) {
        int[] arr = {10, 4, 7, 3, 8, 6, 1, 2, 5, 9};
        BubbleSort(arr);

        for (int i: arr ){
            System.out.printf("%d ",i);
        }
    }
    
    public static void BubbleSort(int[] arr){
        int tmp;
        //Bubble Sort
        for (int i=0; i<arr.length; i++){
            // After each loop, the number at length-i-1 will be correct
            for (int j=0; j<arr.length-i-1; j++){
                if (arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
