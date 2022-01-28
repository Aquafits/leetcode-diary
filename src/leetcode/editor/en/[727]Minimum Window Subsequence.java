//Given strings s1 and s2, return the minimum contiguous substring part of s1, 
//so that s2 is a subsequence of the part. 
//
// If there is no such window in s1 that covers all characters in s2, return 
//the empty string "". If there are multiple such minimum-length windows, return the 
//one with the left-most starting index. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "abcdebdde", s2 = "bde"
//Output: "bcde"
//Explanation: 
//"bcde" is the answer because it occurs before "bdde" which has the same 
//length.
//"deb" is not a smaller window because the elements of s2 in the window must 
//occur in order.
// 
//
// Example 2: 
//
// 
//Input: s1 = "jmeqksfrsdcmsiwvaovztaqenprpvnbstl", s2 = "u"
//Output: ""
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length <= 2 * 10⁴ 
// 1 <= s2.length <= 100 
// s1 and s2 consist of lowercase English letters. 
// 
// Related Topics String Dynamic Programming Sliding Window 👍 1158 👎 69


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
// dp: https://leetcode.com/problems/minimum-window-subsequence/discuss/909321/Most-simple-DP-solution-oror-Java-oror-(O(st))
class Solution {
    public String minWindow(String s1, String s2) {
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int l = 0, r = -1;
        int[] window = null;
        while (l < cs1.length) {
            r = find(cs1, cs2, l);
            l = improve(cs1, cs2, r);
            if (r == -1 || l == -1) break;
            if (window == null || r - l < window[1] - window[0]) window = new int[]{l, r};
            l++;
        }
        if (window == null) return "";
        else return s1.substring(window[0], window[1] + 1);
    }

    private int find(char[] cs1, char[] cs2, int l) {
        if (l == -1) return -1;
        int i = l, j = 0;
        while (i < cs1.length && j < cs2.length) {
            if (cs1[i] == cs2[j]) j++;
            i++;
        }
        if (j == cs2.length) return i - 1;
        else return -1;
    }


    private int improve(char[] cs1, char[] cs2, int r) {
        if (r == -1) return -1;
        int i = r, j = cs2.length - 1;
        while (i >= 0 && j >= 0) {
            if (cs1[i] == cs2[j]) j--;
            i--;
        }
        if (j == -1) return i + 1;
        else return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
