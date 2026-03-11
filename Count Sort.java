public class Solution {
    public int[] solve(int[] A) {
        if (A == null || A.length <= 1) return A;

        // 1. Find the maximum value in A to define the range
        int max = A[0];
        for (int num : A) {
            if (num > max) max = num;
        }

        // 2. Create frequency array (size max + 1 to include the max value)
        int[] count = new int[max + 1];
        for (int num : A) {
            count[num]++;
        }

        // 3. Reconstruct the sorted array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                A[index++] = i;
                count[i]--;
            }
        }

        return A;
    }
}
