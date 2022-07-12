//Given a string s and an integer k, return the number of substrings in s of 
//length k with no repeated characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "havefunonleetcode", k = 5
//Output: 6
//Explanation: There are 6 substrings they are: 'havef','avefu','vefun','efuno',
//'etcod','tcode'.
// 
//
// Example 2: 
//
// 
//Input: s = "home", k = 5
//Output: 0
//Explanation: Notice k can be larger than the length of s. In this case, it is 
//not possible to find any substring.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of lowercase English letters. 
// 1 <= k <= 10⁴ 
// 
// Related Topics Hash Table String Sliding Window 👍 429 👎 10


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        char[] cs = s.toCharArray();
        int N = cs.length;
        if(k > N) return 0;

        int cnt = 0;
        int[] window = new int[26];
        int l = 0, r = k - 1;
        for(int i = l; i <= k - 1; i ++) window[cs[i] - 'a'] ++;
        while(r < N){
            if(noRepetition(window)) cnt ++;
            window[cs[l] - 'a'] --;
            if(r + 1 < N) window[cs[r + 1] - 'a'] ++;
            l ++;
            r ++;
        }
        return cnt;
    }

    private boolean noRepetition(int[] window) {
        for(int cnt: window){
            if(cnt > 1) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
