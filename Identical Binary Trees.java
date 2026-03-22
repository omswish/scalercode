public class Solution {
    public int isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return 1;
        if (p == null || q == null) return 0;
        
        return (p.val == q.val) 
            && isSameTree(p.left, q.left) == 1
            && isSameTree(p.right, q.right) == 1 ? 1 : 0;
    }
}
