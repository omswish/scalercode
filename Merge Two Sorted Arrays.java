public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] solve(final int[] A, final int[] B) {
        int n = A.length;
        int m = B.length;
        int[] result = new int[n + m];
        
        int i = 0; // Pointer for A
        int j = 0; // Pointer for B
        int k = 0; // Pointer for result array
        
        // Traverse both arrays
        while (i < n && j < m) {
            if (A[i] <= B[j]) {
                result[k] = A[i];
                i++;
            } else {
                result[k] = B[j];
                j++;
            }
            k++;
        }
        
        // If elements are left in A, copy them
        while (i < n) {
            result[k] = A[i];
            i++;
            k++;
        }
        
        // If elements are left in B, copy them
        while (j < m) {
            result[k] = B[j];
            j++;
            k++;
        }
        
        return result;
    }
}
