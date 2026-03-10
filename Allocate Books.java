public class Solution {
    public int books(int[] A, int B) {
        int n = A.length;
        // If students are more than books, each student can't get at least one book
        if (B > n) {
            return -1;
        }

        long low = 0;
        long high = 0;
        for (int pages : A) {
            low = Math.max(low, pages);
            high += pages;
        }

        long ans = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isPossible(A, B, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    private boolean isPossible(int[] A, int students, long maxPages) {
        int studentsRequired = 1;
        long currentPagesSum = 0;

        for (int pages : A) {
            // If adding this book exceeds the student's limit
            if (currentPagesSum + pages > maxPages) {
                studentsRequired++;
                currentPagesSum = pages;
                
                // If we need more students than available
                if (studentsRequired > students) {
                    return false;
                }
            } else {
                currentPagesSum += pages;
            }
        }
        return true;
    }
}
