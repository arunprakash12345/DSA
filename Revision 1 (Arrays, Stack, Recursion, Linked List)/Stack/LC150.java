
// You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

// Evaluate the expression. Return an integer that represents the value of the expression.

// Note that:

// The valid operators are '+', '-', '*', and '/'.
// Each operand may be an integer or another expression.
// The division between two integers always truncates toward zero.
// There will not be any division by zero.
// The input represents a valid arithmetic expression in a reverse polish notation.
// The answer and all the intermediate calculations can be represented in a 32-bit integer.
// Input: tokens = ["2","1","+","3","*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9

import java.util.Stack;

public class LC150 {
    public int evalRPN(String[] A) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            String temp = A[i];
            if (temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")) {
                int val1 = st.pop();
                int val2 = st.pop();
                if (temp == "+")
                    st.push(val1 + val2);
                else if (temp == "-")
                    st.push(val1 - val2);
                else if (temp == "*")
                    st.push(val1 * val2);
                else if (temp == "/")
                    st.push(val1 / val2);
            } else {
                st.push(Integer.parseInt((temp)));
            }
        }
        return st.peek();
    }
}
