//Given an m x n binary matrix filled with 0's and 1's, find the largest square 
//containing only 1's and return its area. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
//"1"],["1","0","0","1","0"]]
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: matrix = [["0","1"],["1","0"]]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: matrix = [["0"]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] is '0' or '1'. 
// 
// Related Topics Array Dynamic Programming Matrix 👍 7244 👎 151


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] mat) {
        int M = mat.length, N = mat[0].length;
        int[][] dp = new int[M+1][N+1];

        int len = 0;
        for(int i = 1; i <= M; i ++){
            for(int j = 1; j <= N; j ++){
                if(mat[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    len = Math.max(len, dp[i][j]);
                    // System.out.printf("i:%d, j:%d, len:%d%n", i, j, len);
                }
            }
        }

        return len * len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
