import java.util.*;

public class Solution {
    public int solve(int A, int[][] B) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[A + 1];
        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= A; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processedCount = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            processedCount++;

            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return processedCount == A ? 0 : 1;
    }
}
