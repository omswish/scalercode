public class Solution {
    public int solve(TreeNode root) {
        if (root == null) return 0;
        
        int sum = 0;
        
        // If left child exists and is a leaf → add it
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        
        // Always recurse on both subtrees
        sum += solve(root.left);
        sum += solve(root.right);
        
        return sum;
    }
}
