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
        // two intervals overlaps [0, i + (n1 - 1)]
        //     1 2 3 2 1
        //             3 2 1 4 7
        //     ^       ^       ^
        // i = -(n1-1) 0    (n2-1)
        int N1 = nums1.length, N2 = nums2.length;
        int res = 0;
        for (int i = -(N1 - 1); i <= N2 - 1; i++) { // O(N1 + N2)
            int cnt = 0;
            // overlapping range
            for (int j = Math.max(0, i); j <= Math.min(i + (N1 - 1), N2 - 1); j++) { // O(N2)
                if (nums1[j - i] == nums2[j]) {
                    cnt++;
                } else {
                    cnt = 0;
                }
                res = Math.max(res, cnt);
            }
        }

        // Time Complexity: O(N2(N1 + N2))
        // Space Complexity: O(1)
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
