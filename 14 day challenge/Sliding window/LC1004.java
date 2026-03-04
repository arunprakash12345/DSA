// Given a binary array nums and an integer k, return the maximum number of consecutive 1's 
// in the array if you can flip at most k 0's.
// Example 1:
// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

import java.util.*;

public class LC1004 {
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int left = 0;
            int result = 0;
            int zeroCount = 0;

            for (int right = 0; right < nums.length; right++) {
                if (nums[right] == 0)
                    zeroCount++;
                while (zeroCount > k) {
                    if (nums[left] == 0)
                        zeroCount--;
                    left++;
                }

                result = Math.max(result, right - left + 1);
            }
            return result;
        }
    }
}

// Complexities
// time o(n) where n is the length of the string
// o(1)

// Mistake i did
// using if for zeroCount>k and also thought of moving the left pointer to right
// pointer and then move it but
// actual case is move the right pointer without stopping but increament the
// left as well until unless the zerCount should be less than k
