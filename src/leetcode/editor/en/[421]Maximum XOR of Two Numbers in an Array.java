//Given an integer array nums, return the maximum result of nums[i] XOR nums[j],
// where 0 <= i <= j < n. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,10,5,25,2,8]
//Output: 28
//Explanation: The maximum result is 5 XOR 25 = 28.
// 
//
// Example 2: 
//
// 
//Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//Output: 127
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// 0 <= nums[i] <= 2³¹ - 1 
// 
// Related Topics Array Hash Table Bit Manipulation Trie 👍 3888 👎 328


//leetcode submit region begin(Prohibit modification and deletion)
class Node {
    Node zero, one;
    int numCnt = 0;
}

class Trie {
    Node root = new Node();

    void insert(int num){
        Node p = root;
        for(int i = 31; i >=0; i --){
            if(((num >> i) & 1) == 1){
                if(p.one == null) p.one = new Node();
                p = p.one;
            } else {
                if(p.zero == null) p.zero = new Node();
                p = p.zero;
            }
        }
        p.numCnt ++;
    }

    int maxXOR(int num){
        Node p = root;
        int res = 0;
        for(int i = 31; i >=0; i --){
            if(((num >> i) & 1) == 1){
                if(p.zero != null) {
                    res += (1 << i);
                    p = p.zero;
                } else if(p.one != null) {
                    p = p.one;
                } else {
                    return 0;
                }
            } else {
                if(p.one != null) {
                    res += (1 << i);
                    p = p.one;
                } else if(p.zero != null) {
                    p = p.zero;
                } else {
                    return 0;
                }
            }
        }
        return res;
    }
}


class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int num: nums){
            trie.insert(num);
        }

        int max = 0;
        for(int num: nums){
            int curMax = trie.maxXOR(num);
            max = Math.max(max, curMax);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
