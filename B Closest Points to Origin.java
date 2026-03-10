import java.util.*;

public class Solution {
    public int[][] solve(int[][] A, int B) {
        // Max-heap to store the B closest points
        // We use a custom comparator to compare squared distances: x^2 + y^2
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> {
            long d1 = (long) p1[0] * p1[0] + (long) p1[1] * p1[1];
            long d2 = (long) p2[0] * p2[0] + (long) p2[1] * p2[1];
            return Long.compare(d2, d1); // Compare d2 to d1 for Max-Heap
        });

        for (int[] point : A) {
            maxHeap.add(point);
            // If heap size exceeds B, remove the point with the largest distance
            if (maxHeap.size() > B) {
                maxHeap.poll();
            }
        }

        // Prepare the result array
        int[][] result = new int[B][2];
        for (int i = 0; i < B; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}
