import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solve(int[] A, int[] B) {
        Queue<Integer> queue = new LinkedList<>();
        int cycles = 0;

        // Populate the initial scheduler queue
        for (int task : A) {
            queue.add(task);
        }

        // Process each task in the required order from B
        for (int i = 0; i < B.length; i++) {
            int targetTask = B[i];

            // While the front of the queue is not the target task,
            // move the front task to the back (Rotate)
            while (queue.peek() != targetTask) {
                int rotatedTask = queue.poll();
                queue.add(rotatedTask);
                cycles++; // One cycle for moving to the back
            }

            // Once the front matches, perform the task
            queue.poll();
            cycles++; // One cycle for performing the task
        }

        return cycles;
    }
}
