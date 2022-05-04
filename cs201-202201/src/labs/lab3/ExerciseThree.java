/*
 * Xuemin Cheng , course 201 2022/02/09
 * 
 * 3. Write a program that will find the minimum value and print it to the console for the given array:

```java
{72, 101, 108, 108, 111, 32, 101, 118, 101, 114, 121, 111, 110, 101, 33, 32, 76, 111, 111, 
    107, 32, 97, 116, 32, 116, 104, 101, 115, 101, 32, 99, 111, 111, 108, 32, 115, 121, 109, 
    98, 111, 108, 115, 58, 32, 63264, 32, 945, 32, 8747, 32, 8899, 32, 62421}
```

 */
package labs.lab3;

public class ExerciseThree {
    public static void main(String[] args) {

        // init int array
        int[] numbers = {72, 101, 108, 108, 111, 32, 101, 118, 101, 114, 121, 111, 110, 101, 33, 32, 76, 111, 111, 
            107, 32, 97, 116, 32, 116, 104, 101, 115, 101, 32, 99, 111, 111, 108, 32, 115, 121, 109, 
            98, 111, 108, 115, 58, 32, 63264, 32, 945, 32, 8747, 32, 8899, 32, 62421};
        
        // find the minimum value
        int mini = numbers[0];
        for (int i=0;i<numbers.length; i++){
            if (mini > numbers[i]){
                mini = numbers[i];
            }

        }
        System.out.println("The minimum value : " + mini);
    }
}
