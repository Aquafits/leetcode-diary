//Given an integer array nums, return the length of the longest strictly 
//increasing subsequence. 
//
// A subsequence is a sequence that can be derived from an array by deleting 
//some or no elements without changing the order of the remaining elements. For 
//example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time 
//complexity? 
// Related Topics Array Binary Search Dynamic Programming 👍 11161 👎 220


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        int sz = 0;
        for(int n: nums){
            if(sz == 0 || n > arr.get(sz - 1)){
                arr.add(n);
                sz ++;
            } else {
                arr.set(find(arr, n), n);
            }
        }
        return sz;
    }

    private int find(List<Integer> arr, int n) {
        int l = 0, r = arr.size() - 1;
        while (l < r){
            int mid = (l + r) >> 1;
            if(arr.get(mid) >= n){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
