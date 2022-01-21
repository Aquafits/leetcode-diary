//The median is the middle value in an ordered integer list. If the size of the 
//list is even, there is no middle value. So the median is the mean of the two 
//middle values. 
//
// 
// For examples, if arr = [2,3,4], the median is 3. 
// For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5. 
// 
//
// You are given an integer array nums and an integer k. There is a sliding 
//window of size k which is moving from the very left of the array to the very right. 
//You can only see the k numbers in the window. Each time the sliding window 
//moves right by one position. 
//
// Return the median array for each window in the original array. Answers 
//within 10⁻⁵ of the actual value will be accepted. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
//Explanation: 
//Window position                Median
//---------------                -----
//[1  3  -1] -3  5  3  6  7        1
// 1 [3  -1  -3] 5  3  6  7       -1
// 1  3 [-1  -3  5] 3  6  7       -1
// 1  3  -1 [-3  5  3] 6  7        3
// 1  3  -1  -3 [5  3  6] 7        5
// 1  3  -1  -3  5 [3  6  7]       6
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
//Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
// Related Topics Array Hash Table Sliding Window Heap (Priority Queue) 👍 1918 
//👎 122


import java.util.Collections;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> left = new PriorityQueue<>(k, Collections.reverseOrder()), right = new PriorityQueue<>(k);
        int N = nums.length;
        double[] res = new double[N - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            if (i == 0) {
                for (int j = 0; j < k; j++) right.offer(nums[j]);
                for (int j = 0; j < k / 2; j++) left.offer(right.poll());
            } else {
                // update left and right
                int toRm = nums[i - 1], toAdd = nums[i + k - 1];
                remove(left, right, toRm);
                add(left, right, toAdd, k);
            }
            res[i] = getMed(left, right, k);
        }
        return res;
    }

    private void add(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int toAdd, int k) {
        if (!right.isEmpty() && right.peek() <= toAdd) right.offer(toAdd);
        else left.offer(toAdd);

        while (left.size() < k / 2) left.offer(right.poll());
        while (left.size() > k / 2) right.offer(left.poll());
    }

    private void remove(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int toRm) {
        if (right.peek() <= toRm) right.remove(toRm);
        else left.remove(toRm);
    }

    private double getMed(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int k) {
        if (k % 2 == 0) return left.peek() / 2.0 + right.peek() / 2.0;
        else return right.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
