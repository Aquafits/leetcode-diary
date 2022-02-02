//There are a total of numCourses courses you have to take, labeled from 0 to 
//numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
// 
//
// 
// For example, the pair [0, 1], indicates that to take course 0 you have to 
//first take course 1. 
// 
//
// Return true if you can finish all courses. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0. So it is possible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you 
//should also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 10⁵ 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// All the pairs prerequisites[i] are unique. 
// 
// Related Topics Depth-First Search Breadth-First Search Graph Topological 
//Sort 👍 8288 👎 322


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int N, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < N; i++) g.add(new ArrayList<>());
        int[] inDegrees = new int[N];
        for (int[] e : edges) {
            int to = e[0], from = e[1];
            g.get(from).add(to);
            inDegrees[to]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (inDegrees[i] == 0) {
                q.offerLast(i);
            }
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int t = q.pollFirst();
            cnt++;
            for (int i : g.get(t)) {
                inDegrees[i]--;
                if (inDegrees[i] == 0) {
                    q.offerLast(i);
                }
            }
        }

        return cnt == N;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
