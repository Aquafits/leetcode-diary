package leetcode.editor.en;
//You are given an integer array nums and you have to return a new counts array.
// The counts array has the property where counts[i] is the number of smaller 
//elements to the right of nums[i]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [5,2,6,1]
//Output: [2,1,1,0]
//Explanation:
//To the right of 5 there are 2 smaller elements (2 and 1).
//To the right of 2 there is only 1 smaller element (1).
//To the right of 6 there is 1 smaller element (1).
//To the right of 1 there is 0 smaller element.
// 
//
// Example 2: 
//
// 
//Input: nums = [-1]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: nums = [-1,-1]
//Output: [0,0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics Array Binary Search Divide and Conquer Binary Indexed Tree 
//Segment Tree Merge Sort Ordered Set 👍 4992 👎 148


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)

class TreeArray{
    int[] tr;
    int sz;

    public TreeArray(int sz) {
        this.sz = sz;
        this.tr = new int[sz + 1];
    }

    private int lowbit(int x) {
        return x & -x;
    }

    public int sums(int x){
        int sum = 0;
        for(int i = x; i > 0; i -= lowbit(i)) sum += tr[i];
        return sum;
    }

    public void add(int x, int v){
        for(int i = x; i <= sz; i += lowbit(i)) tr[i] += v;
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int N = nums.length;
        TreeArray tr = new TreeArray(20_000 + 10);
        List<Integer> res = new ArrayList<>(Collections.nCopies(N, 0));
        for (int i = N - 1; i >= 0; i--) {
            int x = nums[i] + 10_000 + 1;
            res.set(i, tr.sums(x - 1));
            tr.add(x, 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
