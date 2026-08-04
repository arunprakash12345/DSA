package Strings;

/**
 * Remove Outermost Parentheses
 * 
 * A valid parentheses string is either empty, "()", or AB (A concatenated with
 * B), where A and B are
 * valid parentheses strings.
 * 
 * A parentheses string S is primitive if it is non-empty, and there does not
 * exist a way to split it into S = A
 * + B, with A and B nonempty valid parentheses strings.
 * 
 * Given a valid parentheses string S, consider its primitive decomposition: S =
 * P_1 + P_2 + ... + P_k, where P_i
 * are primitive valid parentheses strings.
 * 
 * Return S after removing the outermost parentheses of every primitive string
 * in the primitive
 * decomposition of S.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation: The input string is "(()())(())(()(()))".
 * Primitive decomposition = "(()())" + "(())" + "(()(()))".
 * Remove outermost parentheses of each primitive. Result: "()()" + "()" +
 * "()(())" = "()()()()(())".
 * Example 2:
 * 
 * Input: s = "(()())(())"
 * Output: "()()()"
 * Explanation: The input string is "(()())(())".
 * Primitive decomposition = "(()())" + "(())".
 * Remove outermost parentheses of each primitive. Result: "()()" + "()" =
 * "()()()".
 * Example 3:
 * 
 * Input: s = "()()"
 * Output: ""
 * Explanation: The input string is "()()".
 * Primitive decomposition = "()" + "()".
 * Remove outermost parentheses of each primitive. Result: "" + "" = "".
 * 
 * Constraints:
 * 1 <= s.length <= 10^5
 * s[i] is either '(' or ')'.
 * s is a valid parentheses string.
 */
public class LC1021 {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (open > 0) {
                    result.append(ch);
                }
                open++;
            } else {
                open--;
                if (open > 0) {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}