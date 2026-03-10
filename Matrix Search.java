public class Solution {
    public int searchMatrix(int[][] A, int B) {
        int n = A.length;
        if (n == 0) return 0;
        int m = A[0].length;

        int low = 0;
        int high = (n * m) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Map 1D index back to 2D coordinates
            int row = mid / m;
            int col = mid % m;
            
            int element = A[row][col];

            if (element == B) {
                return 1;
            } else if (element < B) {
                // Search in the right half
                low = mid + 1;
            } else {
                // Search in the left half
                high = mid - 1;
            }
        }

        return 0;
    }
}
