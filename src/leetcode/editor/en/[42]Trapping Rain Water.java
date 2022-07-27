//Given n non-negative integers representing an elevation map where the width 
//of each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
//
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
//are being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack ?
//? 18724 👎 263


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int[] stack = new int[N];
        int sz = 0;

        int water = 0;
        for (int r = 0; r < N; r++) {
            int top = sz > 0 ? stack[sz - 1] : -1;
            while (sz > 0 && height[top] < height[r]) {
                if (sz >= 2) {
                    int l = stack[sz - 2];
                    water += (r - l - 1) * (Math.min(height[l], height[r]) - height[top]);
                }
                sz--;
            }
            stack[sz++] = r;
        }

        return water;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
