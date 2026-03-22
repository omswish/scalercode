

import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    public int[] slidingMaximum(final int[] A, int B) {
        int n = A.length;
        // Handle case where B is larger than array length
        if (B > n) B = n;
        
        int[] result = new int[n - B + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() <= i - B) {
                deque.pollFirst();
            }

            // 2. Remove elements smaller than the current element from the back
            while (!deque.isEmpty() && A[deque.peekLast()] <= A[i]) {
                deque.pollLast();
            }

            // 3. Add current element's index
            deque.offerLast(i);

            // 4. If we've hit the window size, the front is our maximum
            if (i >= B - 1) {
                result[i - B + 1] = A[deque.peekFirst()];
            }
        }

        return result;
    }
}
