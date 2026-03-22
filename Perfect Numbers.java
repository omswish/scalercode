import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public String solve(int A) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");

        String firstHalf = "";
        int count = 0;

        while (!q.isEmpty()) {
            String current = q.poll();
            count++;

            if (count == A) {
                firstHalf = current;
                break;
            }

            // Generate next potential first halves
            q.add(current + "1");
            q.add(current + "2");
        }

        // Build the full palindrome: firstHalf + reverse(firstHalf)
        StringBuilder sb = new StringBuilder(firstHalf);
        String secondHalf = sb.reverse().toString();
        
        return firstHalf + secondHalf;
    }
}
