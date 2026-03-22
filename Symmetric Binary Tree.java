/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *         val = x;
 *         left = null;
 *         right = null;
 *     }
 * }
 */
public class Solution {
    public int isSymmetric(TreeNode A) {
        if (A == null) return 1;
        return isMirror(A.left, A.right) ? 1 : 0;
    }
    
    private boolean isMirror(TreeNode left, TreeNode right) {
        // Both null → symmetric
        if (left == null && right == null) {
            return true;
        }
        
        // One null, one not → not symmetric
        if (left == null || right == null) {
            return false;
        }
        
        // Values must match + subtrees must be mirrors of each other
        return (left.val == right.val) &&
               isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}
