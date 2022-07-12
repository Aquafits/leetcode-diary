//There are n dominoes in a line, and we place each domino vertically upright. 
//In the beginning, we simultaneously push some of the dominoes either to the left 
//or to the right. 
//
// After each second, each domino that is falling to the left pushes the 
//adjacent domino on the left. Similarly, the dominoes falling to the right push their 
//adjacent dominoes standing on the right. 
//
// When a vertical domino has dominoes falling on it from both sides, it stays 
//still due to the balance of the forces. 
//
// For the purposes of this question, we will consider that a falling domino 
//expends no additional force to a falling or already fallen domino. 
//
// You are given a string dominoes representing the initial state where: 
//
// 
// dominoes[i] = 'L', if the iᵗʰ domino has been pushed to the left, 
// dominoes[i] = 'R', if the iᵗʰ domino has been pushed to the right, and 
// dominoes[i] = '.', if the iᵗʰ domino has not been pushed. 
// 
//
// Return a string representing the final state. 
//
// 
// Example 1: 
//
// 
//Input: dominoes = "RR.L"
//Output: "RR.L"
//Explanation: The first domino expends no additional force on the second 
//domino.
// 
//
// Example 2: 
//
// 
//Input: dominoes = ".L.R...LR..L.."
//Output: "LL.RR.LLRRLL.."
// 
//
// 
// Constraints: 
//
// 
// n == dominoes.length 
// 1 <= n <= 10⁵ 
// dominoes[i] is either 'L', 'R', or '.'. 
// 
// Related Topics Two Pointers String Dynamic Programming 👍 1610 👎 109


import java.util.ArrayDeque;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String pushDominoes(String dominoes) {
        int N = dominoes.length();
        char[] cs = dominoes.toCharArray();

        int[] round = new int[N];
        Queue<Integer> q = new ArrayDeque<>();

        int r = 1;
        for(int i = 0; i < N; i ++){
            if(cs[i] == 'L' || cs[i] == 'R'){
                q.offer(i);
                round[i] = r;
            }
        }

        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i ++){
                int p = q.poll();
                if(cs[p] == 'L') {
                    if(p - 1 < 0) continue;
                    if(round[p - 1] == 0){
                        round[p - 1] = r + 1;
                        cs[p - 1] = 'L';
                        q.offer(p - 1);
                    } else if(round[p - 1] == r + 1 && cs[p - 1] == 'R'){
                        cs[p - 1] = '.';
                    }
                } else if (cs[p] == 'R'){
                    if(p + 1 > N - 1) continue;
                    if(round[p + 1] == 0){
                        round[p + 1] = r + 1;
                        cs[p + 1] = 'R';
                        q.offer(p + 1);
                    } else if(round[p + 1] == r + 1 && cs[p + 1] == 'L'){
                        cs[p + 1] = '.';
                    }
                }
            }
            r += 1;
        }

        return new String(cs);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
