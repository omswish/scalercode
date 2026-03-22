import java.util.Stack;

public class Solution {
    public int[] nextGreater(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements that are not greater than the current element
            while (!stack.isEmpty() && stack.peek() <= A[i]) {
                stack.pop();
            }

            // If stack is empty, no greater element exists to the right
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                // The top of the stack is the nearest greater element
                result[i] = stack.peek();
            }

            // Push the current element onto the stack for elements to the left
            stack.push(A[i]);
        }

        return result;
    }
}
