//Given an array of integers temperatures represents the daily temperatures, 
//return an array answer such that answer[i] is the number of days you have to wait 
//after the iᵗʰ day to get a warmer temperature. If there is no future day for 
//which this is possible, keep answer[i] == 0 instead. 
//
// 
// Example 1: 
// Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]
// Example 2: 
// Input: temperatures = [30,40,50,60]
//Output: [1,1,1,0]
// Example 3: 
// Input: temperatures = [30,60,90]
//Output: [1,1,0]
// 
// 
// Constraints: 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics Array Stack Monotonic Stack 👍 7107 👎 160


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] t) {
        int N = t.length;
        int[] stack = new int[N];
        int sz = 0;

        int[] res = new int[N];
        for(int i = 0; i < N; i ++){
            while(sz > 0 && t[stack[sz - 1]] < t[i]) {
                res[stack[sz - 1]] = i - stack[sz - 1];
                sz --;
            }

            stack[sz ++] = i;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
