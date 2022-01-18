//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is 
//included in the window. If there is no such substring, return the empty string 
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' 
//from string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
//Follow up: Could you find an algorithm that runs in O(m + n) time? Related 
//Topics Hash Table String Sliding Window 👍 9064 👎 510


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        int[] sCnt = new int[128], tCnt = new int[128];
        char[] scs = s.toCharArray(), tcs = t.toCharArray();
        for (char c : tcs) {
            tCnt[c]++;
        }

        int l = 0, r = 0, SN = scs.length, TN = tcs.length;
        sCnt[scs[l]]++;
        String res = "";
        while (r < SN) {
            while (r - l + 1 >= TN && goodWindow(sCnt, tCnt)) {
                if (res.equals("") || res.length() > r - l + 1) {
                    res = s.substring(l, r + 1);
                }
                sCnt[scs[l]]--;
                l++;
            }
            r++;
            if (r < SN) sCnt[scs[r]]++;
        }

        return res;
    }

    private boolean goodWindow(int[] sCnt, int[] tCnt) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (sCnt[i] < tCnt[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (sCnt[i] < tCnt[i]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
