import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    int[] minDepth;
    int[] leftChild;
    int[] rightChild;
    int nodeCnt;
    
    int[] uniqueA;
    int M;
    
    int[] ans;
    int[] A;
    int[] C;
    ArrayList<Integer>[] adj;

    public int[] solve(int[] A, int[][] B, int[] C) {
        int n = A.length;
        this.A = A;
        this.C = C;
        ans = new int[n];
        
        // Dynamically size segment tree arrays to save memory and avoid OutOfBounds.
        // Each of the N insertions creates at most ~19 nodes (since log2(200000) ~ 17.6)
        int MAX_NODES = Math.max(100, n * 20); 
        minDepth = new int[MAX_NODES];
        leftChild = new int[MAX_NODES];
        rightChild = new int[MAX_NODES];
        nodeCnt = 0;
        
        // Coordinate Compression mapping for values of A
        int[] tempA = A.clone();
        Arrays.sort(tempA);
        
        // Deduplicate
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || tempA[i] != tempA[i - 1]) {
                tempA[m++] = tempA[i];
            }
        }
        uniqueA = Arrays.copyOf(tempA, m);
        M = m;
        
        // Build adjacency list (converting 1-based nodes to 0-based indexing)
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : B) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            adj[u].add(v);
            adj[v].add(u);
        }
        
        // Root the tree at Node 1 (index 0) with a starting depth of 0
        dfs(0, -1, 0);
        
        return ans;
    }
    
    private int dfs(int u, int p, int depth) {
        int treeRoot = 0;
        
        // Traverse and merge trees coming from children 
        for (int v : adj[u]) {
            if (v != p) {
                int childRoot = dfs(v, u, depth + 1);
                treeRoot = merge(treeRoot, childRoot);
            }
        }
        
        // Insert the current node's data into its subtree segment tree
        int uPos = Arrays.binarySearch(uniqueA, A[u]);
        treeRoot = insert(treeRoot, 0, M - 1, uPos, depth);
        
        // Establish our boundary targets avoiding overflow using long
        long target1 = (long) A[u] - C[u];
        int idx1 = getUpperBound(target1);
        int min1 = Integer.MAX_VALUE;
        if (idx1 >= 0) {
            min1 = query(treeRoot, 0, M - 1, 0, idx1);
        }
        
        long target2 = (long) A[u] + C[u];
        int idx2 = getLowerBound(target2);
        int min2 = Integer.MAX_VALUE;
        if (idx2 < M) {
            min2 = query(treeRoot, 0, M - 1, idx2, M - 1);
        }
        
        // Check both valid value ranges to pinpoint the minimum depth
        int bestDepth = Math.min(min1, min2);
        if (bestDepth == Integer.MAX_VALUE) {
            ans[u] = -1;
        } else {
            ans[u] = bestDepth - depth;
        }
        
        return treeRoot;
    }
    
    private int merge(int root1, int root2) {
        if (root1 == 0) return root2;
        if (root2 == 0) return root1;
        
        // Destructive merge keeps allocations bounded and processing fast
        minDepth[root1] = Math.min(minDepth[root1], minDepth[root2]);
        leftChild[root1] = merge(leftChild[root1], leftChild[root2]);
        rightChild[root1] = merge(rightChild[root1], rightChild[root2]);
        
        return root1;
    }
    
    private int insert(int root, int start, int end, int pos, int depth) {
        if (root == 0) {
            root = ++nodeCnt;
            minDepth[root] = Integer.MAX_VALUE;
            leftChild[root] = 0;
            rightChild[root] = 0;
        }
        
        minDepth[root] = Math.min(minDepth[root], depth);
        
        if (start == end) return root;
        
        int mid = start + (end - start) / 2;
        if (pos <= mid) {
            leftChild[root] = insert(leftChild[root], start, mid, pos, depth);
        } else {
            rightChild[root] = insert(rightChild[root], mid + 1, end, pos, depth);
        }
        
        return root;
    }
    
    private int query(int root, int start, int end, int l, int r) {
        if (root == 0 || start > r || end < l) return Integer.MAX_VALUE;
        
        if (start >= l && end <= r) return minDepth[root];
        
        int mid = start + (end - start) / 2;
        int leftMin = query(leftChild[root], start, mid, l, r);
        int rightMin = query(rightChild[root], mid + 1, end, l, r);
        
        return Math.min(leftMin, rightMin);
    }
    
    // Finds the largest index such that uniqueA[index] <= val
    private int getUpperBound(long val) {
        int low = 0, high = M - 1, res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (uniqueA[mid] <= val) {
                res = mid;
                low = mid + 1;  // Look higher for the supremum
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
    
    // Finds the smallest index such that uniqueA[index] >= val
    private int getLowerBound(long val) {
        int low = 0, high = M - 1, res = M;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (uniqueA[mid] >= val) {
                res = mid;
                high = mid - 1; // Look lower for the infimum
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
