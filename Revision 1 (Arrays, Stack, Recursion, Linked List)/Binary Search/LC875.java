// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
// The guards have gone and will come back in h hours.
// Koko can decide her bananas-per-hour eating speed of k. Each hour, 
// she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
// Return the minimum integer k such that she can eat all the bananas within h hours.
// Example 1:
// Input: piles = [3,6,7,11], h = 8
// Output: 4
// Example 2:
// Input: piles = [30,11,23,4,20], h = 5
// Output: 30

public class LC875 {
    public boolean isPossible(int[] piles, int h, int mid) {
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += (long) Math.ceil((double) piles[i] / mid);
        }
        System.out.print(hours + " " + mid + " ");
        return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length > h)
            return 0;
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i : piles)
            high = Math.max(i, high);

        int result = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(piles, h, mid)) {
                result = Math.min(mid, result);
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return result;
    }
}
