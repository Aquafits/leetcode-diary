//Given an integer array arr, and an integer target, return the number of 
//tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target. 
//
// As the answer can be very large, return it modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
//Output: 20
//Explanation: 
//Enumerating by the values (arr[i], arr[j], arr[k]):
//(1, 2, 5) occurs 8 times;
//(1, 3, 4) occurs 8 times;
//(2, 2, 4) occurs 2 times;
//(2, 3, 3) occurs 2 times.
// 
//
// Example 2: 
//
// 
//Input: arr = [1,1,2,2,2,2], target = 5
//Output: 12
//Explanation: 
//arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
//We choose one 1 from [1,1] in 2 ways,
//and two 2s from [2,2,2,2] in 6 ways.
// 
//
// 
// Constraints: 
//
// 
// 3 <= arr.length <= 3000 
// 0 <= arr[i] <= 100 
// 0 <= target <= 300 
// 
// Related Topics Array Hash Table Two Pointers Sorting Counting 👍 895 👎 145


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int MOD = 1000000007;

    public int threeSumMulti(int[] arr, int target) {
        long[] n2f = new long[101];
        for(int n: arr) n2f[n] += 1;

        long res = 0;
        for(int n1 = 0; n1 < 101; n1 ++){
            if(n2f[n1] == 0) continue;
            // pick first num
            long x1 = n2f[n1];
            n2f[n1] --;

            for(int n2 = n1; n2 < 101; n2 ++){
                if(n2f[n2] == 0) continue;
                // pick second num;
                long x2 = n2f[n2];
                n2f[n2] --;

                // pick third num
                int n3 = target - n1 - n2;
                if(n3 >= n2 && n3 <= 100 && n2f[n3] > 0) {
                    long x3 = n2f[n3];
                    if(n1 == n2 && n2 == n3) {
                        // System.out.printf("%d(%d), %d(%d), %d(%d): %d%n", n1, x1, n2, x2, n3, x3, x1 * x2 * x3 / 6);
                        res += x1 * x2 * x3 / 6;
                    } else if ((n1 < n2 && n2 == n3) || (n1 == n2 && n2 < n3)) {
                        // System.out.printf("%d(%d), %d(%d), %d(%d): %d%n", n1, x1, n2, x2, n3, x3, x1 * x2 * x3 / 2);
                        res += x1 * x2 * x3 / 2;
                    } else if (n1 < n2 && n2 < n3) {
                        // System.out.printf("%d(%d), %d(%d), %d(%d): %d%n", n1, x1, n2, x2, n3, x3, x1 * x2 * x3);
                        res += x1 * x2 * x3;
                    }
                    res %= MOD;
                }
                n2f[n2] ++;
            }
            n2f[n1] ++;
        }

        return (int) res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
