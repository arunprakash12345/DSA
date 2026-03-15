// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any 
// subarray is minimized.
// Return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.
// Example 1:
// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
public class LC410 {
    public boolean isPossible(int nums[], int k, int mid) {
        int count = 1;
        int pages = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if ((pages + nums[i]) <= mid) {

            } else {
                count++;
                pages = 0;
            }
            pages = pages + nums[i];
        }
        return count <= k;
    }

    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        int ans = -1;
        for (int i : nums) {
            low = Math.max(low, i);
            high += i;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }
}
