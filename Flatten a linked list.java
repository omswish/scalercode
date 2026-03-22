/*
class ListNode {
    int val;
    ListNode right, down;
    ListNode(int x) {
        val = x;
        right = down = null;
    }
}
*/

ListNode flatten(ListNode root) {
    // Base case: if list is empty or only one vertical list exists
    if (root == null || root.right == null) {
        return root;
    }

    // Recursively flatten the right side
    root.right = flatten(root.right);

    // Merge the current vertical list with the flattened right side
    root = merge(root, root.right);

    return root;
}

ListNode merge(ListNode a, ListNode b) {
    // Standard sorted merge for linked lists
    if (a == null) return b;
    if (b == null) return a;

    ListNode result;

    if (a.val < b.val) {
        result = a;
        // Move down in list A and merge with B
        result.down = merge(a.down, b);
    } else {
        result = b;
        // Move down in list B and merge with A
        result.down = merge(a, b.down);
    }
    
    // Ensure the right pointer is null in the flattened list
    result.right = null; 
    return result;
}
