import java.util.ArrayList;

public class Solution {
    public int[] postorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(A, list);
        
        // Convert ArrayList to primitive int array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void helper(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        helper(root.left, list);    // Traverse Left
        helper(root.right, list);   // Traverse Right
        list.add(root.val);         // Visit Root
    }
}
