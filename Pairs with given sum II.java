public class Solution {
    public int solve(int[] A, int B) {
        long n = A.length;
        long i = 0, j = n - 1;
        long count = 0;
        long mod = 1000000007;

        while (i < j) {
            long sum = (long) A[(int)i] + A[(int)j];

            if (sum < B) {
                i++;
            } else if (sum > B) {
                j--;
            } else {
                // Sum == B
                if (A[(int)i] == A[(int)j]) {
                    long elementsInRange = j - i + 1;
                    // nCr formula for nC2: n * (n-1) / 2
                    count += (elementsInRange * (elementsInRange - 1)) / 2;
                    count %= mod;
                    break; // All pairs in this range are now counted
                } else {
                    long leftValue = A[(int)i];
                    long leftCount = 0;
                    while (i < n && A[(int)i] == leftValue) {
                        leftCount++;
                        i++;
                    }

                    long rightValue = A[(int)j];
                    long rightCount = 0;
                    while (j >= 0 && A[(int)j] == rightValue) {
                        rightCount++;
                        j--;
                    }

                    count += (leftCount * rightCount);
                    count %= mod;
                }
            }
        }
        return (int) (count % mod);
    }
}
