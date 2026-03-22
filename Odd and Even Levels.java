/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int solve(TreeNode A) {
        if (A == null) return 0;
        
        long oddSum = 0;    // sum of nodes at odd levels (1,3,5,...)
        long evenSum = 0;   // sum of nodes at even levels (2,4,6,...)
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        
        int level = 1;      // root is at level 1 (odd)
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                if (level % 2 == 1) {
                    oddSum += node.val;
                } else {
                    evenSum += node.val;
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            level++;
        }
        
        return (int)(oddSum - evenSum);
    }
}
