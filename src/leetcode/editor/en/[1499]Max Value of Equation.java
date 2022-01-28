//You are given an array points containing the coordinates of points on a 2D 
//plane, sorted by the x-values, where points[i] = [xi, yi] such that xi < xj for 
//all 1 <= i < j <= points.length. You are also given an integer k. 
//
// Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| 
//<= k and 1 <= i < j <= points.length. 
//
// It is guaranteed that there exists at least one pair of points that satisfy 
//the constraint |xi - xj| <= k. 
//
// 
// Example 1: 
//
// 
//Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
//Output: 4
//Explanation: The first two points satisfy the condition |xi - xj| <= 1 and if 
//we calculate the equation we get 3 + 0 + |1 - 2| = 4. Third and fourth points 
//also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
//No other pairs satisfy the condition, so we return the max of 4 and 1.
// 
//
// Example 2: 
//
// 
//Input: points = [[0,0],[3,0],[9,2]], k = 3
//Output: 3
//Explanation: Only the first two points have an absolute difference of 3 or 
//less in the x-values, and give the value of 0 + 0 + |0 - 3| = 3.
// 
//
// 
// Constraints: 
//
// 
// 2 <= points.length <= 10⁵ 
// points[i].length == 2 
// -10⁸ <= xi, yi <= 10⁸ 
// 0 <= k <= 2 * 10⁸ 
// xi < xj for all 1 <= i < j <= points.length 
// xi form a strictly increasing sequence. 
// 
// Related Topics Array Queue Sliding Window Heap (Priority Queue) Monotonic 
//Queue 👍 742 👎 27


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        LinkedList<Integer> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int r = 0; r < points.length; r++) {
            int[] cur = points[r];
            while (!q.isEmpty() && cur[0] - points[q.getFirst()][0] > k) q.pollFirst();

            // yi + yj + |xi - xj| = yi + yj + (xj - xi) = (yi - xi) + (xj + yj)
            if (!q.isEmpty()) {
                int[] bottom = points[q.getFirst()];
                max = Math.max(max, bottom[1] - bottom[0] + cur[1] + cur[0]);

                while (!q.isEmpty() && currentBetterThanTop(points, q, cur)) {
                    q.pollLast();
                }
            }
            q.offerLast(r);
        }
        return max;
    }

    private boolean currentBetterThanTop(int[][] points, LinkedList<Integer> q, int[] cur) {
        int[] top = points[q.getLast()];
        return cur[1] - cur[0] >= top[1] - top[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
