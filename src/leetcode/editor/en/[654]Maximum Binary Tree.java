import leetcode.utils.TreeNode;

import java.util.Stack;

//You are given an integer array nums with no duplicates. A maximum binary tree
//can be built recursively from nums using the following algorithm: 
//
// 
// Create a root node whose value is the maximum value in nums. 
// Recursively build the left subtree on the subarray prefix to the left of the 
//maximum value. 
// Recursively build the right subtree on the subarray suffix to the right of 
//the maximum value. 
// 
//
// Return the maximum binary tree built from nums. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,2,1,6,0,5]
//Output: [6,3,5,null,2,0,null,null,1]
//Explanation: The recursive calls are as follow:
//- The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right 
//suffix is [0,5].
//    - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix 
//is [2,1].
//        - Empty array, so no child.
//        - The largest value in [2,1] is 2. Left prefix is [] and right suffix 
//is [1].
//            - Empty array, so no child.
//            - Only one element, so child is a node with value 1.
//    - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is 
//[].
//        - Only one element, so child is a node with value 0.
//        - Empty array, so no child.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1]
//Output: [3,null,2,null,1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// All integers in nums are unique. 
// 
// Related Topics Array Divide and Conquer Stack Tree Monotonic Stack Binary 
//Tree 👍 3274 👎 290
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        return getMax(nums, 0, nums.length - 1);
        return constructByStack(nums);
    }

    private TreeNode getMax(int[] nums, int l, int r) {
        if(l > r) return null;

        int maxId = l;
        int max = nums[l];
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                maxId = i;
                max = nums[i];
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = getMax(nums, l, maxId - 1);
        node.right = getMax(nums, maxId + 1, r);
        return node;
    }

    private TreeNode constructByStack(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(1000 + 10);
        stack.push(root);

        for(int n: nums) {
            TreeNode pop = null;
            TreeNode cur = new TreeNode(n);
            while(!stack.isEmpty() && n > stack.peek().val) {
                pop = stack.pop();
            }

            stack.peek().right = cur;
            stack.push(cur);
            cur.left = pop;
        }

        return root.right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
