//Given an array of positive integers nums and a positive integer target, 
//return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, 
//numsr] of which the sum is greater than or equal to target. If there is no such 
//subarray, return 0 instead. 
//
// 
// Example 1: 
//
// 
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem 
//constraint.
// 
//
// Example 2: 
//
// 
//Input: target = 4, nums = [1,4,4]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//Follow up: If you have figured out the O(n) solution, try coding another 
//solution of which the time complexity is O(n log(n)). Related Topics Array Binary 
//Search Sliding Window Prefix Sum 👍 6135 👎 182


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int N = nums.length;
        int l = 0, r = 0, sum = nums[0], min = Integer.MAX_VALUE;
        while (r < N) {
            while(sum < target) {
                r ++;
                if(r >= N) break;
                sum += nums[r];
            }
            while (sum >= target && l <= r) {
                min = Math.min(min, r - l + 1);
                sum -= nums[l];
                l ++;
            }
            // System.out.printf("l=%d, r=%d%n", l, r);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
