//You are given an array of integers nums, there is a sliding window of size k 
//which is moving from the very left of the array to the very right. You can only 
//see the k numbers in the window. Each time the sliding window moves right by one 
//position. 
//
// Return the max sliding window. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation: 
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
// Related Topics Array Queue Sliding Window Heap (Priority Queue) Monotonic 
//Queue 👍 8548 👎 298


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        LinkedList<Integer> q = new LinkedList<>();
        int[] res = new int[N - k + 1];
        for (int r = 0; r < N; r++) {
            int l = r - k + 1;
            if(!q.isEmpty() && q.getFirst() < l) q.pollFirst();
            while (!q.isEmpty() && nums[q.getLast()] <= nums[r]) q.pollLast();
            q.offerLast(r);
            if (l >= 0) res[l] = nums[q.getFirst()];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
