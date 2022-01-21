//Koko loves to eat bananas. There are n piles of bananas, the iᵗʰ pile has 
//piles[i] bananas. The guards have gone and will come back in h hours. 
//
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she 
//chooses some pile of bananas and eats k bananas from that pile. If the pile has less 
//than k bananas, she eats all of them instead and will not eat any more bananas 
//during this hour. 
//
// Koko likes to eat slowly but still wants to finish eating all the bananas 
//before the guards return. 
//
// Return the minimum integer k such that she can eat all the bananas within h 
//hours. 
//
// 
// Example 1: 
//
// 
//Input: piles = [3,6,7,11], h = 8
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: piles = [30,11,23,4,20], h = 5
//Output: 30
// 
//
// Example 3: 
//
// 
//Input: piles = [30,11,23,4,20], h = 6
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= piles.length <= 10⁴ 
// piles.length <= h <= 10⁹ 
// 1 <= piles[i] <= 10⁹ 
// 
// Related Topics Array Binary Search 👍 3458 👎 159


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int n : piles) r = Math.max(r, n);

        // min speed: 1, max speed: max(piles)
        while (l < r) {
            int speed = (l + r) >> 1;
//            System.out.printf("l:%d, r:%d, mid(speed): %d%n", l, r, speed);
            // [)[] left cannnot finish, right can finish
            if (goodSpeed(piles, h, speed)) {
                r = speed;
            } else {
                l = speed + 1;
            }
        }
        return l;
    }

    private boolean goodSpeed(int[] piles, int h, int speed) {
        int cnt = 0, i = 0;
        for (; i < piles.length && cnt <= h; i++) {
            cnt += (piles[i] + speed - 1) / speed;
        }
//        System.out.printf("speed: %d, cnt: %d, at pos: %d%n", speed, cnt, i);
        return cnt <= h && i == piles.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
