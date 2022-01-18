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
        int SN = s.length(), TN = t.length();
        for (char c : tcs) {
            target[c]++;
        }

        int l = 0, r = 0;
        boolean found = false;
        int[] window = new int[2];
        counter[scs[0]]++;
        while (r < SN) {
            while (r - l + 1 >= TN && contains(counter, target)) {
                if (!found || r - l < window[1] - window[0]) {
                    window[1] = r;
                    window[0] = l;
                    found = true;
                }
                counter[scs[l]]--;
                l++;
            }
            r++;
            if (r < SN) counter[scs[r]]++;
        }

        return found ? s.substring(window[0], window[1] + 1) : "";
    }

    private boolean contains(int[] counter, int[] target) {
        for (int i = 'a'; i <= 'z'; i++) {
            if (target[i] > 0 && counter[i] < target[i]) {
                return false;
            }
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            if (target[i] > 0 && counter[i] < target[i]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
