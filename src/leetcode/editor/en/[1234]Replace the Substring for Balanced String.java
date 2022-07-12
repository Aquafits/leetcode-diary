//You are given a string s of length n containing only four kinds of characters:
// 'Q', 'W', 'E', and 'R'. 
//
// A string is said to be balanced if each of its characters appears n / 4 
//times where n is the length of the string. 
//
// Return the minimum length of the substring that can be replaced with any 
//other string of the same length to make s balanced. If s is already balanced, 
//return 0. 
//
// 
// Example 1: 
//
// 
//Input: s = "QWER"
//Output: 0
//Explanation: s is already balanced.
// 
//
// Example 2: 
//
// 
//Input: s = "QQWE"
//Output: 1
//Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is 
//balanced.
// 
//
// Example 3: 
//
// 
//Input: s = "QQQW"
//Output: 2
//Explanation: We can replace the first "QQ" to "ER". 
// 
//
// 
// Constraints: 
//
// 
// n == s.length 
// 4 <= n <= 10⁵ 
// n is a multiple of 4. 
// s contains only 'Q', 'W', 'E', and 'R'. 
// 
// Related Topics String Sliding Window 👍 731 👎 152


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int balancedString(String s) {
        int N = s.length();
        int[] target = new int[4];
        Arrays.fill(target, - N / 4);
        char[] cs = s.toCharArray();
        for(int i = 0; i < N; i++) {
            if(cs[i] == 'Q') {
                target[0]++;
                cs[i] = 'A';
            } else if(cs[i] == 'W') {
                target[1]++;
                cs[i] = 'B';
            } else if (cs[i] == 'E') {
                target[2]++;
                cs[i] = 'C';
            } else if(cs[i] == 'R') {
                target[3]++;
                cs[i] = 'D';
            }
        }

        int l = 0;
        int[] count = new int[4];
        if(valid(count, target)) return 0;
        int window = N;
        for(int r = 0; r < N; r++) {
            count[cs[r] - 'A']++;
            while(valid(count, target) && l <= r) {
                window = Math.min(window, r - l + 1);
                count[cs[l++] - 'A']--;
            }
        }
        return window;
    }

    private boolean valid(int[] count, int[] target) {
        for(int i = 0; i <4; i ++){
            if(count[i] < target[i]) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
