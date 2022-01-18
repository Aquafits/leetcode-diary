//You are given a list of songs where the iᵗʰ song has a duration of time[i] 
//seconds. 
//
// Return the number of pairs of songs for which their total duration in 
//seconds is divisible by 60. Formally, we want the number of indices i, j such that i < 
//j with (time[i] + time[j]) % 60 == 0. 
//
// 
// Example 1: 
//
// 
//Input: time = [30,20,150,100,40]
//Output: 3
//Explanation: Three pairs have a total duration divisible by 60:
//(time[0] = 30, time[2] = 150): total duration 180
//(time[1] = 20, time[3] = 100): total duration 120
//(time[1] = 20, time[4] = 40): total duration 60
// 
//
// Example 2: 
//
// 
//Input: time = [60,60,60]
//Output: 3
//Explanation: All three pairs have a total duration of 120, which is divisible 
//by 60.
// 
//
// 
// Constraints: 
//
// 
// 1 <= time.length <= 6 * 10⁴ 
// 1 <= time[i] <= 500 
// 
// Related Topics Array Hash Table Counting 👍 2840 👎 108


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> mod2Cnt = new HashMap<>();
        for (int t : time) {
            int mod = t % 60;
            Integer cnt = mod2Cnt.getOrDefault(mod, 0);
            cnt += 1;
            mod2Cnt.put(mod, cnt);
        }

        int res = 0;
        for (int mod : mod2Cnt.keySet()) {
            if (mod == 0 || mod == 30) {
                int n = mod2Cnt.get(mod);
                res += n * (n - 1) / 2;
            } else if (mod > 0 && mod < 30) {
                if (!mod2Cnt.containsKey(60 - mod)) continue;
                int n = mod2Cnt.get(mod), m = mod2Cnt.get(60 - mod);
                res += n * m;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
