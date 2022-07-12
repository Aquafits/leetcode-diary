//You are given an array routes representing bus routes where routes[i] is a 
//bus route that the iᵗʰ bus repeats forever. 
//
// 
// For example, if routes[0] = [1, 5, 7], this means that the 0ᵗʰ bus travels 
//in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever. 
// 
//
// You will start at the bus stop source (You are not on any bus initially), 
//and you want to go to the bus stop target. You can travel between bus stops by 
//buses only. 
//
// Return the least number of buses you must take to travel from source to 
//target. Return -1 if it is not possible. 
//
// 
// Example 1: 
//
// 
//Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//Output: 2
//Explanation: The best strategy is take the first bus to the bus stop 7, then 
//take the second bus to the bus stop 6.
// 
//
// Example 2: 
//
// 
//Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target =
// 12
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= routes.length <= 500. 
// 1 <= routes[i].length <= 10⁵ 
// All the values of routes[i] are unique. 
// sum(routes[i].length) <= 10⁵ 
// 0 <= routes[i][j] < 10⁶ 
// 0 <= source, target < 10⁶ 
// 
// Related Topics Array Hash Table Breadth-First Search 👍 1943 👎 49


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numBusesToDestination(int[][] routes, int src, int dst) {
        if(src == dst) return 0;

        Map<Integer, List<Integer>> stop2Buses = new HashMap<>();
        for (int busId = 0; busId < routes.length; busId++) {
            for (int stop : routes[busId]) {
                List<Integer> buses = stop2Buses.getOrDefault(stop, new ArrayList<>());
                buses.add(busId);
                stop2Buses.put(stop, buses);
            }
        }

        // state: (stop, )
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(src);
        boolean[] busVisited = new boolean[500 + 10];
        Set<Integer> stopVisited = new HashSet<>();
        int cnt = 0;
        while (!q.isEmpty()) {
            int layerSize = q.size();
            for (int i = 0; i < layerSize; i++) {
                int stop = q.poll();
                stopVisited.add(stop);
                if (stop == dst) {
                    return cnt;
                } else {
                    List<Integer> nextBuses = stop2Buses.get(stop);
                    for (int nextBus : nextBuses) {
                        if (busVisited[nextBus]) continue;
                        busVisited[nextBus] = true;
                        for (int nextStop : routes[nextBus]) {
                            if (stopVisited.contains(nextStop)) continue;
                            q.offer(nextStop);
                        }
                    }
                }
            }
            cnt++;
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
