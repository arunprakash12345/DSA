// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
// Return the length of the longest substring containing the same letter you can get after performing the above operations.
// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.

public class LC424 {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int maxLen = 0;
        int result = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            maxLen = Math.max(maxLen, freq[ch - 'A']);
            while ((right - left + 1 - maxLen) > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}

// Complexities
// time o(n) where n is the length of the string
// o(26)
