public class Solution {
    public int maxArea(int[] A) {
        int maxArea = 0;
        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            // Calculate width
            int width = right - left;
            
            // Height is limited by the shorter wall
            int currentHeight = Math.min(A[left], A[right]);
            
            // Update maxArea if current container is larger
            int currentArea = width * currentHeight;
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter wall
            if (A[left] < A[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
