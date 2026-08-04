package Strings;

// Input: num = "52"

// Output: "5"
// Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
// Input: num = "4206"
// Output: ""
// Explanation: There are no odd substrings, so the empty string is returned.
// Input: num = "35427"
// Output: "35427"
// Explanation: "35427" is an odd number.

public class LC1903 {
    public String largestOddNumber(String num) {
        int index = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            char ch = num.charAt(i);
            int temp = ch - '0';
            if (temp % 2 == 1) {
                index = i;
                break;
            }
        }
        if (index == -1)
            return "";
        return num.substring(0, index + 1);
    }
}
