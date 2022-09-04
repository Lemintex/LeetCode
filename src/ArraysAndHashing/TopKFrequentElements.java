package ArraysAndHashing;

import java.util.*;
import java.util.Map.Entry;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        // create array used for storing k frequent
        int[] kFrequent = new int[k];

        // hashmap for storing occurrences of elements
        // K = element
        // V = occurrence count of that element
        HashMap<Integer, Integer> map = new HashMap<>();

        //for each element in array, count its occurrence
        for (int n: nums) {
            int occurrences = map.getOrDefault(n, 0);
            map.put(n, occurrences + 1);
        }
        List<Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());

        // sort the list by cecreasing order of occurrences
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // add k most common occurrences to array
        for (int i = 0; i < k; i++) {
            kFrequent[i] = list.get(i).getKey();
        }
        return kFrequent;
    }
}
