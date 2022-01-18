//Given a rows x cols binary matrix filled with 0's and 1's, find the largest 
//rectangle containing only 1's and return its area. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
//"1"],["1","0","0","1","0"]]
//Output: 6
//Explanation: The maximal rectangle is shown in the above picture.
// 
//
// Example 2: 
//
// 
//Input: matrix = [["0"]]
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: matrix = [["1"]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// rows == matrix.length 
// cols == matrix[i].length 
// 1 <= row, cols <= 200 
// matrix[i][j] is '0' or '1'. 
// 
// Related Topics Array Dynamic Programming Stack Matrix Monotonic Stack 👍 5968
// 👎 101


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[][] h = new int[M][N];
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                if (matrix[i][j] == '0') {
                    h[i][j] = 0;
                } else {
                    h[i][j] = 1 + ((i > 0) ? h[i - 1][j] : 0);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < M; i++) {
            max = Math.max(max, maximalRectangleInHistogram(h[i]));
        }
        return max;
    }

    private int maximalRectangleInHistogram(int[] h) {
        int N = h.length;
        int[] left = new int[N], right = new int[N], stack = new int[N];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            while (idx != 0 && h[stack[idx - 1]] >= h[i]) {
                idx--;
            }
            if (idx == 0) left[i] = -1;
            else left[i] = stack[idx - 1];
            stack[idx++] = i;
        }

        idx = 0;
        for (int i = N - 1; i >= 0; i--) {
            while (idx != 0 && h[stack[idx - 1]] >= h[i]) {
                idx--;
            }
            if (idx == 0) right[i] = N;
            else right[i] = stack[idx - 1];
            stack[idx++] = i;
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, h[i] * (right[i] - left[i] - 1));
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
