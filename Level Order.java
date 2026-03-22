import java.util.*;

public class Solution {
    public int[][] solve(TreeNode root) {
        if (root == null) return new int[0][0];
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            
            while (size-- > 0) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            
            res.add(level);
        }
        
        int[][] ans = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        
        return ans;
    }
}
