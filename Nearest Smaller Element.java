import java.util.Stack;

public class Solution {
    public int[] prevSmaller(int[] A) {
        int n = A.length;
        int[] G = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements that are not smaller than the current element
            while (!stack.isEmpty() && stack.peek() >= A[i]) {
                stack.pop();
            }

            // If stack is empty, no smaller element on the left
            if (stack.isEmpty()) {
                G[i] = -1;
            } else {
                // The top of the stack is the nearest smaller element
                G[i] = stack.peek();
            }

            // Push current element to be a candidate for the next elements
            stack.push(A[i]);
        }

        return G;
    }
}
