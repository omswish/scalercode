public class Solution {
    public int solve(TreeNode A) {
        if (A == null) return -1;  // or 0, depending on what interviewer wants for empty tree
        
        int max = A.val;
        
        if (A.left != null) {
            max = Math.max(max, solve(A.left));
        }
        if (A.right != null) {
            max = Math.max(max, solve(A.right));
        }
        
        return max;
    }
}
