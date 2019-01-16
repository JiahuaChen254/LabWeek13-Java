import java.util.ArrayList;
import java.util.Arrays;

//Given two sorted lists of Integers as input, write a method that produces a sorted list of Integers as output that represents the union of the two input lists.  
//If the size of the two input lists are respectively a and b, the running time and space required by the algorithm should both be O(a + b).
public class Q1 {
	// O(size(list_a) + size(list_b))
	public static ArrayList<Integer> Merge(ArrayList<Integer> list_a, ArrayList<Integer> list_b){
		ArrayList<Integer> sorted_list = new ArrayList<Integer>();
		
		// wanted complexity O(size(a) + size(b)) where O denotes the complexity of the algorithm in the worst case
		// This means, we need to run through both lists at most once and store do a merging operation wile preserving
		// sorted integers.
		
		// Algorithmic structure
		
		int index_a = 0;
		int index_b = 0;
		// 1. loop through both lists by updating both indices of lists (i.e. index_a and index_b)
		// 2. in your loop, always update the sorted_list with the element with the smallest value
		// (i.e., the pseudo code: if list_a[index_a] < list_b[index_b] then sorted_list.add(list_a[index_a]); index_a++
		// consider what happens when index_a >= size(list_a) or index_b >= size(list_b) -> and update the sorted_list
		// with the remaining of the values.
		// 4. return the sorted_list
		
		while (index_a < list_a.size() && index_b < list_b.size()) {
			int a = list_a.get(index_a);
			int b = list_b.get(index_b);
			if (a < b) {
				sorted_list.add(a);
				index_a++;
			}
			else if (a > b) {
				sorted_list.add(b);
				index_b++;
			}
			else {
				sorted_list.add(a);
				sorted_list.add(b);
				index_a++;
				index_b++;
			}
		}
		while (index_a >= list_a.size() && index_b < list_b.size()) {
			sorted_list.add(list_b.get(index_b));
			index_b++;
		}
		while (index_a < list_a.size() && index_b >= list_b.size()) {
			sorted_list.add(list_a.get(index_a));
			index_a++;
		}
		return sorted_list;
	}
	
	public static void main(String[] args) {
		// Test your Q1 class here by calling Q1 on two sorted lists of Integers. i.e., Print out: Merge(list_a, list_b)
		ArrayList<Integer> list_a = new ArrayList<Integer>(Arrays.asList(1,3,9,17,19));
		ArrayList<Integer> list_b = new ArrayList<Integer>(Arrays.asList(2,3,4,9,11));
//		Q1 test = new Q1();		
		System.out.println(list_a); // [1, 3, 9, 17, 19]
		System.out.println(list_b); // [2, 3, 4, 9, 11]
		System.out.println(Merge(list_a, list_b)); // [1, 2, 3, 3, 4, 9, 9, 11, 17, 19]
	}
}
