//You are given an undirected weighted graph of n nodes (0-indexed), 
//represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the 
//nodes a and b with a probability of success of traversing that edge succProb[i]. 
//
// Given two nodes start and end, find the path with the maximum probability of 
//success to go from start to end and return its success probability. 
//
// If there is no path from start to end, return 0. Your answer will be 
//accepted if it differs from the correct answer by at most 1e-5. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0
//, end = 2
//Output: 0.25000
//Explanation: There are two paths from start to end, one having a probability 
//of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
// 
//
// Example 2: 
//
// 
//
// 
//Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0
//, end = 2
//Output: 0.30000
// 
//
// Example 3: 
//
// 
//
// 
//Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
//Output: 0.00000
//Explanation: There is no path between 0 and 2.
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 10^4 
// 0 <= start, end < n 
// start != end 
// 0 <= a, b < n 
// a != b 
// 0 <= succProb.length == edges.length <= 2*10^4 
// 0 <= succProb[i] <= 1 
// There is at most one edge between every two nodes. 
// Related Topics Graph Heap (Priority Queue) Shortest Path 👍 1073 👎 24


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double maxProbability(int n, int[][] edges, double[] edgeProb, int start, int end) {
        HashMap<Integer, HashMap<Integer, Double>> adj = buildAdj(n, edges, edgeProb);
        double[] p = new double[n];
        p[start] = 1.0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int cur = q.poll();
            if(!adj.containsKey(cur)) continue;
            for(int next: adj.get(cur).keySet()){
                double newP = p[cur] * adj.get(cur).get(next);
                if(newP > p[next]){
                    p[next] = newP;
                    q.offer(next);
                }
            }
        }
        return p[end];
    }

    private HashMap<Integer, HashMap<Integer, Double>> buildAdj(int n, int[][] edges, double[] edgeProb) {
        HashMap<Integer, HashMap<Integer, Double>> adj = new HashMap<>(n);
        for(int i = 0; i < edges.length; i ++){
            int a = edges[i][0], b = edges[i][1];
            double p = edgeProb[i];

            HashMap<Integer, Double> adjOfA = adj.getOrDefault(a, new HashMap<>());
            adjOfA.put(b, p);
            adj.put(a, adjOfA);

            HashMap<Integer, Double> adjOfB = adj.getOrDefault(b, new HashMap<>());
            adjOfB.put(a, p);
            adj.put(b, adjOfB);
        }
        return adj;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
