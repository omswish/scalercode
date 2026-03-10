public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int search(final int[] A, int B) {
        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A[mid] == B) {
                return mid;
            }

            // Case 1: Left half [low...mid] is sorted
            if (A[low] <= A[mid]) {
                // Check if B lies within the sorted left half
                if (B >= A[low] && B < A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            // Case 2: Right half [mid...high] is sorted
            else {
                // Check if B lies within the sorted right half
                if (B > A[mid] && B <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
