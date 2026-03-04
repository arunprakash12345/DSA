// Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such 
// that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] 
// where 1 <= index1 < index2 <= numbers.length.
// Return the indices of the two numbers index1 and index2, each incremented by one, 
// as an integer array [index1, index2] of length 2.
// The tests are generated such that there is exactly one solution. You may not use the same element twice.
// Your solution must use only constant extra space.

public class LC167 {
    public int[] twoSum(int[] numbers, int target) {
        int result[] = { -1, -1 };
        int n = numbers.length;
        int left = 0, sum = 0;
        int right = n - 1;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (sum > target) {
                sum -= numbers[right];
                right--;
            } else {
                sum -= numbers[left];
                left++;
            }
        }
        return result;
    }
}

// Complexities
// time o(n) where n is the length of the arr
// o(1)