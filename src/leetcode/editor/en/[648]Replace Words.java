//In English, we have a concept called root, which can be followed by some 
//other word to form another longer word - let's call this word successor. For example,
// when the root "an" is followed by the successor word "other", we can form a 
//new word "another". 
//
// Given a dictionary consisting of many roots and a sentence consisting of 
//words separated by spaces, replace all the successors in the sentence with the root 
//forming it. If a successor can be replaced by more than one root, replace it 
//with the root that has the shortest length. 
//
// Return the sentence after the replacement. 
//
// 
// Example 1: 
//
// 
//Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled 
//by the battery"
//Output: "the cat was rat by the bat"
// 
//
// Example 2: 
//
// 
//Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
//Output: "a a b c"
// 
//
// 
// Constraints: 
//
// 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] consists of only lower-case letters. 
// 1 <= sentence.length <= 10⁶ 
// sentence consists of only lower-case letters and spaces. 
// The number of words in sentence is in the range [1, 1000] 
// The length of each word in sentence is in the range [1, 1000] 
// Every two consecutive words in sentence will be separated by exactly one 
//space. 
// sentence does not have leading or trailing spaces. 
// 
// Related Topics Array Hash Table String Trie 👍 1523 👎 153


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

    int prefixSearch(String s){
        Node p = root;
        int prefixCnt = 0;
        for(char c: s.toCharArray()){
            int i = c - 'a';
            if(p.next[i] == null){
                return -1;
            }
            p = p.next[i];
            prefixCnt ++;
            if(p.wordCnt > 0) {
                return prefixCnt;
            }
        }
        return -1;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String s: dictionary){
            trie.insert(s);
        }

        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++){
            String w = words[i];
            int prefixCnt = trie.prefixSearch(w);
            if(prefixCnt > 0){
                words[i] = words[i].substring(0, prefixCnt);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i ++){
            if(i != 0) sb.append(" ");
            sb.append(words[i]);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
