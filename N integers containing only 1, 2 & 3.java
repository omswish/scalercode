import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solve(int A) {
        int[] result = new int[A];
        Queue<Integer> q = new LinkedList<>();

        // Base cases: the first three numbers
        q.add(1);
        q.add(2);
        q.add(3);

        int count = 0;
        while (count < A) {
            // Get the smallest current number
            int current = q.poll();
            result[count] = current;
            count++;

            // If we still need more numbers, generate the next three
            // based on the current number. 
            // We check count + q.size() to avoid unnecessary additions 
            // once we've reached the limit A.
            if (count + q.size() < A + 3) {
                q.add(current * 10 + 1);
                q.add(current * 10 + 2);
                q.add(current * 10 + 3);
            }
        }

        return result;
    }
}
