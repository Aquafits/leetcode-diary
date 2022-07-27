//You are given two lists of closed intervals, firstList and secondList, where 
//firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of 
//intervals is pairwise disjoint and in sorted order. 
//
// Return the intersection of these two interval lists. 
//
// A closed interval [a, b] (with a <= b) denotes the set of real numbers x 
//with a <= x <= b. 
//
// The intersection of two closed intervals is a set of real numbers that are 
//either empty or represented as a closed interval. For example, the intersection 
//of [1, 3] and [2, 4] is [2, 3]. 
//
// 
// Example 1: 
//
// 
//Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],
//[15,24],[25,26]]
//Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
// 
//
// Example 2: 
//
// 
//Input: firstList = [[1,3],[5,9]], secondList = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 0 <= firstList.length, secondList.length <= 1000 
// firstList.length + secondList.length >= 1 
// 0 <= starti < endi <= 10⁹ 
// endi < starti+1 
// 0 <= startj < endj <= 10⁹ 
// endj < startj+1 
// 
// Related Topics Array Two Pointers 👍 4413 👎 91


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // two pointers
        // move ptr that ends first
        List<int[]> resList = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < firstList.length && p2 < secondList.length) {
            int[] intersection = intersect(firstList[p1], secondList[p2]);
            if (intersection != null) {
                resList.add(intersection);
                System.out.printf("[%d, %d]%n", intersection[0], intersection[1]);
            }

            if (firstList[p1][1] < secondList[p2][1]) {
                p1++;
            } else {
                p2++;
            }
        }

        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }

        return res;
    }

    private int[] intersect(int[] a, int[] b) {
        if (a[1] > b[0] || b[1] > a[0]) return null;
        return new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
