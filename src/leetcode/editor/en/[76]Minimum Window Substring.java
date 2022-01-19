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
        int[] counter = new int[128], target = new int[128];
        char[] scs = s.toCharArray(), tcs = t.toCharArray();
        int SN = scs.length, TN = tcs.length;
        for (char c : tcs) {
            target[c]++;
        }

        int l = 0, r = 0;
        String res = "";
        counter[scs[l]]++;
        while (r < SN) {
            while (r - l + 1 >= TN && contains(counter, target)) {
                if (res.equals("") || r - l + 1 < res.length()) {
                    res = s.substring(l, r + 1);
                }
                counter[scs[l]]--;
                l++;
            }
            r++;
            if (r < SN) counter[scs[r]]++; // ! array out of bound
        }
        return res;
    }

    private boolean contains(int[] counter, int[] target) {
        for (int i = 'a', j = 'A'; i <= 'z' && j <= 'Z'; i++, j++) {
            if (target[i] > 0 && counter[i] < target[i]) return false;
            if (target[j] > 0 && counter[j] < target[j]) return false;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
