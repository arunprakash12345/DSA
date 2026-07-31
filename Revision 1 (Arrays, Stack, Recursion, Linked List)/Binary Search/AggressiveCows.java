import java.util.*;

public class AggressiveCows {
    public static boolean isPossible(int arr[], int mid, int k) {
        int count = 1;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] - last) >= mid) {
                count++;
                last = arr[i];
            }
        }
        return count >= k;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 1, 3, 6 };
        Arrays.sort(arr);
        int k = 2;
        int low = 1;
        // Why max and min is if there two cows right we will place one at first index
        // and other at the last right to maximize then we just wanna max-min gives that
        // window that's why doing that
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int high = max - min;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, mid, k))
                low = mid + 1;
            else
                high = mid - 1;
        }
        System.out.print(high);
    }
}
