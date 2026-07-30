public class smallestDivisor {
    public boolean isPossible(int[] nums, int threshold, int mid) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += Math.ceil((nums[i] + mid - 1) / mid);
        }
        return total <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = nums[0];
        int result = -1;
        for (int i : nums)
            high = Math.max(high, i);

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(nums, threshold, mid)) {
                result = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 9 };
        int threshold = 6;
        smallestDivisor sd = new smallestDivisor();
        System.out.print(sd.smallestDivisor(nums, threshold));
    }
}
