//Given a string s and an integer k, return the length of the longest substring 
//of s that contains at most k distinct characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "eceba", k = 2
//Output: 3
//Explanation: The substring is "ece" with length 3. 
//
// Example 2: 
//
// 
//Input: s = "aa", k = 1
//Output: 2
//Explanation: The substring is "aa" with length 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 0 <= k <= 50 
// 
// Related Topics Hash Table String Sliding Window 👍 2099 👎 64


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] cs = s.toCharArray();
        int N = cs.length;
        int[] counter = new int[128];
        counter[cs[0]]++;

        int l = 0, r = 0;
        int max = 0;
        while (l < N && r < N) {
            while (r < N && sizeOf(counter) <= k) {
                max = Math.max(max, r - l + 1);
                r++;
                if (r < N) counter[cs[r]]++;
            }
            if (l < N) counter[cs[l]]--;
            l++;
        }
        return max;
    }

    private int sizeOf(int[] counter) {
        int res = 0;
        for (int i = 0; i < 128; i++) {
            if (counter[i] > 0) res++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
