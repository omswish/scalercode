public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int peak = findBitonicPoint(A);

        // Try searching in the increasing part
        int res1 = binarySearch(A, 0, peak, B, true);
        if (res1 != -1) return res1;

        // Try searching in the decreasing part
        return binarySearch(A, peak + 1, n - 1, B, false);
    }

    private int findBitonicPoint(int[] A) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if mid is the peak
            boolean leftSmaller = (mid == 0) || (A[mid] > A[mid - 1]);
            boolean rightSmaller = (mid == A.length - 1) || (A[mid] > A[mid + 1]);

            if (leftSmaller && rightSmaller) return mid;

            if (mid > 0 && A[mid] < A[mid - 1]) {
                high = mid - 1; // Peak is to the left
            } else {
                low = mid + 1;  // Peak is to the right
            }
        }
        return 0;
    }

    private int binarySearch(int[] A, int low, int high, int B, boolean isAscending) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == B) return mid;

            if (isAscending) {
                if (A[mid] < B) low = mid + 1;
                else high = mid - 1;
            } else {
                // Logic reversed for descending part
                if (A[mid] < B) high = mid - 1;
                else low = mid + 1;
            }
        }
        return -1;
    }
}
