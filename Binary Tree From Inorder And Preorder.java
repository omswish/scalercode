/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    // We'll use a map to find root index in inorder quickly
    private Map<Integer, Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build hashmap for O(1) lookup of root position in inorder
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        // Start recursion with full ranges
        return build(preorder, 0, preorder.length - 1, 
                     inorder,   0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder,  int inStart,  int inEnd) {
        
        // Base case: no elements left
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        // First element in current preorder range is the root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        // Find position of root in inorder array
        int rootIndex = inorderIndexMap.get(rootVal);
        
        // Calculate number of nodes in left subtree
        int leftSize = rootIndex - inStart;
        
        // Recursively build left and right subtrees
        root.left = build(preorder, preStart + 1,          preStart + leftSize,
                          inorder,  inStart,               rootIndex - 1);
                          
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                           inorder,  rootIndex + 1,           inEnd);
        
        return root;
    }
}
