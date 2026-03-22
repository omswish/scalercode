import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] A) {
        int n = A.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Step 1: Find Nearest Smaller Element to the Left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            leftSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear(); // Reuse the stack

        // Step 2: Find Nearest Smaller Element to the Right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            rightSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Step 3: Calculate max area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightSmaller[i] - leftSmaller[i] - 1;
            int area = A[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
