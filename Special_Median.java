import java.util.*;

public class Solution {
    public int solve(int[] A) {
        if (A == null || A.length <= 1) return 0;
        
        // Check prefix condition
        if (check(A)) return 1;
        
        // Check suffix condition: reverse the array and check same logic
        int[] reversed = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            reversed[i] = A[A.length - 1 - i];
        }
        if (check(reversed)) return 1;
        
        return 0;
    }

    private boolean check(int[] arr) {
        // Max-heap for the left half
        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap for the right half
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
        
        leftMaxHeap.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            double median = getMedian(leftMaxHeap, rightMinHeap);
            if ((double) arr[i] == median) return true;
            
            addNum(arr[i], leftMaxHeap, rightMinHeap);
        }
        return false;
    }

    private double getMedian(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }
        return (double) left.peek();
    }

    private void addNum(int num, PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.isEmpty() || num <= left.peek()) {
            left.add(num);
        } else {
            right.add(num);
        }
        
        // Balance heaps
        if (left.size() > right.size() + 1) {
            right.add(left.poll());
        } else if (right.size() > left.size()) {
            left.add(right.poll());
        }
    }
}
