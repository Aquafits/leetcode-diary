//You are given a string s and an integer k, a k duplicate removal consists of 
//choosing k adjacent and equal letters from s and removing them, causing the left 
//and the right side of the deleted substring to concatenate together. 
//
// We repeatedly make k duplicate removals on s until we no longer can. 
//
// Return the final string after all such duplicate removals have been made. It 
//is guaranteed that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcd", k = 2
//Output: "abcd"
//Explanation: There's nothing to delete. 
//
// Example 2: 
//
// 
//Input: s = "deeedbbcccbdaa", k = 3
//Output: "aa"
//Explanation: 
//First delete "eee" and "ccc", get "ddbbbdaa"
//Then delete "bbb", get "dddaa"
//Finally delete "ddd", get "aa" 
//
// Example 3: 
//
// 
//Input: s = "pbbcggttciiippooaais", k = 2
//Output: "ps"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// 2 <= k <= 10⁴ 
// s only contains lower case English letters. 
// 
// Related Topics String Stack 👍 2296 👎 48


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String s, int k) {
        int N = s.length();
        char[] cs = s.toCharArray();

        int[] counter = new int[N];
        int j = 0;
        for(int i = 0; i < N; i++, j++){
            cs[j] = cs[i];
            if(j == 0 || cs[j] != cs[j - 1]){
                counter[j] = 1;
            } else{
                counter[j] = counter[j - 1] + 1;
                if(counter[j] == k){
                    j -= k;
                }
            }
        }
        return new String(cs, 0, j);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
