import java.util.ArrayList;

public class Solution {
    int timer;
    int[] in, out;
    long[] pathSum;
    long[] bit;
    int n;

    // Binary Indexed Tree functions
    private void add(int idx, long val) {
        for (; idx <= n; idx += idx & -idx) {
            bit[idx] += val;
        }
    }

    private long query(int idx) {
        long sum = 0;
        for (; idx > 0; idx -= idx & -idx) {
            sum += bit[idx];
        }
        return sum;
    }

    // Depth First Search to flatten the tree and calculate initial path sums
    private void dfs(int u, int p, long currentCost, ArrayList<Integer>[] adj, int[] A) {
        timer++;
        in[u] = timer;
        pathSum[timer] = currentCost;
        
        for (int v : adj[u]) {
            if (v != p) {
                // A is 0-indexed in Java, so cost of city 'v' is A[v - 1]
                dfs(v, u, currentCost + A[v - 1], adj, A);
            }
        }
        
        out[u] = timer;
    }

    public int[] solve(int[] A, int[][] B, int[][] C) {
        n = A.length;
        
        // Build the Adjacency List for the tree
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : B) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        in = new int[n + 1];
        out = new int[n + 1];
        pathSum = new long[n + 1];
        timer = 0;
        
        // Root the tree at City 1, Initial cost of City 1 is 0 as per instructions
        dfs(1, 0, 0L, adj, A);
        
        bit = new long[n + 2];
        
        // Initialize the BIT with the difference array mapping of the initial path sums
        for (int i = 1; i <= n; i++) {
            add(i, pathSum[i]);
            add(i + 1, -pathSum[i]);
        }
        
        // Count total Type 1 queries to appropriately size the answer array
        int qCount = 0;
        for (int[] q : C) {
            if (q[0] == 1) {
                qCount++;
            }
        }
        
        int[] ans = new int[qCount];
        int idx = 0;
        
        for (int[] q : C) {
            int type = q[0];
            
            if (type == 1) {
                int x = q[1];
                ans[idx++] = (int) query(in[x]); // Point query for current path sum
            } 
            else if (type == 2) {
                int x = q[1];
                int u = q[2];
                
                // Exclude updates to City 1 since its traversal cost is strictly ignored
                if (x != 1) {
                    add(in[x], u);             // Add U at the start of subtree
                    add(out[x] + 1, -u);       // Remove U immediately after the subtree
                }
            }
        }
        
        return ans;
    }
}
