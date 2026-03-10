public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] searchRange(final int[] A, int B) {
        int[] result = new int[2];
        result[0] = findFirst(A, B);
        result[1] = findLast(A, B);
        return result;
    }

    private int findFirst(int[] A, int B) {
        int low = 0, high = A.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == B) {
                index = mid;     // Potential answer
                high = mid - 1;  // Keep looking left
            } else if (A[mid] < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    private int findLast(int[] A, int B) {
        int low = 0, high = A.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == B) {
                index = mid;     // Potential answer
                low = mid + 1;   // Keep looking right
            } else if (A[mid] < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
}
