import java.util.Arrays;

public class Solution {
    public int solve(int[] A, int B) {
        // 1. Sort the stalls to process them linearly
        Arrays.sort(A);
        int n = A.length;

        // 2. Define search space for the "minimum distance"
        int low = 1;
        int high = A[n - 1] - A[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // 3. If it's possible to place B cows with at least 'mid' distance
            if (isPossible(A, B, mid)) {
                ans = mid;     // This distance works, try to find a larger one
                low = mid + 1;
            } else {
                high = mid - 1; // Distance is too large, reduce it
            }
        }
        return ans;
    }

    private boolean isPossible(int[] A, int cows, int minDist) {
        int count = 1; // Place the first cow in the first stall
        int lastPos = A[0];

        for (int i = 1; i < A.length; i++) {
            // If the current stall is far enough from the last placed cow
            if (A[i] - lastPos >= minDist) {
                count++;
                lastPos = A[i];
                
                // If all cows are placed, return true
                if (count >= cows) return true;
            }
        }
        return false;
    }
}
