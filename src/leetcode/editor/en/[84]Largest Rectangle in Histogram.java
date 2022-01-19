//Given an array of integers heights representing the histogram's bar height 
//where the width of each bar is 1, return the area of the largest rectangle in the 
//histogram. 
//
// 
// Example 1: 
//
// 
//Input: heights = [2,1,5,6,2,3]
//Output: 10
//Explanation: The above is a histogram where width of each bar is 1.
//The largest rectangle is shown in the red area, which has an area = 10 units.
// 
//
// Example 2: 
//
// 
//Input: heights = [2,4]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= heights.length <= 10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
// Related Topics Array Stack Monotonic Stack 👍 8158 👎 126


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] h) {
        int N = h.length;
        int[] left = new int[N], right = new int[N], stack = new int[N];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            while (idx > 0 && h[stack[idx - 1]] >= h[i]) {
                idx--;
            }
            if (idx == 0) left[i] = -1;
            else left[i] = stack[idx - 1];
            stack[idx++] = i;
        }

        idx = 0;
        for (int i = N - 1; i >= 0; i--) {
            while (idx > 0 && h[stack[idx - 1]] >= h[i]) {
                idx--;
            }
            if (idx == 0) right[i] = N;
            else right[i] = stack[idx - 1];
            stack[idx++] = i;
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int w = right[i] - left[i] - 1;
            max = Math.max(max, w * h[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
