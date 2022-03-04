//You have an inventory of different colored balls, and there is a customer 
//that wants orders balls of any color. 
//
// The customer weirdly values the colored balls. Each colored ball's value is 
//the number of balls of that color you currently have in your inventory. For 
//example, if you own 6 yellow balls, the customer would pay 6 for the first yellow 
//ball. After the transaction, there are only 5 yellow balls left, so the next 
//yellow ball is then valued at 5 (i.e., the value of the balls decreases as you sell 
//more to the customer). 
//
// You are given an integer array, inventory, where inventory[i] represents the 
//number of balls of the iᵗʰ color that you initially own. You are also given an 
//integer orders, which represents the total number of balls that the customer 
//wants. You can sell the balls in any order. 
//
// Return the maximum total value that you can attain after selling orders 
//colored balls. As the answer may be too large, return it modulo 109 + 7. 
//
// 
// Example 1: 
//
// 
//Input: inventory = [2,5], orders = 4
//Output: 14
//Explanation: Sell the 1st color 1 time (2) and the 2nd color 3 times (5 + 4 + 
//3).
//The maximum total value is 2 + 5 + 4 + 3 = 14.
// 
//
// Example 2: 
//
// 
//Input: inventory = [3,5], orders = 6
//Output: 19
//Explanation: Sell the 1st color 2 times (3 + 2) and the 2nd color 4 times (5 +
// 4 + 3 + 2).
//The maximum total value is 3 + 2 + 5 + 4 + 3 + 2 = 19.
// 
//
// 
// Constraints: 
//
// 
// 1 <= inventory.length <= 10⁵ 
// 1 <= inventory[i] <= 10⁹ 
// 1 <= orders <= min(sum(inventory[i]), 10⁹) 
// 
// Related Topics Array Math Binary Search Greedy Sorting Heap (Priority Queue) 
//👍 669 👎 250


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final long MOD = 1_000_000_007L;

    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        long profit = 0;
        // sell the rectangle
        //       a
        //       * * *
        //       * * * h0
        //       * * * h
        // * * * * * *
        int N = inventory.length;
        int a = 1, i = N - 1;
        while(i >= 0){
            int h = i==0? inventory[i] : inventory[i] - inventory[i - 1];
            int curPrice = inventory[i];
            if(orders >= a * h){
                int minPrice = inventory[i] - h + 1;
                long x = (long) a * h * (curPrice + minPrice) / 2;
                profit = addToProfit(profit, x);
                orders -= a * h;
//                System.out.printf("sold %d items, earned %d;%n", a * h, x);
            } else {
                h = orders / a;
                int minPrice = inventory[i] - h + 1;
                long x1 = (long) a * h * (curPrice + minPrice) / 2;
//                System.out.printf("sold %d items, earned %d;%n", a * h, x1);
                long x2 = (long) (orders % a) * (minPrice - 1);
//                System.out.printf("sold remaining %d items, earned %d;%n", orders % a, x2);
                profit = addToProfit(profit, x1 + x2);
                break;
            }
            i --;
            a ++;
        }
        return (int) profit;
    }

    private long addToProfit(long profit, long x){
        return (profit + x) % MOD;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
