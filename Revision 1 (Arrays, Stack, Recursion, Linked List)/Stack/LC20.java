// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
// Input: s = "()"
// Output: true

import java.util.Stack;

public class LC20 {
    Stack<Character> st = new Stack<>();

    public boolean check(char ch) {
        if (st.isEmpty())
            return false;
        else if (ch == ')' && st.peek() == '(') {
            return true;
        } else if (ch == ']' && st.peek() == '[')
            return true;
        else if (ch == '}' && st.peek() == '{')
            return true;
        else {
            return false;
        }

    }

    public boolean isValid(String s) {

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (check(ch))
                    st.pop();
                else
                    return false;
            }
        }
        return st.isEmpty();
    }
}
