import java.util.ArrayList;

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int totalMasks = 1 << n;

        for (int mask = 0; mask < totalMasks; mask++) {
            long sum = 0L;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += A.get(i);
                    // Optional pruning: since all A[i] >= 1, if sum exceeds B, we can skip
                    if (sum > B) break;
                }
            }
            if (sum == B) return 1;
        }
        return 0;
    }
}
