package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
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
}
