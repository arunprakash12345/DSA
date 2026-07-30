class SQRT {
    public static void main(String[] args) {
        int num = 28;
        int low = 1, high = num;
        int ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid <= num) {
                ans = (int) mid;
                low = (int) mid + 1;
            } else
                high = (int) mid - 1;
        }
        System.out.print(ans);
    }
}