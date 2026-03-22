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
        // Base case: If the node is null, it doesn't count as a node
        if (A == null) {
            return 0;
        }

        // Recursive step: 1 (current node) + count of left + count of right
        return 1 + solve(A.left) + solve(A.right);
    }
}
