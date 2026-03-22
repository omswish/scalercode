/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left=null; right=null; }
 * }
 */
public class Solution {
    
    public int[] solve(TreeNode root) {
        if (root == null) return new int[0];
        
        List<Integer> boundary = new ArrayList<>();
        
        // Step 1: Add root (always part of boundary)
        boundary.add(root.val);
        
        // Step 2: Add left boundary (excluding leaves & root)
        addLeftBoundary(root.left, boundary);
        
        // Step 3: Add all leaf nodes (bottom boundary)
        addLeaves(root, boundary);
        
        // Step 4: Add right boundary in reverse order (excluding leaves & root)
        addRightBoundary(root.right, boundary);
        
        // Convert to int[]
        int[] result = new int[boundary.size()];
        for (int i = 0; i < boundary.size(); i++) {
            result[i] = boundary.get(i);
        }
        return result;
    }
    
    // Left boundary: root-to-leftmost path (only non-leaf nodes except root)
    private void addLeftBoundary(TreeNode node, List<Integer> boundary) {
        if (node == null) return;
        
        // Add only if it's not a leaf
        if (!isLeaf(node)) {
            boundary.add(node.val);
        }
        
        // Prefer left child if exists, else right
        if (node.left != null) {
            addLeftBoundary(node.left, boundary);
        } else if (node.right != null) {
            addLeftBoundary(node.right, boundary);
        }
    }
    
    // Right boundary: root-to-rightmost path (in reverse order, exclude leaves & root)
    private void addRightBoundary(TreeNode node, List<Integer> boundary) {
        if (node == null) return;
        
        // Prefer right child first
        if (node.right != null) {
            addRightBoundary(node.right, boundary);
        } else if (node.left != null) {
            addRightBoundary(node.left, boundary);
        }
        
        // Add only if it's not a leaf (after recursion → reverse order)
        if (!isLeaf(node)) {
            boundary.add(node.val);
        }
    }
    
    // Add all leaf nodes (left to right)
    private void addLeaves(TreeNode node, List<Integer> boundary) {
        if (node == null) return;
        
        if (isLeaf(node)) {
            boundary.add(node.val);
            return;
        }
        
        addLeaves(node.left, boundary);
        addLeaves(node.right, boundary);
    }
    
    // Helper: check if node is leaf
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
