//Given an array nums of n integers, return an array of all the unique 
//quadruplets [nums[a], nums[b], nums[c], nums[d]] such that: 
//
// 
// 0 <= a, b, c, d < n 
// a, b, c, and d are distinct. 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics Array Two Pointers Sorting 👍 5844 👎 669


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        kSum(nums, target, 0, nums.length - 1, 4, new Stack<>());
        return result;
    }

    private void kSum(int[] nums, int target, int l, int r, int k, Stack<Integer> vals) {
        if (l > r) return;
        if (k == 2) {
            twoSum(nums, target, l, r, vals);
            return;
        }
        for (int i = l; i <= r; i++) {
            if (i > l && nums[i] == nums[i - 1]) continue;
            vals.push(nums[i]);
            kSum(nums, target - nums[i], i + 1, r, k - 1, vals);
            vals.pop();
        }
    }

    private void twoSum(int[] nums, int target, int l, int r, Stack<Integer> vals) {
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                List<Integer> sub = new ArrayList<>(vals);
                sub.add(nums[l]);
                sub.add(nums[r]);
                result.add(sub);
                do l++; while (l < r && nums[l] == nums[l - 1]);
                do r--; while (l < r && nums[r] == nums[r + 1]);
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
