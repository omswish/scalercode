public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        
        // Handle single element array
        if (n == 1) return A[0];
        
        int low = 0;
        int high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if mid is the peak
            // We use boundary checks to avoid ArrayIndexOutOfBounds
            boolean leftSmaller = (mid == 0) || (A[mid] >= A[mid - 1]);
            boolean rightSmaller = (mid == n - 1) || (A[mid] >= A[mid + 1]);
            
            if (leftSmaller && rightSmaller) {
                return A[mid];
            }
            
            // If the left neighbor is greater, the peak is on the left
            if (mid > 0 && A[mid - 1] > A[mid]) {
                high = mid - 1;
            } 
            // Otherwise, the peak must be on the right
            else {
                low = mid + 1;
            }
        }
        
        return -1; // Should not reach here based on constraints
    }
}
