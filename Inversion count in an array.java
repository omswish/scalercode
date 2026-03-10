public class Solution {
    long totalInversions = 0;
    int MOD = 1000000007;

    public int solve(int[] A) {
        if (A == null || A.length < 2) return 0;
        
        mergeSort(A, 0, A.length - 1);
        return (int) (totalInversions % MOD);
    }

    private void mergeSort(int[] A, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(A, left, mid);
            mergeSort(A, mid + 1, right);
            merge(A, left, mid, right);
        }
    }

    private void merge(int[] A, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = A[left + i];
        for (int j = 0; j < n2; j++) R[j] = A[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k++] = L[i++];
            } else {
                // Inversion found! 
                // All elements from L[i] to L[n1-1] are greater than R[j]
                totalInversions = (totalInversions + (n1 - i)) % MOD;
                A[k++] = R[j++];
            }
        }

        while (i < n1) A[k++] = L[i++];
        while (j < n2) A[k++] = R[j++];
    }
}
