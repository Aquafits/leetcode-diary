//Given an integer array nums and a positive integer k, return the most 
//competitive subsequence of nums of size k. 
//
// An array's subsequence is a resulting sequence obtained by erasing some (
//possibly zero) elements from the array. 
//
// We define that a subsequence a is more competitive than a subsequence b (of 
//the same length) if in the first position where a and b differ, subsequence a 
//has a number less than the corresponding number in b. For example, [1,3,4] is more 
//competitive than [1,3,5] because the first position they differ is at the final 
//number, and 4 is less than 5. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,5,2,6], k = 2
//Output: [2,6]
//Explanation: Among the set of every possible subsequence: {[3,5], [3,2], [3,6]
//, [5,2], [5,6], [2,6]}, [2,6] is the most competitive.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,4,3,3,5,4,9,6], k = 4
//Output: [2,3,3,4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 1 <= k <= nums.length 
// 
// Related Topics Array Stack Greedy Monotonic Stack 👍 1387 👎 66


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int N = nums.length;
        int[] stack = new int[N];
        int sz = 0;

        for(int i = 0; i < N; i ++) {
            while(sz > 0 && nums[i] < nums[stack[sz - 1]] && N - 1 - i >= k - sz) {
                sz --;
            }
            if(sz < k) {
                stack[sz ++] = i;
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i ++) {
            res[i] = nums[stack[i]];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
