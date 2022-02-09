//Given a string s, return true if the s can be palindrome after deleting at 
//most one character from it. 
//
// 
// Example 1: 
//
// 
//Input: s = "aba"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "abca"
//Output: true
//Explanation: You could delete the character 'c'.
// 
//
// Example 3: 
//
// 
//Input: s = "abc"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of lowercase English letters. 
// 
// Related Topics Two Pointers String Greedy 👍 3920 👎 234


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean validPalindrome(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = cs.length - 1;
        return validPalindrome(cs, l, r, 1);
    }

    private boolean validPalindrome(char[] cs, int l, int r, int mistake) {
        while (l <= r) {
            if (cs[l] != cs[r]) {
                if (mistake > 0) {
                    return validPalindrome(cs, l + 1, r, mistake - 1) ||
                            validPalindrome(cs, l, r - 1, mistake - 1);
                } else {
                    return false;
                }
            }
            l++;
            r--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
