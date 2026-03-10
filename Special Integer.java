public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int low = 1;
        int high = n;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(A, B, mid)) {
                ans = mid; // This K works, try a larger K
                low = mid + 1;
            } else {
                high = mid - 1; // Subarray sum exceeded B, try a smaller K
            }
        }

        return ans;
    }

    private boolean check(int[] A, int B, int K) {
        if (K == 0) return true;
        
        long currentSum = 0;

        // Sum of the first window
        for (int i = 0; i < K; i++) {
            currentSum += A[i];
        }

        if (currentSum > B) return false;

        // Slide the window across the rest of the array
        for (int i = K; i < A.length; i++) {
            currentSum += A[i] - A[i - K];
            if (currentSum > B) return false;
        }

        return true;
    }
}
