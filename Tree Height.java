/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) {
 * val = x;
 * left=null;
 * right=null;
 * }
 * }
 */
public class Solution {
    public int solve(TreeNode A) {
        // Base case: An empty tree has height 0
        if (A == null) {
            return 0;
        }

        // Recursively find the height of left and right subtrees
        int leftHeight = solve(A.left);
        int rightHeight = solve(A.right);

        // The height of the current node is 1 plus the maximum of its children's heights
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
