public class Solution {
    public int black(String[] A) {
        if (A == null || A.length == 0 || A[0].length() == 0) {
            return 0;
        }

        int n = A.length;
        int m = A[0].length();
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i].charAt(j) == 'X' && !visited[i][j]) {
                    count++;
                    bfs(A, visited, i, j, n, m);
                }
            }
        }

        return count;
    }

    private void bfs(String[] A, boolean[][] visited, int startRow, int startCol, int n, int m) {
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dRow[d];
                int nc = c + dCol[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && A[nr].charAt(nc) == 'X' && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
