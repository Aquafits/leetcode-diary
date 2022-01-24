//You are given two strings order and s. All the words of order are unique and 
//were sorted in some custom order previously. 
//
// Permute the characters of s so that they match the order that order was 
//sorted. More specifically, if a character x occurs before a character y in order, 
//then x should occur before y in the permuted string. 
//
// Return any permutation of s that satisfies this property. 
//
// 
// Example 1: 
//
// 
//Input: order = "cba", s = "abcd"
//Output: "cbad"
//Explanation: 
//"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", 
//"b", and "a". 
//Since "d" does not appear in order, it can be at any position in the returned 
//string. "dcba", "cdba", "cbda" are also valid outputs.
// 
//
// Example 2: 
//
// 
//Input: order = "cbafg", s = "abcd"
//Output: "cbad"
// 
//
// 
// Constraints: 
//
// 
// 1 <= order.length <= 26 
// 1 <= s.length <= 200 
// order and s consist of lowercase English letters. 
// All the characters of order are unique. 
// 
// Related Topics Hash Table String Sorting 👍 1746 👎 266


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String customSortString(String order, String s) {
        int[] orders = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orders[order.charAt(i) - 'a'] = i + 1;
        }

        List<Character> cs = new ArrayList<>();
        for (char c : s.toCharArray()) cs.add(c);
        cs.sort(Comparator.comparingInt(c -> orders[c - 'a']));
        StringBuilder sb = new StringBuilder();
        for (char c : cs) sb.append(c);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
