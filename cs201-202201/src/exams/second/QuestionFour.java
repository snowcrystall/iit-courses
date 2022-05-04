/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/29
 * Question Four: Sorting
 */

package exams.second;

public class QuestionFour {

    public static void main(String[] args) {
		String[] strs = {"speaker", "poem", "passenger", "tale", "reflection", "leader", "quality", "percentage", "height", "wealth", "resource", "lake", "importance"};
		
		strs = selectSort(strs);
		
		for (String str : strs) {
			System.out.print(str + " ");
		}
	}

    public static String[] selectSort(String[] array) {
		for (int i=0; i<array.length - 1; i++) {
			int min = i;
			for (int j=i+1; j<array.length; j++) {
				if (array[j].compareTo(array[min]) < 0) {
					min = j;
				}
			}
			
			if (min != i) {
				String temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		
		return array;
	}
}
