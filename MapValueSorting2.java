package bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class MapValueSorting {
	public static void main(String[] args) {
		MapValueSorting solution = new MapValueSorting();
		Map<Integer, List<Integer>> unsortedMap = new HashMap<>();
		unsortedMap.put(1, Arrays.asList(1));
		unsortedMap.put(2, Arrays.asList(1, 2));
		unsortedMap.put(3, Arrays.asList(1, 2, 3));
		unsortedMap.put(4, Arrays.asList(1, 2, 3, 4));
		unsortedMap.put(5, Arrays.asList(1, 2, 3, 4, 5));
		unsortedMap.put(6, Arrays.asList(1, 2, 3, 4, 5, 6));
		unsortedMap.put(7, Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		
		// There is no direct way to sort HashMap by values but you can do this by writing
		// your own comparator, which takes Map.Entry object and arrange them in ASC/DESC order.
		
		Comparator<Entry<Integer, List<Integer>>> valueComparatorASC =
				new Comparator<Entry<Integer, List<Integer>>>() {
				@Override
				public int compare(Entry<Integer, List<Integer>> e1, Entry<Integer, List<Integer>> e2) {
					Integer v1 = e1.getValue().size();
					Integer v2 = e2.getValue().size();
					return v1.compareTo(v2);
				}
			};
			
			Comparator<Entry<Integer, List<Integer>>> valueComparatorDESC =
					new Comparator<Entry<Integer, List<Integer>>>() {
					@Override
					public int compare(Entry<Integer, List<Integer>> e1, Entry<Integer, List<Integer>> e2) {
						Integer v1 = e1.getValue().size();
						Integer v2 = e2.getValue().size();
						return v2.compareTo(v1);
					}
				};

		solution.sortMapByValue(unsortedMap, valueComparatorASC);
		System.out.println("\n\n\n");
		solution.sortMapByValue(unsortedMap, valueComparatorDESC);
		
		System.out.println("\n\n\n");
		solution.sortMapByValue2(unsortedMap, valueComparatorASC);
		System.out.println("\n\n\n");
		solution.sortMapByValue2(unsortedMap, valueComparatorDESC);
	}

	private void sortMapByValue(
		Map<Integer, List<Integer>> unsortedMap,
		Comparator<Entry<Integer, List<Integer>>> valueComparator) {	
		// Sort method needs a List, so let's first convert Set to List in Java
		Set<Entry<Integer, List<Integer>>> entries = unsortedMap.entrySet();
		List<Entry<Integer, List<Integer>>> listOfEntries =
			new ArrayList<Entry<Integer, List<Integer>>>(entries);

		// sorting HashMap by values using comparator
		Collections.sort(listOfEntries, valueComparator);
		
		// Create a LinkedHashMap by adding entries in sorted order.
		LinkedHashMap<Integer, List<Integer>> sortedMap = 
			new LinkedHashMap<Integer, List<Integer>>();
		
		// copying entries from List to Map
		for (Entry<Integer, List<Integer>> entry : listOfEntries) {
			System.out.println(entry.getKey() + " ==> " + entry.getValue());
			sortedMap.put(entry.getKey(), entry.getValue());
		}
	}
	
	private void sortMapByValue2(Map<Integer, List<Integer>> unsortedMap,
			Comparator<Entry<Integer, List<Integer>>> valueComparator) {
		LinkedHashMap<Integer, List<Integer>> sortedMap =
			unsortedMap.entrySet().stream()
				.sorted(valueComparator)
				.collect(
					Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));
		
		for (Entry<Integer, List<Integer>> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() + " ==> " + entry.getValue());
		}
	}
}
