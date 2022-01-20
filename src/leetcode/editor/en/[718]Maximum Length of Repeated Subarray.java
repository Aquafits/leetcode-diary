//Given two integer arrays nums1 and nums2, return the maximum length of a 
//subarray that appears in both arrays. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//Output: 3
//Explanation: The repeated subarray with maximum length is [3,2,1].
// 
//
// Example 2: 
//
// 
//Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
// Related Topics Array Binary Search Dynamic Programming Sliding Window 
//Rolling Hash Hash Function 👍 3367 👎 84


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int N1 = nums1.length, N2 = nums2.length;
        int max = 0;
        for (int bias = -N1 + 1; bias <= N2 - 1; bias++) {
            int l = Math.max(bias, 0), r = Math.min(bias + N1 - 1, N2 - 1), cnt = 0;
            for (int i = l; i <= r; i++) {
                if (nums1[i - bias] == nums2[i]) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 0;
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
