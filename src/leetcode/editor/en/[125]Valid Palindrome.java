//A phrase is a palindrome if, after converting all uppercase letters into 
//lowercase letters and removing all non-alphanumeric characters, it reads the same 
//forward and backward. Alphanumeric characters include letters and numbers. 
//
// Given a string s, return true if it is a palindrome, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric 
//characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s consists only of printable ASCII characters. 
// 
// Related Topics Two Pointers String 👍 2926 👎 4705


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        int N = cs.length;
        int l = 0, r = N - 1;
        while (l < r) {
            if (!valid(cs[l])) {
                l++;
                continue;
            }

            if (!valid(cs[r])) {
                r--;
                continue;
            }
            if (!same(cs[l], cs[r])) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    private boolean valid(char c) {
        return Character.isDigit(c) || Character.isAlphabetic(c);
    }

    private boolean same(char c1, char c2) {
        if (Character.isAlphabetic(c1)) c1 = Character.toLowerCase(c1);
        if (Character.isAlphabetic(c2)) c2 = Character.toLowerCase(c2);
        return c1 == c2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
