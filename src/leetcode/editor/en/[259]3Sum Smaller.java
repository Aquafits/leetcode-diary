//Given an array of n integers nums and an integer target, find the number of 
//index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] 
//+ nums[j] + nums[k] < target. 
// 
// Example 1: 
//
// 
//Input: nums = [-2,0,1,3], target = 2
//Output: 2
//Explanation: Because there are two triplets which sums are less than 2:
//[-2,0,1]
//[-2,0,3]
// 
//
// Example 2: 
//
// 
//Input: nums = [], target = 0
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: nums = [0], target = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 0 <= n <= 3500 
// -100 <= nums[i] <= 100 
// -100 <= target <= 100 
// 
// Related Topics Array Two Pointers Binary Search Sorting 👍 1216 👎 123


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int N = nums.length;
        Arrays.sort(nums);

        int cnt = 0;
        for(int i = 0; i < N - 2; i ++){
            if(nums[i] + nums[i + 1] + nums[i + 2] >= target) break;
            for(int j = i + 1; j < N - 1; j ++){
                if(nums[i] + nums[j] + nums[j + 1] >= target) break;
                int k = find(nums, j + 1, N - 1, target - nums[i] - nums[j]);
                if(nums[k] < target - nums[i] - nums[j]){
                    cnt += k - j;
                }
            }
        }
        return cnt;
    }

    private int find(int[] arr, int l, int r, int t){
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(arr[mid] < t){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
