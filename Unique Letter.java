import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public String solve(String A) {
        StringBuilder result = new StringBuilder();
        int[] freq = new int[26]; // To store counts of 'a'-'z'
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            
            // 1. Update frequency and add to potential unique candidates
            freq[c - 'a']++;
            queue.add(c);

            // 2. Remove elements from the front that are no longer unique
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            // 3. The front of the queue is now the earliest unique character
            if (queue.isEmpty()) {
                result.append("#");
            } else {
                result.append(queue.peek());
            }
        }

        return result.toString();
    }
}
