//A trie (pronounced as "try") or prefix tree is a tree data structure used to 
//efficiently store and retrieve keys in a dataset of strings. There are various 
//applications of this data structure, such as autocomplete and spellchecker. 
//
// Implement the Trie class: 
//
// 
// Trie() Initializes the trie object. 
// void insert(String word) Inserts the string word into the trie. 
// boolean search(String word) Returns true if the string word is in the trie (
//i.e., was inserted before), and false otherwise. 
// boolean startsWith(String prefix) Returns true if there is a previously 
//inserted string word that has the prefix prefix, and false otherwise. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//Output
//[null, null, true, false, true, null, true]
//
//Explanation
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // return True
//trie.search("app");     // return False
//trie.startsWith("app"); // return True
//trie.insert("app");
//trie.search("app");     // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word and prefix consist only of lowercase English letters. 
// At most 3 * 10⁴ calls in total will be made to insert, search, and 
//startsWith. 
// 
// Related Topics Hash Table String Design Trie 👍 6904 👎 91


//leetcode submit region begin(Prohibit modification and deletion)

class Trie {

    class Node {
        Node[] next = new Node[26];
        int count = 0;
    }

    private Node root = new Node();

    public Trie() {

    }

    public void insert(String word) {
        char[] cs = word.toCharArray();
        Node p = root;
        for (char ch : cs) {
            int i = ch - 'a';
            if (p.next[i] == null) {
                p.next[i] = new Node();
            }
            p = p.next[i];
        }
        p.count++;
    }

    public boolean search(String word) {
        char[] cs = word.toCharArray();
        Node p = root;
        for (char ch : cs) {
            int i = ch - 'a';
            if (p.next[i] == null) {
                return false;
            }
            p = p.next[i];
        }
        return p.count > 0;
    }

    public boolean startsWith(String prefix) {
        char[] cs = prefix.toCharArray();
        Node p = root;
        for (char ch : cs) {
            int i = ch - 'a';
            if (p.next[i] == null) {
                return false;
            }
            p = p.next[i];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
