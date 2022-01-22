//Given the availability time slots arrays slots1 and slots2 of two people and 
//a meeting duration duration, return the earliest time slot that works for both 
//of them and is of duration duration. 
//
// If there is no common time slot that satisfies the requirements, return an 
//empty array. 
//
// The format of a time slot is an array of two elements [start, end] 
//representing an inclusive time range from start to end. 
//
// It is guaranteed that no two availability slots of the same person intersect 
//with each other. That is, for any two time slots [start1, end1] and [start2, 
//end2] of the same person, either start1 > end2 or start2 > end1. 
//
// 
// Example 1: 
//
// 
//Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], 
//duration = 8
//Output: [60,68]
// 
//
// Example 2: 
//
// 
//Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], 
//duration = 12
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= slots1.length, slots2.length <= 10⁴ 
// slots1[i].length, slots2[i].length == 2 
// slots1[i][0] < slots1[i][1] 
// slots2[i][0] < slots2[i][1] 
// 0 <= slots1[i][j], slots2[i][j] <= 10⁹ 
// 1 <= duration <= 10⁶ 
// 
// Related Topics Array Two Pointers Sorting 👍 571 👎 25


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
//        return solve1(slots1, slots2, duration);
        return solve2(slots1, slots2, duration);
    }

    private List<Integer> solve1(int[][] slots1, int[][] slots2, int duration) {
        // double ptr
        slots1 = Arrays.stream(slots1).filter(s -> s[1] - s[0] >= duration).sorted(Comparator.comparingInt(s -> s[0])).toArray(int[][]::new);
        slots2 = Arrays.stream(slots2).filter(s -> s[1] - s[0] >= duration).sorted(Comparator.comparingInt(s -> s[0])).toArray(int[][]::new);
        int i = 0, j = 0;
        while (i < slots1.length && j < slots2.length) {
            int l = Math.max(slots1[i][0], slots2[j][0]), r = Math.min(slots1[i][1], slots2[j][1]);
            if (r - l >= duration) return Arrays.asList(l, l + duration);
            if (slots1[i][1] < slots2[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return new ArrayList<>();
    }

    private List<Integer> solve2(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s[0]));
        for (int[] s : slots1) if (s[1] - s[0] >= duration) pq.offer(s);
        for (int[] s : slots2) if (s[1] - s[0] >= duration) pq.offer(s);

        int[] pre = pq.poll();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = Math.min(pre[1], cur[1]);
            if (r - cur[0] >= duration) {
                return Arrays.asList(cur[0], cur[0] + duration);
            }
            pre = cur;
        }
        return new ArrayList<>();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
