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
import java.util.*;

public class Solution {
    public int[][] zigzagLevelOrder(TreeNode A) {
        if (A == null) {
            return new int[0][0];
        }
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        
        boolean leftToRight = true;  // direction flag
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            // Process current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                if (leftToRight) {
                    currentLevel.add(node.val);
                } else {
                    currentLevel.add(0, node.val);  // insert at front = reverse order
                }
                
                if (node.left != null)  queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            result.add(currentLevel);
            leftToRight = !leftToRight;  // toggle direction
        }
        
        // Convert List<List<Integer>> → int[][]
        int[][] ans = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> level = result.get(i);
            ans[i] = new int[level.size()];
            for (int j = 0; j < level.size(); j++) {
                ans[i][j] = level.get(j);
            }
        }
        
        return ans;
    }
}
