public class makingBoquet {
    public boolean isPossible(int bloomDay[], int m, int k, int mid) {
        int flowers = 0;
        int boq = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                flowers++;
                if (flowers == k) {
                    boq++;
                    flowers = 0;
                }
            } else
                flowers = 0;
        }
        return boq >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int low = bloomDay[0];
        int high = bloomDay[0];
        if (bloomDay.length < m * k)
            return -1;
        for (int bloom : bloomDay) {
            low = Math.min(low, bloom);
            high = Math.max(high, bloom);
        }
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(bloomDay, m, k, mid)) {
                result = mid;
                high = mid - 1;
            } else
                low = mid + 1;

        }
        return result;
    }

    public static void main(String[] args) {
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3, k = 1;
        makingBoquet mb = new makingBoquet();
        System.out.print(mb.minDays(bloomDay, m, k));
    }
}
