//Given an integer array nums, return the number of triplets chosen from the 
//array that can make triangles if we take them as side lengths of a triangle. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,2,3,4]
//Output: 3
//Explanation: Valid combinations are: 
//2,3,4 (using the first 2)
//2,3,4 (using the second 2)
//2,2,3
// 
//
// Example 2: 
//
// 
//Input: nums = [4,2,3,4]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
// Related Topics Array Two Pointers Binary Search Greedy Sorting 👍 2548 👎 153
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length < 3) return 0;

        int res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i ++){
            int j = i + 1, k = i + 2;
            while(k < nums.length){
                // nums[k] - nums[i] <= nums[j]
                if(nums[j] > nums[k] - nums[i]){
                    // System.out.printf("i:[%d]%d, j: [%d]%d, k:[%d]%d, cnt:%d%n", i, nums[i], j, nums[j], k, nums[k], k - j);
                    res += (k - j);
                    k ++;
                } else {
                    j ++;
                    k = Math.max(k, j + 1);
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
