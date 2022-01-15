//Given an array of intervals where intervals[i] = [starti, endi], merge all 
//overlapping intervals, and return an array of the non-overlapping intervals that 
//cover all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics Array Sorting 👍 11516 👎 473


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0]!=b[0]) return a[0]-b[0];
            else return b[1] - a[1];
        });

        List<int[]> resList = new ArrayList<>();
        resList.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] pre = resList.get(resList.size() - 1);
            int[] cur = intervals[i];
            if(pre[1] >= cur[0]){
                resList.set(resList.size() - 1, new int[]{pre[0], Math.max(pre[1], cur[1])});
            } else {
                resList.add(cur);
            }
        }

        int[][] res = new int[resList.size()][2];
        int i = 0;
        for(int[] itv: resList){
            res[i++] = itv;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
