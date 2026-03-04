// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2

import java.util.*;

public class LC560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k)
                count++;

            int rem = sum - k;
            if (map.containsKey(rem)) {
                count += map.get(rem);

            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}

// Reason choosed for this approach
// Since the array can contain negative numbers, sliding window won't work.
// So I use prefix sum and a hashmap to store frequencies of prefix sums.
// At each index, if (currentSum - k) exists in the map, it means there is a
// previous prefix sum that forms a subarray ending here with sum k.
// I add its frequency to the count and then update the current prefix sum
// frequency in the map.