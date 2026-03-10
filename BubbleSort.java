public class Solution {
    public int[] bubbleSort(int[] A) {
        int n = A.length;
        
        // Outer loop for the number of passes
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            // Inner loop for adjacent comparisons
            // The last i elements are already in place
            for (int j = 0; j < n - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    // Swap A[j] and A[j+1]
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
        
        return A;
    }
}
