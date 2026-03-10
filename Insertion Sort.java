public class Solution {
    public int[] solve(int[] A) {
        if (A == null || A.length <= 1) {
            return A;
        }
        
        insertionSortRecursive(A, A.length);
        return A;
    }

    private void insertionSortRecursive(int[] A, int n) {
        // Base case
        if (n <= 1) {
            return;
        }

        // Sort first n-1 elements
        insertionSortRecursive(A, n - 1);

        // Insert the last element at its correct position in sorted array
        int last = A[n - 1];
        int j = n - 2;

        /* Move elements of A[0..i-1], that are
           greater than key, to one position ahead
           of their current position */
        while (j >= 0 && A[j] > last) {
            A[j + 1] = A[j];
            j--;
        }
        A[j + 1] = last;
    }
}
