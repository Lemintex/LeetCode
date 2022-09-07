package ArraysAndHashing;

// Given an integer array nums, return an array such that each index is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.
public class ProductOfArrayExceptSelf {
    // each number can be split into: num[i] = productOfEverythingBefore * productOfEverythingAfter so if these can be calculated we solve the problem
    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        int[] postfix = new int[nums.length];
        postfix[postfix.length-1] = 1;

        // calculates prefix and postfix for evey index
        for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
            postfix[j] = postfix[j + 1] * nums[j + 1];
        }

        // calculates products (except self) for every number
        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefix[i] * postfix[i];
        }
        return nums;
    }

    // essentially the same as the previous solution, but replaces an array with an extra loop to calculate the postfixes seperately
    public static int[] productExceptSelfImproved(int[] nums) {
        // stores the results to return
        int[] results = new int[nums.length];

        // tracks the prefix being calculated
        int prefix = 1;

        // store the prefix calculated thus far in results[i] and calculate the prefix for the next number
        for (int i = 0; i < nums.length; i++) {
            results[i] = prefix;
            prefix *= nums[i];
        }

        // tracks the postfix being calculated
        int postfix = 1;

        // multiply the stored prefix by the calculated postfix and calculate the postfix for the next (previous in terms of index) number
        for (int i = nums.length - 1; i >= 0; i--) {
            results[i] *= postfix;
            postfix *= nums[i];
        }
        return results;
    }
}

/*
    5 6 7 8
pre 1
 */