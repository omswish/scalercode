public class Solution {
    public int sqrt(int A) {
        // Base cases
        if (A == 0 || A == 1) return A;

        int low = 1, high = A;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Use long to prevent overflow during squaring
            long midSquared = (long) mid * mid;

            if (midSquared == A) {
                return mid;
            } else if (midSquared < A) {
                // mid could be the floor, store it and try larger
                ans = mid;
                low = mid + 1;
            } else {
                // mid is too big, look for smaller values
                high = mid - 1;
            }
        }

        return ans;
    }
}
