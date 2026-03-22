public class Solution {
    public int solve(TreeNode A) {
        if (A == null) return 0;
        return A.val + solve(A.left) + solve(A.right);
    }
}
