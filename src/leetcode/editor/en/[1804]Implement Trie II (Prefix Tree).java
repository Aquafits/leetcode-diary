//A trie (pronounced as "try") or prefix tree is a tree data structure used to 
//efficiently store and retrieve keys in a dataset of strings. There are various 
//applications of this data structure, such as autocomplete and spellchecker. 
//
// Implement the Trie class: 
//
// 
// Trie() Initializes the trie object. 
// void insert(String word) Inserts the string word into the trie. 
// int countWordsEqualTo(String word) Returns the number of instances of the 
//string word in the trie. 
// int countWordsStartingWith(String prefix) Returns the number of strings in 
//the trie that have the string prefix as a prefix. 
// void erase(String word) Erases the string word from the trie. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Trie", "insert", "insert", "countWordsEqualTo", "countWordsStartingWith", 
//"erase", "countWordsEqualTo", "countWordsStartingWith", "erase", 
//"countWordsStartingWith"]
//[[], ["apple"], ["apple"], ["apple"], ["app"], ["apple"], ["apple"], ["app"], 
//["apple"], ["app"]]
//Output
//[null, null, null, 2, 2, null, 1, 1, null, 0]
//
//Explanation
//Trie trie = new Trie();
//trie.insert("apple");               // Inserts "apple".
//trie.insert("apple");               // Inserts another "apple".
//trie.countWordsEqualTo("apple");    // There are two instances of "apple" so 
//return 2.
//trie.countWordsStartingWith("app"); // "app" is a prefix of "apple" so return 
//2.
//trie.erase("apple");                // Erases one "apple".
//trie.countWordsEqualTo("apple");    // Now there is only one instance of 
//"apple" so return 1.
//trie.countWordsStartingWith("app"); // return 1
//trie.erase("apple");                // Erases "apple". Now the trie is empty.
//trie.countWordsStartingWith("app"); // return 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word and prefix consist only of lowercase English letters. 
// At most 3 * 10⁴ calls in total will be made to insert, countWordsEqualTo, 
//countWordsStartingWith, and erase. 
// It is guaranteed that for any function call to erase, the string word will 
//exist in the trie. 
// 
// Related Topics Hash Table String Design Trie 👍 160 👎 10


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    private Node root = new Node();

    public Trie() {

    }

    public void insert(String word) {
        char[] cs = word.toCharArray();
        Node p = root;
        for (char c : cs) {
            int i = c - 'a';
            if (p.next[i] == null) {
                p.next[i] = new Node();
            }
            p = p.next[i];
            p.prefixCount++;
        }
        p.wordCount++;
    }

    public int countWordsEqualTo(String word) {
        char[] cs = word.toCharArray();
        Node p = root;
        for (char c : cs) {
            int i = c - 'a';
            if (p.next[i] == null) {
                return 0;
            }
            p = p.next[i];
        }
        return p.wordCount;
    }

    public int countWordsStartingWith(String prefix) {
        char[] cs = prefix.toCharArray();
        Node p = root;
        for (char c : cs) {
            int i = c - 'a';
            if (p.next[i] == null) {
                return 0;
            }
            p = p.next[i];
        }
        return p.prefixCount;
    }

    public void erase(String word) {
        char[] cs = word.toCharArray();
        Node p = root;
        for (char c : cs) {
            int i = c - 'a';
            if (p.next[i] == null) {
                return;
            }
            p = p.next[i];
            p.prefixCount--;
        }
        p.wordCount--;
    }
}

class Node {
    Node[] next = new Node[26];
    int wordCount = 0;
    int prefixCount = 0;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
