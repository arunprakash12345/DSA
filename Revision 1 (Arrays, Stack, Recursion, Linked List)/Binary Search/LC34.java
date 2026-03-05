// Given an array of integers nums sorted in non-decreasing order, 
// find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

class LC34 {
    public int firstOccurance(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (nums[mid] < target)
                low = mid + 1;

            else
                high = mid - 1;
        }
        return ans;

    }

    public int lastOccurance(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1;

            } else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return ans;

    }

    public int[] searchRange(int[] nums, int target) {
        int result[] = { -1, -1 };
        int first = firstOccurance(nums, target);
        int last = lastOccurance(nums, target);
        result[0] = first;
        result[1] = last;
        return result;
    }
}
