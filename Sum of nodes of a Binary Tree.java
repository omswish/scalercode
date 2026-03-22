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
        // Base case: If the node is null, the sum is 0
        if (A == null) {
            return 0;
        }

        // Return current value + sum of left subtree + sum of right subtree
        return A.val + solve(A.left) + solve(A.right);
    }
}
