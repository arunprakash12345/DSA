// Given an integer array nums, find the subarray with the largest sum, and return its sum.
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

public class LC53 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
}

// Complexities
// Time - o(n)
// Space - o(1)

// Method used
// I have used Kadan's algo for solving this problem. I iterate over the array
// if the total sum is less than 0 there is no use of keeping track of max right
// so making it start from first so that the upcoming subarray does not affect