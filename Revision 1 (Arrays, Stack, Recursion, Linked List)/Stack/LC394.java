
// Given an encoded string, return its decoded string.
// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
// You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
// The test cases are generated so that the length of the output will never exceed 105.
// Example 1:
// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"

import java.util.Stack;

public class LC394 {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> st = new Stack<>();
        int currentNum = 0;
        String prevString = "", currString = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');
            } else if (ch >= 'a' && ch <= 'z')
                currString += ch + "";
            else if (ch == '[') {
                count.push(currentNum);
                st.push(currString);
                currString = "";
                currentNum = 0;
            } else if (ch == ']') {
                int val = count.pop();
                prevString = st.pop();
                String temp = "";
                while (val > 0) {
                    temp += currString;
                    val--;
                }
                currString = prevString + temp;
            }
        }
        return currString;
    }
}
