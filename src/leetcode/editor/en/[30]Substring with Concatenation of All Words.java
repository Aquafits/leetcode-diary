//You are given a string s and an array of strings words of the same length. 
//Return all starting indices of substring(s) in s that is a concatenation of each 
//word in words exactly once, in any order, and without any intervening characters. 
//
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "barfoothefoobarman", words = ["foo","bar"]
//Output: [0,9]
//Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" 
//respectively.
//The output order does not matter, returning [9,0] is fine too.
// 
//
// Example 2: 
//
// 
//Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//Output: []
// 
//
// Example 3: 
//
// 
//Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//Output: [6,9,12]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of lower-case English letters. 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] consists of lower-case English letters. 
// 
// Related Topics Hash Table String Sliding Window 👍 1840 👎 1808


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int N = s.length();
        int wordCnt = words.length, wordLen = words[0].length();
        HashMap<String, Integer> target = new HashMap<>();
        for (String word : words) {
            target.put(word, target.getOrDefault(word, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int start = 0; start < wordLen; start++) {
            LinkedHashMap<String, Integer> seen = new LinkedHashMap<>();
            int windowLen = wordCnt * wordLen;
            for (int l = start, r = start + windowLen - 1; r < N; l += wordLen, r += wordLen) {
                if (l == start) {
                    seen.clear();
                    for (int i = 0; i < wordCnt; i++) {
                        String word = s.substring(l + i * wordLen, l + (i + 1) * wordLen);
                        seen.put(word, seen.getOrDefault(word, 0) + 1);
                    }
                } else {
                    String toAdd = s.substring(r + 1 - wordLen, r + 1);
                    String toRemove = s.substring(l - wordLen, l);

                    int toRemoveVal = seen.getOrDefault(toRemove, 0) - 1;
                    if (toRemoveVal == 0) {
                        seen.remove(toRemove);
                    } else {
                        seen.put(toRemove, toRemoveVal);
                    }
                    seen.put(toAdd, seen.getOrDefault(toAdd, 0) + 1);
                }
                if (same(seen, target)) {
                    res.add(l);
                }
            }
        }
        return res;
    }

    private boolean same(LinkedHashMap<String, Integer> seen, HashMap<String, Integer> target) {
        for (String word : target.keySet()) {
            if (!seen.containsKey(word) || !seen.get(word).equals(target.get(word))) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
