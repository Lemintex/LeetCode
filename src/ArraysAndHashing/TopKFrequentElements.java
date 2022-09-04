package ArraysAndHashing;

import java.util.*;
import java.util.Map.Entry;

public class TopKFrequentElements {
    // this algorithm is slow as sorting of hashmap takes a while
    // (sorting could be avoided by using a heap/priority queue?)
    public static int[] topKFrequent(int[] nums, int k) {
        // create array used for storing k most frequent elements
        int[] kFrequent = new int[k];

        // hashmap for storing occurrences of elements
        // K = element
        // V = occurrence count of that element
        HashMap<Integer, Integer> map = new HashMap<>();

        //for each element in array, count its occurrences
        for (int n: nums) {
            int occurrences = map.getOrDefault(n, 0);
            map.put(n, occurrences + 1);
        }
        List<Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());

        // sort the list by decreasing order of occurrences
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

    // bucket sort algorithm is much faster  (On) and memory efficient (On) due to not requiring any sorting, just utilises data organising and fast hashmaps
    public static int[] topKFrequentImproved(int[] nums, int k) {
        // create array used for storing k most frequent elements
        int[] kFrequent = new int[k];

        // hashmap for storing occurrences of elements
        // K = element
        // V = occurrence count of that element
        HashMap<Integer, Integer> map = new HashMap<>();

        // for each element in array, count its occurrences
        for (int n: nums) {
            int occurrences = map.getOrDefault(n, 0);
            map.put(n, occurrences + 1);
        }
        // 'bucket' map
        // K = occurrences
        // V = List of all values with this occurrence
        HashMap<Integer, List<Integer>> bucket = new HashMap<>();

        // fill buckey with occurrences-list of elements
        for (Integer oldKey: map.keySet()) {
            Integer oldValue = map.get(oldKey);
            bucket.putIfAbsent(oldValue, new ArrayList<>());
            bucket.get(oldValue).add(oldKey);
        }
        int index = 0;
        // start at max possible frequency (nums.length) and decrement each iteration
        for (int count = nums.length; count > 0; count--) {
            // if this frequency is found
            if (bucket.containsKey(count)) {
                List<Integer> list = bucket.get(count);
                // add all elements at this frequency to the array
                for (Integer i: list) {
                    kFrequent[index++] = i;
                }
                if (index == k) return kFrequent;
            }
        }
        return kFrequent;
    }
}
