import java.util.*;

public class Solution {
    public int[] solve(int A, int[][] B) {
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

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 1; i <= A; i++) {
            if (inDegree[i] == 0) {
                minHeap.offer(i);
            }
        }

        int[] topoOrder = new int[A];
        int index = 0;

        while (!minHeap.isEmpty()) {
            int curr = minHeap.poll();
            topoOrder[index++] = curr;

            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    minHeap.offer(neighbor);
                }
            }
        }

        if (index != A) {
            return new int[0];
        }

        return topoOrder;
    }
}
