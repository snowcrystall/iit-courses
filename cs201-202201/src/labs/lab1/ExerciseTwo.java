package labs.lab1;


/*
 * Exercises
 * 2. _Performing arithmetic calculations:_ 
 * Output the result of the following calculations; 
 * be sure to write a descriptive comment for each output so the reader knows what is being calculated:

   * Your age subtracted from your father's age
   * Your birth year multiplied by 2
   * Convert your height in inches to cms
   * Convert your height in inches to feet and inches where inches is an integer (mode operator)
*/
public class ExerciseTwo {
    public static void main(String[] args) {
		
        // define father's age, my age, birth year and height in inches
		int fatherAge = 75;
		int myAge = 30;
		int birthYear = 1992;
		float height = 74.56f;
        
		// print out 
		System.out.println("Your age " + myAge + " subtracted from your father's age " + fatherAge + " : " + (fatherAge - myAge));
        System.out.println("Your birth year " + birthYear + " multiplied by 2: " + birthYear*2);
        System.out.printf("Your height " + height + "(inches) in cms: %.2f \n" , height*2.54);
        System.out.printf("Your height " + height + "(inches) in feet: %.2f \n" , height/12);
        System.out.println("Your height in inches where inches is an integer (mode operator) : " + (int)height);
	}
}
