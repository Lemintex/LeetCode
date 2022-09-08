package ArraysAndHashing;

import java.util.HashSet;
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
public class LongestConsecutiveSequence {
    // this solution gets the length of every sequence possible
    // eg: [4, 5, 6] considers [4, 5, 6], [5, 6], and [6] as valid sequences
    public static int longestConsecutiveSequence(int[] nums) {
        // convert to array to hashset for speedy reading
        HashSet<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }

        int longest = 0;
        // for each value in the set
        for(Integer n: set) {
            int current = 1;
            Integer val = n;

            // count the consecutive values to the right
            while (set.contains(val + 1)) {
                val++;
                current++;
            }
            if (current > longest) longest = current;
        }
        return longest;
    }

    // this solution is improved as it doesn't check any sequences that don't start at the beginning of the sequence
    // eg: [4, 5, 6] doesn't consider [5, 6] or [6]
    public static int longestConsecutiveSequenceImproved(int[] nums) {
        // convert to array to hashset for speedy reading
        HashSet<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }

        int longest = 0;

        // for each value in the set
        for (Integer n: set) {

            //if the number is not the beginning of a set, skip it
            if (set.contains(n-1)) continue;
            int length = 1;
            int val = n + 1;

            // count the consecutive values to the right
            while(set.contains(val)) {
                length++;
                val++;
            }
            if (length > longest) longest = length;
        }
        return longest;
    }
}
