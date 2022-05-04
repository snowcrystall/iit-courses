/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/29
 * Question Five: Searching
 */

package exams.second;

import java.util.Scanner;

public class QuestionFive {

    public static void main(String[] args) {
		double[] doubles = {0.577, 1.202, 1.282, 1.304, 1.414, 1.618, 1.732, 2.685, 2.718, 3.142};

		Scanner input = new Scanner(System.in);
		System.out.print("Search double: ");

		String in = input.nextLine();
        double search = 0;
        try {
            search = Double.parseDouble(in);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		int pos = jumpSearchR(doubles, search,0);
		if (pos == -1) {
			System.out.println( " -1 ");
		} else {
			System.out.println(pos);
		}

		input.close();
	}
	public static int jumpSearchR(double[] array, double value,int step){
		if (array[Math.min(step+(int)Math.sqrt(array.length), array.length - 1)] >= value){
			int prev = step;
			while (array[prev] < value) {
				prev++;
				if (prev == Math.min(step, array.length - 1)) {
					break;
				}
			}
			if (array[prev]== value) {
				return prev;
			}	
			return -1;
		}else if (step >= array.length){
			return -1;
		}else{
			return jumpSearchR(array, value,step+(int)Math.sqrt(array.length));
		}
	}

    public static int jumpSearch(double[] array, double value) {
		int step = (int)Math.sqrt(array.length);
        
		int prev = 0;
		while (array[Math.min(step, array.length - 1)] < value) {
			prev = step;
			step += (int)Math.sqrt(array.length);
			if (prev >= array.length) {
				return -1;
			}
		}
		
		while (array[prev] < value) {
			prev++;
			if (prev == Math.min(step, array.length - 1)) {
				break;
			}
		}
		
		if (array[prev]== value) {
			return prev;
		}	
		return -1;
	}

	
}
