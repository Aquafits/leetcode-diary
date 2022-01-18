//Given a pattern and a string s, find if s follows the same pattern. 
//
// Here follow means a full match, such that there is a bijection between a 
//letter in pattern and a non-empty word in s. 
//
// 
// Example 1: 
//
// 
//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: pattern = "abba", s = "dog cat cat fish"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: pattern = "aaaa", s = "dog cat cat dog"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= pattern.length <= 300 
// pattern contains only lower-case English letters. 
// 1 <= s.length <= 3000 
// s contains only lowercase English letters and spaces ' '. 
// s does not contain any leading or trailing spaces. 
// All the words in s are separated by a single space. 
// 
// Related Topics Hash Table String 👍 3128 👎 360


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] c2str = new String[26];
        Map<String, Character> str2c = new HashMap<>();
        String[] strs = s.split(" ");
        if (strs.length != pattern.length()) return false;

        for (int i = 0; i < strs.length; i++) {
            char c = pattern.charAt(i);
            String str = strs[i];

            if (c2str[c-'a'] != null && !c2str[c-'a'].equals(str)) return false;
            if (str2c.containsKey(str) && !str2c.get(str).equals(c)) return false;
            c2str[c-'a'] = str;
            str2c.put(str, c);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
