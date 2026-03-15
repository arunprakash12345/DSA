// Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, 
// divide all the array by it, and sum the division's result. Find the smallest divisor such that the 
// result mentioned above is less than or equal to threshold.
// Each result of the division is rounded to the nearest integer greater than or equal to that element. 
// (For example: 7/3 = 3 and 10/2 = 5).
// The test cases are generated so that there will be an answer.
// Input: nums = [1,2,5,9], threshold = 6
// Output: 5
// Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
// If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).

public class LC1283 {
    public boolean isPossible(int[] nums, int threshold, int mid) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += Math.ceil((nums[i] + mid - 1) / mid);
        }
        return total <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = nums[0];
        int result = -1;
        for (int i : nums)
            high = Math.max(high, i);

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(nums, threshold, mid)) {
                result = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return result;
    }
}
