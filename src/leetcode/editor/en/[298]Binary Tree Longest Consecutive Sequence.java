//Given the root of a binary tree, return the length of the longest consecutive 
//sequence path. 
//
// The path refers to any sequence of nodes from some starting node to any node 
//in the tree along the parent-child connections. The longest consecutive path 
//needs to be from parent to child (cannot be the reverse). 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,3,2,4,null,null,null,5]
//Output: 3
//Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
// 
//
// Example 2: 
//
// 
//Input: root = [2,null,3,2,null,1]
//Output: 2
//Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
//
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 3 * 10⁴]. 
// -3 * 10⁴ <= Node.val <= 3 * 10⁴ 
// 
// Related Topics Tree Depth-First Search Binary Tree 👍 835 👎 203

import leetcode.utils.TreeNode;

//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    int longest = 0;

    public int longestConsecutive(TreeNode root) {
        longestConsecutive(root, Integer.MIN_VALUE, 0);
        return longest;
    }

    private void longestConsecutive(TreeNode node, int parentVal, int preLen) {
        if (node == null) return;
        preLen = parentVal + 1 == node.val ? preLen + 1 : 1;
        longest = Math.max(longest, preLen);
        longestConsecutive(node.left, node.val, preLen);
        longestConsecutive(node.right, node.val, preLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
