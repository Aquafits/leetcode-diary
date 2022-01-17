//Given an array of characters chars, compress it using the following algorithm:
// 
//
// Begin with an empty string s. For each group of consecutive repeating 
//characters in chars: 
//
// 
// If the group's length is 1, append the character to s. 
// Otherwise, append the character followed by the group's length. 
// 
//
// The compressed string s should not be returned separately, but instead, be 
//stored in the input character array chars. Note that group lengths that are 10 or 
//longer will be split into multiple characters in chars. 
//
// After you are done modifying the input array, return the new length of the 
//array. 
//
// You must write an algorithm that uses only constant extra space. 
//
// 
// Example 1: 
//
// 
//Input: chars = ["a","a","b","b","c","c","c"]
//Output: Return 6, and the first 6 characters of the input array should be: [
//"a","2","b","2","c","3"]
//Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3
//".
// 
//
// Example 2: 
//
// 
//Input: chars = ["a"]
//Output: Return 1, and the first character of the input array should be: ["a"]
//Explanation: The only group is "a", which remains uncompressed since it's a 
//single character.
// 
//
// Example 3: 
//
// 
//Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
//Output: Return 4, and the first 4 characters of the input array should be: [
//"a","b","1","2"].
//Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
// 
//
// 
// Constraints: 
//
// 
// 1 <= chars.length <= 2000 
// chars[i] is a lowercase English letter, uppercase English letter, digit, or 
//symbol. 
// 
// Related Topics Two Pointers String 👍 1815 👎 3935


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int leftBound = -1;

    public int compress(char[] cs) {
        int N = cs.length;
        int[] counter = new int[N];
        int j = 0;
        for (int i = 0; i < N; i++, j++) {
            cs[j] = cs[i];
            if (j == 0 || cs[j] != cs[j - 1]) {
                if (j > 0) {
                    j = writeNumber(cs, counter, j);
                }
                counter[j] = 1;
            } else {
                counter[j] = counter[j - 1] + 1;
            }
        }
        return writeNumber(cs, counter, j);
    }

    private int writeNumber(char[] cs, int[] counter, int j) {
        int cnt = counter[j - 1];
        if (cnt > 1) {
            int p = j - 1;
            while (p > leftBound && cs[p] == cs[j - 1]) {
                p--;
            }
            p += 2;

            for (char c : String.valueOf(cnt).toCharArray()) {
                cs[p++] = c;
            }
            if(j < cs.length && p < cs.length){
                cs[p] = cs[j];
            }
            j = p;
        }
//        System.out.println(new String(cs, 0, j));
        leftBound = j - 1;
        return j;
    }

    public static void main(String[] args){
        Solution sl = new Solution();
        sl.compress("eeee4444".toCharArray());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
