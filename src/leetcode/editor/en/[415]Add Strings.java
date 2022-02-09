//Given two non-negative integers, num1 and num2 represented as string, return 
//the sum of num1 and num2 as a string. 
//
// You must solve the problem without using any built-in library for handling 
//large integers (such as BigInteger). You must also not convert the inputs to 
//integers directly. 
//
// 
// Example 1: 
//
// 
//Input: num1 = "11", num2 = "123"
//Output: "134"
// 
//
// Example 2: 
//
// 
//Input: num1 = "456", num2 = "77"
//Output: "533"
// 
//
// Example 3: 
//
// 
//Input: num1 = "0", num2 = "0"
//Output: "0"
// 
//
// 
// Constraints: 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 and num2 consist of only digits. 
// num1 and num2 don't have any leading zeros except for the zero itself. 
// 
// Related Topics Math String Simulation 👍 2875 👎 517


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        char[] cs1 = num1.toCharArray(), cs2 = num2.toCharArray();
        int p1 = cs1.length - 1, p2 = cs2.length - 1;
        StringBuilder sb = new StringBuilder();
        int value = 0, carry = 0; // value, carry-in
        while (p1 != -1 || p2 != -1) {
            value = carry;
            if (p1 != -1) {
                value += cs1[p1] - '0';
                p1 -= 1;
            }
            if (p2 != -1) {
                value += cs2[p2] - '0';
                p2 -= 1;
            }
            carry = value / 10;
            value = value % 10;
            sb.append(value);
        }
        if (carry != 0) sb.append(1);
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
