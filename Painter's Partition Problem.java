public class Solution {
    public int paint(int A, int B, int[] C) {
        long low = 0;
        long high = 0;
        int maxBoard = 0;
        
        for (int board : C) {
            high += board;
            maxBoard = Math.max(maxBoard, board);
        }
        
        low = maxBoard; // A painter must at least paint the largest board
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isPossible(C, A, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Return (ans * B) % 10000003
        // Use long for calculation to prevent overflow before modulo
        return (int) ((ans % 10000003 * (long) B % 10000003) % 10000003);
    }

    private boolean isPossible(int[] C, int paintersAvailable, long maxLengthAllowed) {
        int paintersUsed = 1;
        long currentSum = 0;

        for (int board : C) {
            if (currentSum + board > maxLengthAllowed) {
                paintersUsed++;
                currentSum = board;
                if (paintersUsed > paintersAvailable) {
                    return false;
                }
            } else {
                currentSum += board;
            }
        }
        return true;
    }
}
