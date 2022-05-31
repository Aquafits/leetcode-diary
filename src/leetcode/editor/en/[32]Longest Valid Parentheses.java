//Given a string containing just the characters '(' and ')', find the length of 
//the longest valid (well-formed) parentheses substring. 
//
// 
// Example 1: 
//
// 
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
// 
//
// Example 2: 
//
// 
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
// 
//
// Example 3: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] is '(', or ')'. 
// 
// Related Topics String Dynamic Programming Stack 👍 8706 👎 288


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int N = s.length();
        char[] cs = s.toCharArray();

        int[] stack = new int[N];
        int sz = 0;

        for (int i = 0; i < N; i++) {
            // System.out.printf("cur [%d]%c, top [%d]%c%n", i, cs[i], sz > 0 ? stack[sz - 1] : -1, sz > 0 ? cs[stack[sz - 1]] : '-');
            if (sz > 0 && cs[i] == ')' && cs[stack[sz - 1]] == '(') {
                cs[stack[sz - 1]] = '#';
                cs[i] = '#';
                sz--;
            } else {
                stack[sz++] = i;
            }
        }

        // find max continuous '#';
        int[] dp = stack;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (cs[i] == '#') {
                dp[i] = 1 + (i > 0 ? dp[i - 1] : 0);
            } else {
                dp[i] = 0;
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
