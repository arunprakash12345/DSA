class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int high = (n * m) - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int i = mid / m;
            int j = mid % m;
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}
