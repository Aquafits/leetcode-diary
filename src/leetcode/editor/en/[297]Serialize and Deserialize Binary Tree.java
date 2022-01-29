//Serialization is the process of converting a data structure or object into a 
//sequence of bits so that it can be stored in a file or memory buffer, or 
//transmitted across a network connection link to be reconstructed later in the same or 
//another computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no 
//restriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this 
//string can be deserialized to the original tree structure. 
//
// Clarification: The input/output format is the same as how LeetCode 
//serializes a binary tree. You do not necessarily need to follow this format, so please be 
//creative and come up with different approaches yourself. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,null,4,5]
//Output: [1,2,3,null,null,4,5]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics String Tree Depth-First Search Breadth-First Search Design 
//Binary Tree 👍 5912 👎 233

import leetcode.utils.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int deserializeId = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // "id,v; ...."
        StringBuilder sb = new StringBuilder();
        serialize(sb, root);
        return sb.toString();
    }

    private void serialize(StringBuilder sb, TreeNode node) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(',');
        serialize(sb, node.left);
        serialize(sb, node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> values = Arrays.stream(data.split(","))
                .map(s -> "#".equals(s) ? null : Integer.parseInt(s))
                .collect(Collectors.toList());
        deserializeId = 0;
        return deserialize(null, values);
    }

    private TreeNode deserialize(TreeNode p, List<Integer> values) {
        if (p == null) {
            if (deserializeId >= values.size()) return null;
            Integer v = values.get(deserializeId++);
            if (v == null) return null;
            else p = new TreeNode(v);
        }
        p.left = deserialize(p.left, values);
        p.right = deserialize(p.right, values);
        return p;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
