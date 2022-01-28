//Given an array of integers nums containing n + 1 integers where each integer 
//is in the range [1, n] inclusive. 
//
// There is only one repeated number in nums, return this repeated number. 
//
// You must solve the problem without modifying the array nums and uses only 
//constant extra space. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,4,2,2]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: nums = [3,1,3,4,2]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁵ 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// All the integers in nums appear only once except for precisely one integer 
//which appears two or more times. 
// 
//
// 
// Follow up: 
//
// 
// How can we prove that at least one duplicate number must exist in nums? 
// Can you solve the problem in linear runtime complexity? 
// 
// Related Topics Array Two Pointers Binary Search Bit Manipulation 👍 11112 👎 
//1168


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        return binSearchSolution(nums);
    }

    public int graphSolution(int[] nums) {
        // pos 0 has out-degree but does not have in-degree, there is loop in [1, n]
        // the loop entrance got 2 in-degrees, we need to find it
        int p1 = 0, p2 = 0;
        while (p1 != p2 || p1 == 0) {
            p1 = nums[p1];
            p2 = nums[nums[p2]];
        }
        p1 = 0;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }

    public int binSearchSolution(int[] nums) {
        // dup number x;
        // num < x: leCnt[num] <= x;
        // num >= x: leCnt[num] >= x + 1;
        int l = 1, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (leCnt(mid, nums) <= mid) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int leCnt(int x, int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) if (nums[i] <= x) cnt++;
        return cnt;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
