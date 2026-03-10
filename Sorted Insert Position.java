public class Solution {
    public int searchInsert(int[] A, int B) {
        int n = A.length;
        int low = 0;
        int high = n - 1;
        
        // Initialize ans to n because if B is greater than all elements,
        // it should be inserted at the very end.
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A[mid] == B) {
                // Found the exact value
                return mid;
            } else if (A[mid] < B) {
                // Target is in the right half
                low = mid + 1;
            } else {
                // Current element is greater than B. 
                // This could be our insertion point, but let's look left for a smaller one.
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }
}
