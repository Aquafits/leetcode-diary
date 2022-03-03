//You are given a string s. We want to partition the string into as many parts 
//as possible so that each letter appears in at most one part. 
//
// Note that the partition is done so that after concatenating all the parts in 
//order, the resultant string should be s. 
//
// Return a list of integers representing the size of these parts. 
//
// 
// Example 1: 
//
// 
//Input: s = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it 
//splits s into less parts.
// 
//
// Example 2: 
//
// 
//Input: s = "eccbbbbdec"
//Output: [10]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// s consists of lowercase English letters. 
// 
// Related Topics Hash Table Two Pointers String Greedy 👍 6284 👎 251


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] cs = s.toCharArray();
        int N = cs.length;
        int[] right = new int[26];
        for (int i = 0; i < N; i++) {
            right[cs[i] - 'a'] = i;
        }

        int l = 0, r = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < N; i ++){
            if(i > r){
                res.add(r - l + 1);
                l = i;
            }
            r = Math.max(r, right[cs[i] - 'a']);
        }
        res.add(r - l + 1);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
