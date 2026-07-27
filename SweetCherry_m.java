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

    public int[] solve(int[] A, int[][] B, int[] C) {
        int n = A.length;
        this.A = A;
        this.C = C;
        ans = new int[n];
        
        // Size nodes sufficiently for 200,000 insertions (approx N * log2(N))
        int MAX_NODES = n * 22 + 100;
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
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : B) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            adj[u].add(v);
            adj[v].add(u);
        }
        
        // 1. Iterative BFS to establish depths and topological bottom-up order
        int[] parent = new int[n];
        int[] depth = new int[n];
        int[] order = new int[n];
        boolean[] visited = new boolean[n];
        
        int head = 0, tail = 0;
        order[tail++] = 0;
        visited[0] = true;
        parent[0] = -1;
        depth[0] = 0;
        
        while (head < tail) {
            int u = order[head++];
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    depth[v] = depth[u] + 1;
                    order[tail++] = v;
                }
            }
        }
        
        // 2. Process nodes Bottom-Up (Reverse BFS order) to prevent StackOverflowError
        int[] treeRoots = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            int treeRoot = 0;
            
            // Merge all children into the current node's tree root
            for (int v : adj[u]) {
                if (v != parent[u]) {
                    treeRoot = merge(treeRoot, treeRoots[v]);
                }
            }
            
            // Insert the current node's data into its segment tree
            int uPos = Arrays.binarySearch(uniqueA, A[u]);
            treeRoot = insert(treeRoot, 0, M - 1, uPos, depth[u]);
            
            // Establish boundaries using long to avoid overflow
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
                ans[u] = bestDepth - depth[u];
            }
            
            treeRoots[u] = treeRoot; // Store the populated root for the parent's merge phase later
        }
        
        return ans;
    }
    
    private int merge(int root1, int root2) {
        if (root1 == 0) return root2;
        if (root2 == 0) return root1;
        
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
                low = mid + 1;  
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
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
