//Given an array of strings words (without duplicates), return all the 
//concatenated words in the given list of words. 
//
// A concatenated word is defined as a string that is comprised entirely of at 
//least two shorter words in the given array. 
//
// 
// Example 1: 
//
// 
//Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog",
//"hippopotamuses","rat","ratcatdogcat"]
//Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
//Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
//"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
//"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat". 
//
// Example 2: 
//
// 
//Input: words = ["cat","dog","catdog"]
//Output: ["catdog"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 10⁴ 
// 0 <= words[i].length <= 30 
// words[i] consists of only lowercase English letters. 
// 0 <= sum(words[i].length) <= 10⁵ 
// 
// Related Topics Array String Dynamic Programming Depth-First Search Trie 👍 19
//09 👎 224


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Node {
    char c;
    Node[] next = new Node[26];
    int wordCnt = 0;

    Node(char c){
        this.c = c;
    }
}

class Trie {

    Node root = new Node(' ');

    void insert(String s){
        Node p = root;
        for(char c: s.toCharArray()){
            int i = c - 'a';
            if(p.next[i] == null){
                p.next[i] = new Node(c);
            }
            p = p.next[i];
        }
        p.wordCnt ++;
    }

    boolean concatenatedSearch(char[] cs, int l, int cnt){
        if(l == cs.length && cnt >= 2) {
            return true;
        }

        int r = l;
        Node p = root;
        for(; r < cs.length; r ++){
            int i = cs[r] - 'a';
            if(p.next[i] == null) {
                return false;
            }
            p = p.next[i];
            if(p.wordCnt > 0 && concatenatedSearch(cs, r + 1, cnt + 1)) {
                return true;
            }
        }

        return false;
    }
}


class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Trie trie = new Trie();
        for(String w: words) {
            trie.insert(w);
        }

        for(String w: words){
            char[] cs = w.toCharArray();
            if(trie.concatenatedSearch(cs, 0, 0)) {
                res.add(w);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
