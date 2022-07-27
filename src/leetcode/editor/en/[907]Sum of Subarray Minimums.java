//Given an array of integers arr, find the sum of min(b), where b ranges over 
//every (contiguous) subarray of arr. Since the answer may be large, return the 
//answer modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: arr = [3,1,2,4]
//Output: 17
//Explanation: 
//Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,
//2,4]. 
//Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
//Sum is 17.
// 
//
// Example 2: 
//
// 
//Input: arr = [11,81,94,43,3]
//Output: 444
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
//
// Related Topics Array Dynamic Programming Stack Monotonic Stack 👍 3896 👎 259
//


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] right = getNextLessOnRight(arr);
        int[] left = getNextLessOnLeft(arr);
        long res = 0;
        long MOD = 1000_000_000 + 7;
        for (int i = 0; i < arr.length; i++) {
//            System.out.printf("cur (i=%d, v = %d), left (i=%d, v = %d), right (i=%d, v = %d), left possibility = %d, right possibility = %d%n",
//                    i, arr[i], left[i] + 1, arr[left[i] + 1], right[i] - 1, arr[right[i] - 1], i - left[i], right[i] - i);
            res = (res + ((long) arr[i] * (i - left[i]) * (right[i] - i)) % MOD) % MOD;
        }
        return (int) res;
    }

    private int[] getNextLessOnRight(int[] arr) {
        int N = arr.length;
        int[] stack = new int[N];
        int[] right = new int[N];
        Arrays.fill(right, N);
        int sz = 0;
        for (int i = 0; i < N; i++) {
            while (sz > 0 && arr[i] <= arr[stack[sz - 1]]) {
                right[stack[sz - 1]] = i;
                sz--;
            }
            stack[sz++] = i;
        }
        return right;
    }

    private int[] getNextLessOnLeft(int[] arr) {
        int N = arr.length;
        int[] stack = new int[N];
        int[] left = new int[N];
        Arrays.fill(left, -1);
        int sz = 0;
        for (int i = N - 1; i >= 0; i--) {
            while (sz > 0 && arr[i] < arr[stack[sz - 1]]) {
                left[stack[sz - 1]] = i;
                sz--;
            }
            stack[sz++] = i;
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
