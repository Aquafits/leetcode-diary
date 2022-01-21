//We have n jobs, where every job is scheduled to be done from startTime[i] to 
//endTime[i], obtaining a profit of profit[i]. 
//
// You're given the startTime, endTime and profit arrays, return the maximum 
//profit you can take such that there are no two jobs in the subset with overlapping 
//time range. 
//
// If you choose a job that ends at time X you will be able to start another 
//job that starts at time X. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//Output: 120
//Explanation: The subset chosen is the first and fourth job. 
//Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
// 
//
// Example 2: 
//
// 
//
// 
//Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70
//,60]
//Output: 150
//Explanation: The subset chosen is the first, fourth and fifth job. 
//Profit obtained 150 = 20 + 70 + 60.
// 
//
// Example 3: 
//
// 
//
// 
//Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
//Output: 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= startTime.length == endTime.length == profit.length <= 5 * 10⁴ 
// 1 <= startTime[i] < endTime[i] <= 10⁹ 
// 1 <= profit[i] <= 10⁴ 
// 
// Related Topics Array Binary Search Dynamic Programming Sorting 👍 2801 👎 30


import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int N = startTime.length;
        int[][] jobs = new int[N][3];
        for (int i = 0; i < N; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparingInt(j -> j[0]));
        // dp[i] = dp[find(job[i][1])] + profit[i], dp[i+1]

        int[] dp = new int[N + 1];
        for (int i = N - 1; i >= 0; i--) {
            int skip = dp[i + 1];
            int take = jobs[i][2]; // if you take, then you will get base profit;
            int nextId = find(jobs, jobs[i][1]);
            if (nextId > 0) take += dp[nextId];
            dp[i] = Math.max(skip, take);
        }

        return dp[0];
    }

    int find(int[][] jobs, int time) {
        // find the first job has a start time >= time
        //[)[]
        int l = 0, r = jobs.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (jobs[mid][0] >= time) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (jobs[l][0] >= time) {
            return l;
        } else {
            return -l - 1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
