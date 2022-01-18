//There are n cities. Some of them are connected, while some are not. If city a 
//is connected directly with city b, and city b is connected directly with city c,
// then city a is connected indirectly with city c. 
//
// A province is a group of directly or indirectly connected cities and no 
//other cities outside of the group. 
//
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the 
//iᵗʰ city and the jᵗʰ city are directly connected, and isConnected[i][j] = 0 
//otherwise. 
//
// Return the total number of provinces. 
//
// 
// Example 1: 
//
// 
//Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] is 1 or 0. 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 44
//46 👎 218


//leetcode submit region begin(Prohibit modification and deletion)
class UnionFind {
    int[] p;

    UnionFind(int n) {
        this.p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    void union(int x, int y) {
        p[find(x)] = find(y);
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length, n = N;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isConnected[i][j] == 1 && uf.find(i) != uf.find(j)) {
                    uf.union(i, j);
                    n--;
                }
            }
        }
        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
