import java.util.*;

public class Solution {
    public int[] solve(TreeNode A) {
        if (A == null) {
            return new int[0];
        }
        
        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                // Add only the last node of each level (rightmost)
                if (i == levelSize - 1) {
                    rightView.add(node.val);
                }
                
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        
        int[] result = new int[rightView.size()];
        for (int i = 0; i < rightView.size(); i++) {
            result[i] = rightView.get(i);
        }
        return result;
    }
}
