public class kokoEating {
    public boolean isPossible(int mid, int[] piles, int h) {
        long temp = 0;
        for (int i = 0; i < piles.length; i++) {
            temp += (long) Math.ceil((double) piles[i] / mid);
        }
        return temp <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length > h)
            return 0;
        int low = 1;
        int high = 0;
        for (int i = 0; i < piles.length; i++) {
            if (high < piles[i])
                high = piles[i];
        }
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(mid, piles, h)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        kokoEating k = new kokoEating();
        System.out.print(k.minEatingSpeed(piles, h));
    }
}
