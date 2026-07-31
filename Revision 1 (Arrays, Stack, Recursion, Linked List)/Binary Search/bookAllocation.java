public class bookAllocation {
    public static boolean isPossible(int arr[], int mid, int k) {
        int count = 1;
        int page = 0;
        for (int i = 0; i < arr.length; i++) {
            if (page + arr[i] <= mid) {
                page = page + arr[i];

            } else {
                count++;
                page = arr[i];
            }
        }
        return count <= k;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 34, 67, 90 };
        int m = 2;
        int low = Integer.MIN_VALUE;
        int high = 0;
        int ans = -1;
        for (int i : arr) {
            low = Math.max(low, i);
            high += i;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        System.out.println(ans);

    }
}
