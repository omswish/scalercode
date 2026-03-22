import java.util.*;

public class Solution {
    public int[] solve(TreeNode A) {
        if (A == null) {
            return new int[0];
        }
        
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            // Take the first node of current level (leftmost)
            TreeNode node = queue.poll();
            result.add(node.val);
            
            // Add remaining nodes of this level to queue
            if (node.left != null)  queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            
            // Process rest of the level (but don't add to result)
            for (int i = 1; i < levelSize; i++) {
                node = queue.poll();
                if (node.left != null)  queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        
        // Convert List to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
