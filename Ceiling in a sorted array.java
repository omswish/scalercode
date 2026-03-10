public class Solution {
    public int solve(int A, int[] B, int C) {
        int low = 0;
        int high = A - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (B[mid] == C) {
                // Exact match found, it's the smallest element >= C
                return B[mid];
            } else if (B[mid] > C) {
                // Potential ceiling found
                ans = B[mid];
                // Try to find a smaller ceiling on the left
                high = mid - 1;
            } else {
                // Element is too small, look to the right
                low = mid + 1;
            }
        }

        return ans;
    }
}
