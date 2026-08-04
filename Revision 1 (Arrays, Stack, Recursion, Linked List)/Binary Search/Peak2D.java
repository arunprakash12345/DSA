public class Peak2D {
    class Solution {
        public int maxElement(int[][] arr, int mid) {
            int row = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][mid] > arr[row][mid])
                    row = i;
            }
            return row;
        }

        public int[] findPeakGrid(int[][] mat) {
            int m = mat[0].length;
            int low = 0;
            int high = m - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                int row = maxElement(mat, mid);
                int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
                int right = mid + 1 < m ? mat[row][mid + 1] : -1;

                if (mat[row][mid] > left && mat[row][mid] > right)
                    return new int[] { row, mid };
                else if (mat[row][mid] < left)
                    high = mid - 1;
                else
                    low = mid + 1;

            }
            return new int[] { -1, -1 };
        }
    }
}
