//A parentheses string is valid if and only if: 
//
// 
// It is the empty string, 
// It can be written as AB (A concatenated with B), where A and B are valid 
//strings, or 
// It can be written as (A), where A is a valid string. 
// 
//
// You are given a parentheses string s. In one move, you can insert a 
//parenthesis at any position of the string. 
//
// 
// For example, if s = "()))", you can insert an opening parenthesis to be "(())
//)" or a closing parenthesis to be "())))". 
// 
//
// Return the minimum number of moves required to make s valid. 
//
// 
// Example 1: 
//
// 
//Input: s = "())"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: s = "((("
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s[i] is either '(' or ')'. 
// 
// Related Topics String Stack Greedy 👍 2171 👎 123


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minAddToMakeValid(String s) {
        char[] cs = s.toCharArray();
        int N = cs.length;
        boolean[] stack = new boolean[N];
        int sz = 0;
        for(int i = 0; i < N; i ++){
            if(sz > 0 && !stack[sz - 1] && cs[i] == ')'){
                sz --;
            } else {
                stack[sz ++] = cs[i] == ')';
            }
        }
        return sz;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
