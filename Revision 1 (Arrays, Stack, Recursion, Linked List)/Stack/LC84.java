
// Given an array of integers heights representing the histogram's bar height 
// where the width of each bar is 1, return the area of the largest rectangle in the histogram.
import java.util.*;

public class LC84 {
    public int[] nextSmaller(int[] heights) {
        int n = heights.length;
        int nse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();

            if (st.isEmpty())
                nse[i] = n;
            else
                nse[i] = st.peek();

            st.push(i);
        }
        return nse;
    }

    public int[] previousSmaller(int[] heights) {
        int n = heights.length;
        int pse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();

            if (st.isEmpty())
                pse[i] = -1;
            else
                pse[i] = st.peek();

            st.push(i);
        }
        return pse;
    }

    public int largestRectangleArea(int[] heights) {
        int result = 0;
        int nse[] = nextSmaller(heights);
        int pse[] = previousSmaller(heights);

        for (int i = 0; i < heights.length; i++) {
            int width = nse[i] - pse[i] - 1;
            result = Math.max(result, width * heights[i]);
        }
        return result;
    }
}
