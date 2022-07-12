//There is an integer array nums sorted in ascending order (with distinct 
//values). 
//
// Prior to being passed to your function, nums is possibly rotated at an 
//unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k]
//, nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
//example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0
//,1,2]. 
//
// Given the array nums after the possible rotation and an integer target, 
//return the index of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// All values of nums are unique. 
// nums is an ascending array that is possibly rotated. 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics Array Binary Search 👍 12255 👎 820


import java.util.*;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int p = findSmallest(nums);
        int res = -1;
        res = find(nums, 0, p - 1, target);
        if (res != -1) return res;
        res = find(nums, p, nums.length - 1, target);
        return res;
    }

    private int findSmallest(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            int x = nums[mid];
            if (x <= nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        // System.out.printf("l:%d%n", l);
        return l;
    }

    private int find(int[] nums, int l, int r, int target) {
        // System.out.printf("l:%d, r:%d%n", l, r);
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            int x = nums[mid];
            if (x >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] == target) {
            return l;
        } else {
            return -1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
