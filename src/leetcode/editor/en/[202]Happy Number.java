//Write an algorithm to determine if a number n is happy. 
//
// A happy number is a number defined by the following process: 
//
// 
// Starting with any positive integer, replace the number by the sum of the 
//squares of its digits. 
// Repeat the process until the number equals 1 (where it will stay), or it 
//loops endlessly in a cycle which does not include 1. 
// Those numbers for which this process ends in 1 are happy. 
// 
//
// Return true if n is a happy number, and false if not. 
//
// 
// Example 1: 
//
// 
//Input: n = 19
//Output: true
//Explanation:
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
// 
//
// Example 2: 
//
// 
//Input: n = 2
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics Hash Table Math Two Pointers 👍 4531 👎 641


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int from) {
        return twoPointer(from);
    }

    private boolean onePointer(int from) {
        Set<Integer> visited = new HashSet<>();
        while (from != 1) {
            int to = generate(from);
            if (visited.contains(to)) {
                return false;
            }
            visited.add(from);
            from = to;
        }
        return true;
    }

    private boolean twoPointer(int from) {
        int p1 = from, p2 = generate(from);
        while (p1 != p2) {
            p1 = generate(p1);
            p2 = generate(p2);
            if (p2 == 1) return true;
            p2 = generate(p2);
            if (p2 == 1) return true;
        }
        return p1 == 1;
    }

    private int generate(int num) {
        int res = 0;
        while (num > 0) {
            int d = num % 10;
            num = num / 10;
            res += d * d;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
