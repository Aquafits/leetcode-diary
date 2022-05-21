//Given an m x n integers matrix, return the length of the longest increasing 
//path in matrix. 
//
// From each cell, you can either move in four directions: left, right, up, or 
//down. You may not move diagonally or move outside the boundary (i.e., wrap-
//around is not allowed). 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
//Output: 4
//Explanation: The longest increasing path is [1, 2, 6, 9].
// 
//
// Example 2: 
//
// 
//Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
//Output: 4
//Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally 
//is not allowed.
// 
//
// Example 3: 
//
// 
//Input: matrix = [[1]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
// Related Topics Dynamic Programming Depth-First Search Breadth-First Search 
//Graph Topological Sort Memoization 👍 6130 👎 96


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int M, N;

    public int longestIncreasingPath(int[][] matrix) {
        M = matrix.length;
        N = matrix[0].length;

        int[][] dp = new int[M][N];
        int max = 0;
        for(int i = 0; i < M; i ++) {
            for(int j = 0; j < N; j ++){
                max = Math.max(max, dfs(matrix, i, j, dp));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp){
        if(dp[i][j] != 0) return dp[i][j];

        int len = 1;
        for(int[] dir: DIRS){
            int x = i + dir[0], y = j + dir[1];
            if(x >= 0 && x < M && y >= 0 && y < N && matrix[x][y] > matrix[i][j]){
                len = Math.max(len, dfs(matrix, x, y, dp) + 1);
            }
        }

        dp[i][j] = len;
        return dp[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
