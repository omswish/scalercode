import java.util.*;

public class Solution {
    public int solve(int[][] A, int[] B, int[] C) {
        int n = A.length;
        int m = A[0].length;
        
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{B[0], B[1], 0});
        dist[B[0]][B[1]] = 0;
        
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];
            
            if (r == C[0] && c == C[1]) {
                return d;
            }
            
            if (d > dist[r][c]) {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r;
                int nc = c;
                int steps = 0;
                
                // Roll until hitting a wall or grid boundary
                while (nr + dRow[i] >= 0 && nr + dRow[i] < n && nc + dCol[i] >= 0 && nc + dCol[i] < m && A[nr + dRow[i]][nc + dCol[i]] == 0) {
                    nr += dRow[i];
                    nc += dCol[i];
                    steps++;
                }
                
                if (dist[nr][nc] == -1 || dist[r][c] + steps < dist[nr][nc]) {
                    dist[nr][nc] = dist[r][c] + steps;
                    pq.offer(new int[]{nr, nc, dist[nr][nc]});
                }
            }
        }
        
        return -1;
    }
}
