package Strings;

import java.util.ArrayList;

public class LC151 {
    // Input: s = "the sky is blue"
    // Output: "blue is sky the"
    public String reversedString(String s) {
        String result = "";
        ArrayList<String> st = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ' && temp.length() != 0) {
                st.add(temp);
                temp = "";
            } else if (ch == ' ')
                continue;
            else
                temp += ch + "";
        }
        if (temp.length() != 0)
            st.add(temp);

        for (int i = st.size() - 1; i >= 0; i--) {
            if (i != 0)
                result += st.get(i) + " ";
            else
                result += st.get(i);
        }
        return result;
    }
}
