import java.util.*;

public class Solution {
    public int[][] threeSum(int[] A) {
        int n = A.length;
        if (n < 3) return new int[0][0];

        // 1. Sort the array
        Arrays.sort(A);
        List<int[]> resultList = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && A[i] == A[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;
            int target = -A[i];

            while (left < right) {
                int currentSum = A[left] + A[right];

                if (currentSum == target) {
                    resultList.add(new int[]{A[i], A[left], A[right]});

                    // Skip duplicate values for second and third elements
                    while (left < right && A[left] == A[left + 1]) left++;
                    while (left < right && A[right] == A[right - 1]) right--;

                    left++;
                    right--;
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        // Convert List<int[]> to int[][]
        return resultList.toArray(new int[resultList.size()][]);
    }
}
