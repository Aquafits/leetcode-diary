//Given an integer array nums sorted in non-decreasing order, return an array 
//of the squares of each number sorted in non-decreasing order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
// 
//
// Example 2: 
//
// 
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums is sorted in non-decreasing order. 
// 
//
// 
//Follow up: Squaring each element and sorting the new array is very trivial, 
//could you find an O(n) solution using a different approach? Related Topics Array 
//Two Pointers Sorting 👍 4591 👎 146


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        int l = 0, r = N - 1, p = N - 1;
        int a = nums[l] * nums[l];
        int b = nums[r] * nums[r];
        while (l <= r) {
            if (a > b) {
                res[p--] = a;
                l++;
                if(l < N) a = nums[l] * nums[l];
            } else {
                res[p--] = b;
                r--;
                if(r >= 0) b = nums[r] * nums[r];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
