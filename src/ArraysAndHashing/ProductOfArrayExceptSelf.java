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
}
