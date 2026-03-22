import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        long mod = 1000000007;
        long totalSum = 0;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. Remove indices out of window
            if (!maxDeque.isEmpty() && maxDeque.peekFirst() <= i - B) maxDeque.pollFirst();
            if (!minDeque.isEmpty() && minDeque.peekFirst() <= i - B) minDeque.pollFirst();

            // 2. Maintain Max Deque (Descending)
            while (!maxDeque.isEmpty() && A[maxDeque.peekLast()] <= A[i]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(i);

            // 3. Maintain Min Deque (Ascending)
            while (!minDeque.isEmpty() && A[minDeque.peekLast()] >= A[i]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(i);

            // 4. Calculate sum once first window is complete
            if (i >= B - 1) {
                long windowMax = A[maxDeque.peekFirst()];
                long windowMin = A[minDeque.peekFirst()];
                totalSum = (totalSum + windowMax + windowMin) % mod;
            }
        }

        // Handle negative results for modulo
        return (int) ((totalSum + mod) % mod);
    }
}
