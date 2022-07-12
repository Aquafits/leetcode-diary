//You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] 
//represents the width and the height of an envelope. 
//
// One envelope can fit into another if and only if both the width and height 
//of one envelope are greater than the other envelope's width and height. 
//
// Return the maximum number of envelopes you can Russian doll (i.e., put one 
//inside the other). 
//
// Note: You cannot rotate an envelope. 
//
// 
// Example 1: 
//
// 
//Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//Output: 3
//Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] 
//=> [5,4] => [6,7]).
// 
//
// Example 2: 
//
// 
//Input: envelopes = [[1,1],[1,1],[1,1]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
// Related Topics Array Binary Search Dynamic Programming Sorting 👍 4250 👎 104
//


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        return getLenOfLISByDim(envelopes, 1);
    }

    private int getLenOfLISByDim(int[][] arr, int dim) {
        int[] res = new int[arr.length];
        int sz = 0;
        for(int i = 0; i < arr.length; i ++) {
            int x = arr[i][dim];
            if(sz == 0 || x > res[sz - 1]) {
                res[sz ++] = x;
            } else {
                res[find(res, sz, x)] = x;
            }
        }
        return sz;
    }

    private int find(int[] arr, int sz, int target) {
        // find first pos that >= x [)[]
        int l = 0, r = sz - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            int x = arr[mid];

            if(x < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
