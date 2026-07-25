import java.util.*;

public class Solution {
    public int[] solve(int A, int[][] B, int C) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new int[]{v, weight});
            adj.get(v).add(new int[]{u, weight});
        }

        int[] dist = new int[A];
        Arrays.fill(dist, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{C, 0});
        dist[C] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u]) {
                continue;
            }

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (dist[v] == -1 || dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        return dist;
    }
}
