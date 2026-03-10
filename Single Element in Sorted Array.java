public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        if (n == 1) return A[0];
        
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the single element
            boolean leftDiff = (mid == 0) || (A[mid] != A[mid - 1]);
            boolean rightDiff = (mid == n - 1) || (A[mid] != A[mid + 1]);

            if (leftDiff && rightDiff) {
                return A[mid];
            }

            // Find the index of the first occurrence of the pair
            int firstIdx;
            if (mid > 0 && A[mid] == A[mid - 1]) {
                firstIdx = mid - 1;
            } else {
                firstIdx = mid;
            }

            // If first occurrence is at an even index, the single element is further right
            if (firstIdx % 2 == 0) {
                low = mid + 1;
            } else {
                // Otherwise, it's to the left
                high = mid - 1;
            }
        }
        return -1;
    }
}
