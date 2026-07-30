public class capacityShip {
    public boolean isPossible(int weights[], int days, int mid) {
        int currLoad = 0;
        int daysCount = 1;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] + currLoad > mid) {
                currLoad = 0;
                daysCount++;
            }
            currLoad += weights[i];
        }
        return daysCount <= days;

    }

    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0];
        int high = 0;
        for (int i : weights) {
            low = Math.max(i, low);
            high += i;
        }
        int result = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(weights, days, mid)) {
                result = Math.min(result, mid);
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        capacityShip cs = new capacityShip();
        System.out.print(cs.shipWithinDays(weights, days));
    }
}
