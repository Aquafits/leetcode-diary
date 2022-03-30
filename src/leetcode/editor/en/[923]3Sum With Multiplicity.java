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
    private static final int MOD = 1000_000_000 + 7;

    public int threeSumMulti(int[] arr, int target) {
        long[] freq = new long[101];
        for (int n : arr) freq[n]++;

        long res = 0;
        for (int i = 0; i < 101 && i < 1 + target / 3; i++) {
            if (freq[i] == 0) continue;
            long f1 = freq[i];
            freq[i]--;

            for (int j = i; j < 101 && j < 1 + (target - i) / 2; j++) {
                if (freq[j] == 0) continue;
                long f2 = freq[j];
                freq[j]--;

                int k = target - i - j;
                if(k >= j && k <= 100 && freq[k] > 0) {
                    long f3 = freq[k];
                    if (i == j && j == k) {
                        res += f1 * f2 * f3 / 6;
                    } else if ((i == j && j < k) || (i < j && j == k)) {
                        res += f1 * f2 * f3 / 2;
                    } else if (i < j && j < k) {
                        res += f1 * f2 * f3;
                    }
                    res %= MOD;
                }
                freq[j]++;
            }
            freq[i]++;
        }
        return (int) res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
