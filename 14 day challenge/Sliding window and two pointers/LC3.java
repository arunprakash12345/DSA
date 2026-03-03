// Given a string s, find the length of the longest substring without duplicate
// characters.
// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3. Note that "bca" and
// "cab" are also correct answers.

import java.util.*;;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;

            result = Math.max(result, right - left);
        }
        return result;
    }
}

// Complexities
// time o(n) where n is the length of the string
// o(k) where k is the length of the subtring atmost we are storing k length
// elements into the set

// Mistake i did
// in while loop i have entered like s.charAt(left)==s.charAt(right) but this
// does not working it will go to loop and then changed to
// set.contains(left) i want to remove.