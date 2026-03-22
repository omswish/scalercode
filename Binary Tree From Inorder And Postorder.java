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
    
    // We'll use a map to quickly find the root's index in inorder
    private Map<Integer, Integer> inorderIndex = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Step 1: Build hashmap for O(1) lookup of root position in inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        
        // Step 2: Use helper with range indices
        return build(postorder, 0, postorder.length - 1,
                     inorder,    0, inorder.length - 1);
    }
    
    private TreeNode build(int[] post, int postStart, int postEnd,
                           int[] in,   int inStart,  int inEnd) {
        
        // Base case: no nodes
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        
        // Last element in current postorder range is the root
        int rootVal = post[postEnd];
        TreeNode root = new TreeNode(rootVal);
        
        // Find where this root is in inorder
        int rootIndexInInorder = inorderIndex.get(rootVal);
        
        // Count nodes in left subtree
        int leftSize = rootIndexInInorder - inStart;
        
        // Recursively build left and right subtrees
        
        // Left subtree:
        //   inorder:   inStart → rootIndexInInorder-1
        //   postorder: postStart → postStart + leftSize - 1
        root.left = build(post, postStart, postStart + leftSize - 1,
                          in,   inStart, rootIndexInInorder - 1);
        
        // Right subtree:
        //   inorder:   rootIndexInInorder+1 → inEnd
        //   postorder: postStart + leftSize → postEnd-1
        root.right = build(post, postStart + leftSize, postEnd - 1,
                           in,   rootIndexInInorder + 1, inEnd);
        
        return root;
    }
}
