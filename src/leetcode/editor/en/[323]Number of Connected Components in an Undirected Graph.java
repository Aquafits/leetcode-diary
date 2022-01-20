//You have a graph of n nodes. You are given an integer n and an array edges 
//where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the 
//graph. 
//
// Return the number of connected components in the graph. 
//
// 
// Example 1: 
//
// 
//Input: n = 5, edges = [[0,1],[1,2],[3,4]]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2000 
// 1 <= edges.length <= 5000 
// edges[i].length == 2 
// 0 <= ai <= bi < n 
// ai != bi 
// There are no repeated edges. 
// 
// Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 17
//59 👎 55


//leetcode submit region begin(Prohibit modification and deletion)
class UnioinFind {
    int[] p;

    UnioinFind(int n) {
        p = new int[n];
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
    public int countComponents(int n, int[][] edges) {
        UnioinFind uf = new UnioinFind(n);
        int cnt = n;
        for (int[] edge : edges) {
            if (uf.find(edge[0]) != uf.find(edge[1])) {
                uf.union(edge[0], edge[1]);
                cnt--;
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
