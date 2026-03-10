public class Solution {
    public int[] solve(int[] A) {
        if (A == null || A.length <= 1) return A;
        
        quickSort(A, 0, A.length - 1);
        return A;
    }

    private void quickSort(int[] A, int low, int high) {
        if (low < high) {
            // pi is partitioning index, A[pi] is now at right place
            int pi = partition(A, low, high);

            // Recursively sort elements before and after partition
            quickSort(A, low, pi - 1);
            quickSort(A, pi + 1, high);
        }
    }

    private int partition(int[] A, int low, int high) {
        // Choosing the last element as the pivot
        int pivot = A[high];
        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (A[j] <= pivot) {
                i++;
                // Swap A[i] and A[j]
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        // Swap A[i+1] and pivot (A[high])
        int temp = A[i + 1];
        A[i + 1] = A[high];
        A[high] = temp;

        return i + 1;
    }
}
