package bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ArraySorting {
	public static void main(String[] args) {
		ArraySorting solution = new ArraySorting();
		ArrayList<Integer> arrive = new ArrayList<Integer>(Arrays.asList(new Integer[] {2, 6 , 5}));
		ArrayList<Integer>  depart = new ArrayList<Integer>(Arrays.asList(new Integer[] {5, 9 , 8}));
		
		solution.sortList(arrive, depart);
	}

	public void sortList(ArrayList<Integer> arrive, ArrayList<Integer> depart) {
		Map<Integer, Integer> keyLookup = new TreeMap<>();
		for (int i = 0; i < arrive.size(); i++) {
			keyLookup.put(arrive.get(i), depart.get(i));
		}
		arrive.clear();
		depart.clear();
		arrive.addAll(keyLookup.keySet());
		depart.addAll(keyLookup.values());
		System.out.println("Arrive: " + arrive.toString());
		System.out.println("Depart: " + depart.toString());
	}
}
