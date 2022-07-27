//You are given an integer array nums. In one operation, you can replace any 
//element in nums with any integer. 
//
// nums is considered continuous if both of the following conditions are 
//fulfilled: 
//
// 
// All elements in nums are unique. 
// The difference between the maximum element and the minimum element in nums 
//equals nums.length - 1. 
// 
//
// For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] 
//is not continuous. 
//
// Return the minimum number of operations to make nums continuous. 
//
// 
// Example 1: 
//
// 
//Input: nums = [4,2,5,3]
//Output: 0
//Explanation: nums is already continuous.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5,6]
//Output: 1
//Explanation: One possible solution is to change the last element to 4.
//The resulting array is [1,2,3,5,4], which is continuous.
// 
//
// Example 3: 
//
// 
//Input: nums = [1,10,100,1000]
//Output: 3
//Explanation: One possible solution is to:
//- Change the second element to 2.
//- Change the third element to 3.
//- Change the fourth element to 4.
//The resulting array is [1,2,3,4], which is continuous.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
// Related Topics Array Binary Search 👍 471 👎 4


import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] nums) {
        // N ~ 10^5
        int N = nums.length;
        Arrays.sort(nums); // NlogN
        Set<Integer> set = new HashSet<>();
        for(int n: nums) set.add(n);

        int[] keys = new int[set.size()];
        int idx = 0;
        for(int n: set) keys[idx ++] = n;
        Arrays.sort(keys); // NlogN

        for(int l: keys) {
            int r = l + N - 1;

        }


        int res = nums.length;
        for (int l = 0; l < nums.length; l++) {
            int target = nums[l] + nums.length - 1;
            int p = find(keys, l, nums.length - 1, target);
            if (p != -1) {
                int cnt = 0;
                for (int i = p; i < keys.length; i++) {
                    cnt += counter.get(keys[p]);
                }
                res = Math.min(res, cnt);
            } else {
                return 0;
            }
        }

        return res;
    }

    private int find(int[] arr, int l, int r, int target) {
        // find first index p where arr[p] > target
        // [](]
        //   ^
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            int x = arr[mid];
            if (x > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (arr[l] > target) {
            return l;
        } else {
            return -1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
