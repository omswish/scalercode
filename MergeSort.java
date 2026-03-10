public class Solution {
    public int[] solve(int[] A) {
        mergeSort(A, 0, A.length - 1);
        return A;
    }

    private void mergeSort(int[] A, int left, int right) {
        if (left < right) {
            // Find the midpoint to split the array
            int mid = left + (right - left) / 2;

            // Recursively sort the first and second halves
            mergeSort(A, left, mid);
            mergeSort(A, mid + 1, right);

            // Merge the sorted halves
            merge(A, left, mid, right);
        }
    }

    private void merge(int[] A, int left, int mid, int right) {
        // Sizes of two sub-arrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) L[i] = A[left + i];
        for (int j = 0; j < n2; ++j) R[j] = A[mid + 1 + j];

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarray array
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }
}
