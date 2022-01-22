//Given a string s, rearrange the characters of s so that any two adjacent 
//characters are not the same. 
//
// Return any possible rearrangement of s or return "" if not possible. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: "aba"
// Example 2: 
// Input: s = "aaab"
//Output: ""
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// s consists of lowercase English letters. 
// 
// Related Topics Hash Table String Greedy Sorting Heap (Priority Queue) 
//Counting 👍 4030 👎 168


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorganizeString(String s) {
        int N = s.length();
        char[] cs = s.toCharArray();
        int counter[] = new int[26];
        int max = 0, p = 0;
        for (int i = 0; i < N; i++) {
            int cid = cs[i] - 'a';
            counter[cid]++;
            if (counter[cid] > max) {
                max = counter[cid];
                p = cid;
            }
        }
        if (max > (N + 1) / 2) {
            return "";
        }

        for (int i = 0; i < N; i += 2) {
            if (counter[p] == 0) {
                p = 0;
                while (p < 26 && counter[p] == 0) p++;
            }
            cs[i] = (char) (p + 'a');
            counter[p]--;
            if (i % 2 == 0 && i + 2 >= N) i = -1;
        }
        return new String(cs);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
