// You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.

// The rules of a Unix-style file system are as follows:

// A single period '.' represents the current directory.
// A double period '..' represents the previous/parent directory.
// Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
// Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
// The simplified canonical path should follow these rules:

// The path must start with a single slash '/'.
// Directories within the path must be separated by exactly one slash '/'.
// The path must not end with a slash '/', unless it is the root directory.
// The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
// Return the simplified canonical path.
// Input: path = "/home/user/Documents/../Pictures"

// Output: "/home/user/Pictures"

// Explanation:

// A double period ".." refers to the directory up a level (the parent directory).

import java.util.Stack;

public class LC71 {
    public String simplifyPath(String path) {
        String temp[] = path.split("/");
        Stack<String> st = new Stack<>();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].length() == 0)
                continue;
            // char ch = temp[i].charAt(0);
            if (temp[i].equals("."))
                continue;
            else if (temp[i].equals("..")) {
                if (!st.isEmpty())
                    st.pop();
                else
                    continue;
            } else {
                st.push(temp[i]);
            }
        }
        StringBuilder result = new StringBuilder();
        if (st.isEmpty())
            return "/";
        for (String dir : st) {
            result.append("/");
            result.append(dir);
        }
        return result.toString();
    }
}
