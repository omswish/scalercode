import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public int[] inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return new int[0];
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            // Go as left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // Process the node
            curr = stack.pop();
            result.add(curr.val);
            
            // Move to right subtree
            curr = curr.right;
        }
        
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
