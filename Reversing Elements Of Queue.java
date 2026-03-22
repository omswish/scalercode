
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public int[] solve(int[] A, int B) {
        if (B <= 1) return A;
        
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push first B elements into the Queue
        for (int i = 0; i < B; i++) {
            queue.add(A[i]);
        }

        // Step 2: Move from Queue to Stack (reverses order)
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Step 3: Move back from Stack to Queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Step 4: Put the reversed elements back into the original array
        for (int i = 0; i < B; i++) {
            A[i] = queue.poll();
        }

        return A;
    }
}
