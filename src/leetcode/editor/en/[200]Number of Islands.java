package leetcode.editor.en;
//Given an m x n 2D binary grid grid which represents a map of '1's (land) and
//'0's (water), return the number of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all 
//surrounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Matrix 👍 11772 👎 301


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int M, N;
    public int numIslands(char[][] grid) {
        M = grid.length;
        N = grid[0].length;
        int cnt = 0;
        for(int i = 0; i < M; i ++){
            for(int j = 0; j < N; j ++){
                if(grid[i][j] == '1'){
                    mark(grid, i, j);
                    cnt ++;
                }
            }
        }
        return cnt;
    }

    private void mark(char[][] grid, int i, int j){
        if(i < 0 || i >= M || j < 0 || j >= N || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = 'M';
        mark(grid, i - 1, j);
        mark(grid, i + 1, j);
        mark(grid, i, j - 1);
        mark(grid, i, j + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
