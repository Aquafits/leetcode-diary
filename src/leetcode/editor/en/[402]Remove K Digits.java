//Given string num representing a non-negative integer num, and an integer k, 
//return the smallest possible integer after removing k digits from num. 
//
// 
// Example 1: 
//
// 
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 
//which is the smallest.
// 
//
// Example 2: 
//
// 
//Input: num = "10200", k = 1
//Output: "200"
//Explanation: Remove the leading 1 and the number is 200. Note that the output 
//must not contain leading zeroes.
// 
//
// Example 3: 
//
// 
//Input: num = "10", k = 2
//Output: "0"
//Explanation: Remove all the digits from the number and it is left with 
//nothing which is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num consists of only digits. 
// num does not have any leading zeros except for the zero itself. 
// 
// Related Topics String Stack Greedy Monotonic Stack 👍 6309 👎 261


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        char[] cs = num.toCharArray();
        int N = cs.length;

        int[] stack = new int[N];
        int sz = 0;
        for (int i = 0; i < N; i++) {
            while (sz > 0 && cs[i] < cs[stack[sz - 1]] && k > 0) {
                sz--;
                k--;
            }
            stack[sz++] = i;
        }

        while (k > 0) {
            sz--;
            k--;
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZeroFlag = true;
        for (int i = 0; i < sz; i++) {
            char c = cs[stack[i]];
            if (c != '0' || !leadingZeroFlag) {
                leadingZeroFlag = false;
                sb.append(c);
            }
        }

        String s = sb.toString();
        if(s.equals("")) return "0";
        else return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
