
public class NthRoot {
    public static void main(String[] args) {
        int num = 69;
        int m = 4;
        int low = 1, high = num;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int temp = 1;
            for (int i = 0; i < m; i++) {
                temp = mid * temp;
                if (temp > num)
                    break;
            }
            if (temp == num) {
                ans = mid;
                break;
            } else if (temp > num)
                high = mid - 1;
            else
                low = mid + 1;
        }
        System.out.print(ans);
    }
}