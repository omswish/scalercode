import java.util.*;

public class Solution {
    public int[] solve(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < B.length; i++) {
            adj.get(B[i]).add(C[i]);
            adj.get(C[i]).add(B[i]);
        }

        List<List<Integer>> levels = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[A + 1];

        queue.offer(1);
        visited[1] = true;
        int maxDepth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                currentLevelNodes.add(D[curr - 1]);

                for (int neighbor : adj.get(curr)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
            Collections.sort(currentLevelNodes);
            levels.add(currentLevelNodes);
            maxDepth++;
        }
        maxDepth--;

        int Q = E.length;
        int[] ans = new int[Q];
        int mod = maxDepth + 1;

        for (int i = 0; i < Q; i++) {
            long L = E[i];
            int X = F[i];
            int targetLevel = (int) (L % mod);

            List<Integer> nodes = levels.get(targetLevel);
            int idx = lowerBound(nodes, X);

            if (idx < nodes.size()) {
                ans[i] = nodes.get(idx);
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }

    private int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
