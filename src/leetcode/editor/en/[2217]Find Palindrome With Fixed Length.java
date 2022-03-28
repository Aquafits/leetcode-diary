//Given an integer array queries and a positive integer intLength, return an 
//array answer where answer[i] is either the queries[i]ᵗʰ smallest positive 
//palindrome of length intLength or -1 if no such palindrome exists. 
//
// A palindrome is a number that reads the same backwards and forwards. 
//Palindromes cannot have leading zeros. 
//
// 
// Example 1: 
//
// 
//Input: queries = [1,2,3,4,5,90], intLength = 3
//Output: [101,111,121,131,141,999]
//Explanation:
//The first few palindromes of length 3 are:
//101, 111, 121, 131, 141, 151, 161, 171, 181, 191, 201, ...
//The 90ᵗʰ palindrome of length 3 is 999.
// 
//
// Example 2: 
//
// 
//Input: queries = [2,4,6], intLength = 4
//Output: [1111,1331,1551]
//Explanation:
//The first six palindromes of length 4 are:
//1001, 1111, 1221, 1331, 1441, and 1551.
// 
//
// 
// Constraints: 
//
// 
// 1 <= queries.length <= 5 * 10⁴ 
// 1 <= queries[i] <= 10⁹ 
// 1 <= intLength <= 15 
// 
// Related Topics Math 👍 179 👎 130


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long[] kthPalindrome(int[] queries, int L) {
        long[] res = new long[queries.length];
        int[] arr = getArrangement(L);
        for(int i = 0; i < queries.length; i++) {
            res[i] = getKthPalindrome(queries[i], L, arr);
        }
        return res;
    }

    private long getKthPalindrome(int query, int L, int[] arr) {
        query = query - 1;
        int l = L % 2 == 0 ? L / 2 : (L + 1) / 2;
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= l; i++) {
            if(query >= arr[i - 1]) return -1;
            int d = query / arr[i];
            if(i == 1) d += 1;
            sb.append(d);
            query = query % arr[i];
        }

        String s = sb.toString();
        if(L % 2 == 1){
            sb.deleteCharAt(sb.length() - 1);
        }
        s += sb.reverse().toString();
        return Long.parseLong(s);
    }

    private int[] getArrangement(int L) {
        int l = L % 2 == 0 ? L / 2 : (L + 1) / 2;
        int[] arr = new int[l + 1];
        for(int i = l; i >= 0; i--) {
            if(i == l) {
                arr[i] = 1;
            } else if(i == 0){
                arr[i] = 9 * arr[i + 1];
            } else {
                arr[i] = 10 * arr[i + 1];
            }
        }
        return arr;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
