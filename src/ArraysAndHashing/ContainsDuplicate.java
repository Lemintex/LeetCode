package ArraysAndHashing;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {

    }

    // this is very slow (0n^2) but very memory efficient(O1)
    // for very big arrays this would take ages, so a faster solution would be better
    boolean ContainsDuplicateSlow(int[] nums)
    {
        for(int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    // this is faster (On) but less memory efficient(On)
    boolean ContainsDuplicateImproved(int[] nums)
    {
        HashSet<Integer> occurred = new HashSet<>();
        for (int i : nums)
        {
            if(occurred.contains(i)) return true;
            occurred.add(i);

            // could also use .add to check occurred, as it returns false if the value is already in the set
        }
        return false;
    }
}
