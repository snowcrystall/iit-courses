/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/02/25
 * 
 * Question Four: Arrays
 * Write a program that prompts the user for 5 words and prints out any word that appears more than once. 
 * 
 * **NOTE:** 

 * - The words should be an exact match, i.e. it should be case sensitive.
 * - Your program _must_ use an array.
 * - Do not sort the data or use an ArrayLists.
 */

package exams.first;

import java.util.Scanner;
public class QuestionFour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] words = new String[5];

        for (int i = 0; i < words.length; i++) {
            System.out.println("Enter a word:");
            words[i] = input.nextLine();
        }

        input.close();

        // for each word, compare it to all words after it in the array, set other words to "" that equals to it
        // if the word never appears in the array, set it to ""
        boolean appears = false;
        for (int i = 0; i < words.length; i++) {  
            if (words[i] == ""){
                continue;
            }   
            for ( int j = i+1; j < words.length; j++) {
                if (words[i].compareTo(words[j]) == 0){
                    words[j] = "";
                    appears = true;
                }
            }
            if (!appears){
                words[i] = "";
            }
            appears = false;
        }


        //prints out any word that appears more than once. 
        System.out.print("Word that appears more than once: ");
        for (int i = 0; i < words.length; i++){
            if (words[i] != ""){
                System.out.print(" "+ words[i] + " ");
            }
        }
        System.out.println();
    }
}
