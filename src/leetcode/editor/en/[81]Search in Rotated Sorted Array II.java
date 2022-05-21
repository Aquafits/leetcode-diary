//There is an integer array nums sorted in non-decreasing order (not 
//necessarily with distinct values). 
//
// Before being passed to your function, nums is rotated at an unknown pivot 
//index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1]
//, ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0
//,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,
//2,4,4]. 
//
// Given the array nums after the rotation and an integer target, return true 
//if target is in nums, or false if it is not in nums. 
//
// You must decrease the overall operation steps as much as possible. 
//
// 
// Example 1: 
// Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// Example 2: 
// Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums is guaranteed to be rotated at some pivot. 
// -10⁴ <= target <= 10⁴ 
// 
//
// 
// Follow up: This problem is similar to Search in Rotated Sorted Array, but 
//nums may contain duplicates. Would this affect the runtime complexity? How and why?
// 
// Related Topics Array Binary Search 👍 4433 👎 723


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = l + ((r - l) >> 1);
            int x = nums[mid];

            // System.out.printf("l:%d, r:%d, mid:%d, x:%d;%n", l, r, mid, x);
            if(nums[l] == x && l < mid){
                l ++;
                continue;
            }

            if(nums[l] <= x){
                if(nums[l] <= target && target <= x) {
                    // System.out.printf("sorted from l:%d, mid:%d;%n", l, mid);
                    return find(nums, l, mid, target);
                } else {
                    l = mid + 1;
                }
            } else if(nums[l] > x){
                if(x <= target && target <= nums[r]){
                    // System.out.printf("sorted from mid:%d, r:%d;%n", mid, r);
                    return find(nums, mid, r, target);
                } else {
                    r = mid - 1;
                }
            }
        }

        return nums[l] == target;
    }

    private boolean find(int[] nums, int l, int r, int target){
        while(l < r){
            int mid = l + ((r - l) >> 1);
            int x = nums[mid];
            if(target <= x){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
