//Given a string s, rearrange the characters of s so that any two adjacent 
//characters are not the same. 
//
// Return any possible rearrangement of s or return "" if not possible. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: "aba"
// Example 2: 
// Input: s = "aaab"
//Output: ""
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// s consists of lowercase English letters. 
// 
// Related Topics Hash Table String Greedy Sorting Heap (Priority Queue) 
//Counting 👍 4030 👎 168


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorganizeString(String s) {
        int N = s.length();
        char[] cs = s.toCharArray();

        // count every char
        int[] counter = new int[26];
        for (char c : cs) {
            counter[c - 'a']++;
        }
        int max = counter[0], ptr = 0;
        for(int i = 0; i < 26; i ++){
            if(counter[i] > max){
                max = counter[i];
                ptr = i;
            }
        }

        if(max > (N + 1) / 2){
            return  "";
        }

        // fill in as 0, 2, 4 , ..., 1, 3, 5 ...
        for(int i = 0; i < N; i += 2){
            if(counter[ptr] == 0){
                for(int p = 0; p < 26; p ++){
                    if(counter[p] > 0){
                        ptr = p;
                        break;
                    }
                }
            }
            cs[i] = (char) ('a' + ptr);
            counter[ptr] --;
            if(i % 2 == 0 && i + 2 >= N){
                i = -1;
            }
        }

        return new String(cs);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
