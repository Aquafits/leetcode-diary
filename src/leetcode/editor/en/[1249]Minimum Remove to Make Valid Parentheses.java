//Given a string s of '(' , ')' and lowercase English characters. 
//
// Your task is to remove the minimum number of parentheses ( '(' or ')', in 
//any positions ) so that the resulting parentheses string is valid and return any 
//valid string. 
//
// Formally, a parentheses string is valid if and only if: 
//
// 
// It is the empty string, contains only lowercase characters, or 
// It can be written as AB (A concatenated with B), where A and B are valid 
//strings, or 
// It can be written as (A), where A is a valid string. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
//Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
// 
//
// Example 2: 
//
// 
//Input: s = "a)b(c)d"
//Output: "ab(c)d"
// 
//
// Example 3: 
//
// 
//Input: s = "))(("
//Output: ""
//Explanation: An empty string is also valid.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is either'(' , ')', or lowercase English letter. 
// 
// Related Topics String Stack 👍 3456 👎 67


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] cs = s.toCharArray();
        int N = cs.length;
        int[] stack = new int[N];
        int sz = 0;

        for (int i = 0; i < N; i++) {
            char c = cs[i];
            if (c == '(') {
                stack[sz++] = i;
            } else if (c == ')') {
                if (sz > 0 && cs[stack[sz - 1]] == '(') {
                    sz--;
                } else {
                    stack[sz++] = i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sz; i++) {
            cs[stack[i]] = '\0';
        }
        for (char c : cs) {
            if (c != 0) sb.append(c);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
