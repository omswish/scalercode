public class Solution {
    public int numSetBits(int A) {
        int count = 0;
        while (A != 0) {
            A &= (A - 1); // drops the lowest set bit
            count++;
        }
        return count;
    }
}
