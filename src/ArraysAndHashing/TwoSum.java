package ArraysAndHashing;

public class TwoSum {
    // this solution is more memory efficient (O1) but is slower (higher runtime complexity) (On^2)
        public int[] twoSum(int[] nums, int target) {
            for(int i = 0; i < nums.length - 1; i++) {
                for(int j = i + 1; j < nums.length; j++) {
                    if(nums[i] + nums[j] == target) return new int[] {i, j};
                }
            }
            return new int[] {0};
        }

// this solution is less memory efficient (On) but faster (lower runtime complexity) (On)

/*
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> compliments = new HashMap();
        for (int i = 0; i < nums.length; i++)
        {
            if(compliments.containsKey(target - nums[i]))
            {
                int[] ans = new int[2];
                ans[0] = compliments.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            compliments.put(nums[i], i);
        }
        int[] n = {0, 0};
        return n;
    }
}
*/
}
