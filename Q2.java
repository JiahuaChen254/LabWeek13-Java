import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import heap.BinaryHeap;

// Given an unordered list of Doubles as input, produce a sorted list of the top-k Doubles as output.  
// Use a Min Heap ("Min" is not a typo -- figure out why) to maintain the top-k results of n doubles in O(n log k) time and O(k) 
// space (not counting the space for the input array of n numbers).
public class Q2 {
	
	public static List<Double> GetTopkSlow(ArrayList<Double> input_list, int k){
		
		// 1. in the worst case i.e., in O(nlogn), you should be writing code that
		// makes use of existing sort algorithm on Collection data structure
		ArrayList<Double> output_list = new ArrayList<Double>(input_list);
		
		// 2. sort output_list Collection.sort( ... **in correct order**) "divides in two"=log(n) times "depth=n"
		Collections.sort(output_list); 
		while (output_list.size() > k) {
			output_list.remove(0);
		}
		
		// 3. return the sorted list! But you can do better!
		return output_list;
	}
	
/*	public static List<Double> GetTopKSlow(ArrayList<Double> in, int k){
		ArrayList<Double> res = new ArrayList<Double>(in);
		Collections.sort(res, Collections.reverseOrder()); // O(nlogn)
		return new ArrayList<Double>(res.subList(0, k));
	}
*/	
	
	public static List<Double> GetTopkFast(ArrayList<Double> input_list, int k){
		
		// 1. use the fact that with the correct data structure, you only need to compare
		// the new element with your data structure that stores the top-k data structure in 
		// constant time O(1)=hashmap
		// 2. keep updating your data structure until all the elements are considered.
		// 3. return the data structure that stores top-k elements.
		
		BinaryHeap<Double> bh = new BinaryHeap<Double>();
		List<Double> list = new ArrayList<Double>();
		for (int i = 0; i < k; i++) {
			bh.add(input_list.get(i));
		}
		for (int i = k; i < input_list.size(); i++) {
			bh.add(input_list.get(i));
			bh.remove();
		}
		while (!bh.isEmpty()) {
			list.add((Double) bh.remove());
		}
		return list;
	}
	
	public static void main(String[] args) {
		ArrayList<Double> list_a = new ArrayList<Double>(Arrays.asList(1.0,3.0,9.0,17.0,19.0));
		ArrayList<Double> list_b = new ArrayList<Double>(Arrays.asList(1.0,99.0,2.0,37.0,3.0,9.0,17.0,19.0,100.0));	
		System.out.println(list_a); // [1.0, 3.0, 9.0, 17.0, 19.0]
		System.out.println(list_b); // [1.0, 99.0, 2.0, 37.0, 3.0, 9.0, 17.0, 19.0, 100.0]
		System.out.println(GetTopkSlow(list_a, 2)); // [17.0, 19.0]
		System.out.println(GetTopkFast(list_a, 2)); // [17.0, 19.0]
		System.out.println(GetTopkFast(list_b, 3)); // [37.0, 99.0, 100.0] // soln [100.0, 99.0, 37.0]
	}

}
