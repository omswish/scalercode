import java.util.*;

public class Solution {
    public int knight(int A, int B, int C, int D, int E, int F) {
        if (C == E && D == F) {
            return 0;
        }

        boolean[][] visited = new boolean[A + 1][B + 1];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{C, D, 0});
        visited[C][D] = true;

        int[] dRow = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dCol = {1, 2, 2, 1, -1, -2, -2, -1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            if (r == E && c == F) {
                return dist;
            }

            for (int i = 0; i < 8; i++) {
                int nr = r + dRow[i];
                int nc = c + dCol[i];

                if (nr >= 1 && nr <= A && nc >= 1 && nc <= B && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }
}
