//Given an m x n matrix matrix and an integer k, return the max sum of a 
//rectangle in the matrix such that its sum is no larger than k. 
//
// It is guaranteed that there will be a rectangle with a sum no larger than k. 
//
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,0,1],[0,-2,3]], k = 2
//Output: 2
//Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, 
//and 2 is the max number no larger than k (k = 2).
// 
//
// Example 2: 
//
// 
//Input: matrix = [[2,2,-1]], k = 3
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -100 <= matrix[i][j] <= 100 
// -10⁵ <= k <= 10⁵ 
// 
//
// 
// Follow up: What if the number of rows is much larger than the number of 
//columns? 
// Related Topics Array Binary Search Dynamic Programming Matrix Ordered Set 👍 
//1868 👎 105


import java.util.TreeMap;
import java.util.TreeSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] rect = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                rect[i][j] = rect[i - 1][j] + rect[i][j - 1] - rect[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        TreeMap

        int max = Integer.MIN_VALUE;
        for(int y2 = 1; y2 <= n; y2 ++){
            for(int y1 = 0; y1 < y2; y1 ++){
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for(int x = 1; x <= m; x ++){
                    int cur = rect[x][y2] - rect[x][y1];
                    // cur - prev <= k, thus, prev >= cur - k;
                    Integer prev = set.ceiling(cur - k);
                    if(prev != null) max = Math.max(max, cur - prev);
                    set.add(cur);
                }
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
