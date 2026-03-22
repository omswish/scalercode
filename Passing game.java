import java.util.Stack;

public class Solution {
    public int solve(int A, int B, int[] C) {
        Stack<Integer> stack = new Stack<>();
        
        // The first player starts with the ball
        stack.push(B);

        for (int i = 0; i < A; i++) {
            int currentPass = C[i];
            
            if (currentPass == 0) {
                // Back Pass: remove the current player to 
                // reveal the previous one
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Forward Pass: add the new player to the 
                // top of the possession history
                stack.push(currentPass);
            }
        }

        // The player at the top of the stack has the ball
        return stack.peek();
    }
}
