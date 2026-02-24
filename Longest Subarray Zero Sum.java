import java.util.HashMap;

public class Solution {
    public int solve(int[] A) {
        // Map to store (Prefix Sum, First Occurrence Index)
        HashMap<Long, Integer> map = new HashMap<>();
        long prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < A.length; i++) {
            prefixSum += A[i];

            if (prefixSum == 0) {
                // Subarray starts from index 0
                maxLen = Math.max(maxLen, i + 1);
            } else if (map.containsKey(prefixSum)) {
                // Subarray exists between previous occurrence and current index
                int prevIndex = map.get(prefixSum);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                // Only store the FIRST time we see a prefix sum to maximize length
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
