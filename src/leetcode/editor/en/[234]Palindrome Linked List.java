//Given the head of a singly linked list, return true if it is a palindrome. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 10⁵]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in O(n) time and O(1) space? Related Topics Linked 
//List Two Pointers Stack Recursion 👍 7577 👎 496

import leetcode.utils.ListNode;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1, head), p1 = dummy, p2 = dummy;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        reverseNext(p1);
        p2 = p1.next;
        p1 = dummy.next;
        while (p2 != null) {
            if (p2.val != p1.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    private void reverseNext(ListNode dummy) {
        ListNode pre = dummy, cur = dummy.next;
        while (cur != null) {
            ListNode next = cur.next;
            if (pre == dummy) {
                cur.next = null;
            } else {
                cur.next = pre;
            }
            pre = cur;
            cur = next;
        }
        if (pre != dummy) dummy.next = pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
