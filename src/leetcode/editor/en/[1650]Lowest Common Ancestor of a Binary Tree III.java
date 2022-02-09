//Given two nodes of a binary tree p and q, return their lowest common ancestor 
//(LCA). 
//
// Each node will have a reference to its parent node. The definition for Node 
//is below: 
//
// 
//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node parent;
//}
// 
//
// According to the definition of LCA on Wikipedia: "The lowest common ancestor 
//of two nodes p and q in a tree T is the lowest node that has both p and q as 
//descendants (where we allow a node to be a descendant of itself)." 
//
// 
// Example 1: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
// 
//
// Example 2: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//Output: 5
//Explanation: The LCA of nodes 5 and 4 is 5 since a node can be a descendant 
//of itself according to the LCA definition.
// 
//
// Example 3: 
//
// 
//Input: root = [1,2], p = 1, q = 2
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 10⁵]. 
// -10⁹ <= Node.val <= 10⁹ 
// All Node.val are unique. 
// p != q 
// p and q exist in the tree. 
// 
// Related Topics Hash Table Tree Binary Tree 👍 714 👎 22


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    HashSet<Integer> ancestors;

    public Node lowestCommonAncestor(Node p, Node q) {
        ancestors = new HashSet<>();
        return lca(p, q);
    }

    private Node lca(Node p, Node q) {
        Node ptr = p;
        while(ptr != null){
            ancestors.add(ptr.val);
            ptr = ptr.parent;
        }
        ptr = q;
        while(ptr != null){
            if(ancestors.contains(ptr.val)) return ptr;
            ptr = ptr.parent;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
