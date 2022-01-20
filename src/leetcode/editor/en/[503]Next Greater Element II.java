//Given a circular integer array nums (i.e., the next element of nums[nums.
//length - 1] is nums[0]), return the next greater number for every element in nums. 
//
// The next greater number of a number x is the first greater number to its 
//traversing-order next in the array, which means you could search circularly to find 
//its next greater number. If it doesn't exist, return -1 for this number. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,1]
//Output: [2,-1,2]
//Explanation: The first 1's next greater number is 2; 
//The number 2 can't find next greater number. 
//The second 1's next greater number needs to search circularly, which is also 2
//.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,3]
//Output: [2,3,4,-1,4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics Array Stack Monotonic Stack 👍 3851 👎 121


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        Arrays.fill(res, -1);

        int[] stack = new int[2 * N];
        int idx = 0;
        for (int i = 0; i < 2 * N; i++) {
            int nid = i % N;
            while (idx > 0 && nums[stack[idx - 1]] < nums[nid]) {
//                System.out.printf("top: nums[%d] = %d < cur: nums[%d] = %d, pop top%n", stack[idx - 1], nums[stack[idx - 1]], nid, nums[nid]);
                res[stack[idx - 1]] = nums[nid];
                idx--;
            }
//            System.out.printf("push nid = %d%n", nid);
            stack[idx++] = nid;
        }

        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
