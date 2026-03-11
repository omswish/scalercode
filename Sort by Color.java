public class Solution {
    public int[] sortColors(int[] A) {
        int low = 0;
        int mid = 0;
        int high = A.length - 1;

        while (mid <= high) {
            if (A[mid] == 0) {
                // Swap A[mid] with A[low]
                int temp = A[low];
                A[low] = A[mid];
                A[mid] = temp;
                
                low++;
                mid++;
            } else if (A[mid] == 1) {
                // Already in middle section
                mid++;
            } else { // A[mid] == 2
                // Swap A[mid] with A[high]
                int temp = A[high];
                A[high] = A[mid];
                A[mid] = temp;
                
                // We don't increment mid here because the new element 
                // swapped from high needs to be evaluated
                high--;
            }
        }
        return A;
    }
}
