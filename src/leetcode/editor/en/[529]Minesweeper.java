import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    private static final int[][] ACTIONS = new int[][]{
            {-1,-1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public char[][] updateBoard(char[][] bd, int[] s0) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(s0);
        while(!q.isEmpty()){
            int[] s = q.poll(); // s for state
            int x = s[0], y = s[1];
            List<int[]> nsList = visitAndGetNextStates(bd, x, y);
            if(nsList == null) continue;
            for(int[] ns: nsList){
                q.offer(ns);
            }
        }
        return bd;
    }

    private List<int[]> visitAndGetNextStates(char[][] bd, int x, int y){
        if(bd[x][y] == 'M') {
            bd[x][y] = 'X';
            return null;
        }
        if(bd[x][y] == 'B') {
            return null;
        }

        // count mines
        int cnt = 0;
        for(int[] a: ACTIONS){
            int nx = x + a[0], ny = y + a[1];
            if(nx < 0 || nx >= bd.length || ny < 0 || ny >= bd[0].length) continue;
            if(bd[nx][ny] == 'M') cnt ++;
        }

        // generate next states
        if(cnt == 0) {
            bd[x][y] = 'B';
            List<int[]> res = new ArrayList<>(8);
            for(int[] a: ACTIONS){
                int nx = x + a[0], ny = y + a[1];
                if(nx < 0 || nx >= bd.length || ny < 0 || ny >= bd[0].length || bd[nx][ny] != 'E') continue;
                res.add(new int[]{nx, ny});
            }
            return res;
        } else {
            bd[x][y] = (char)('0' + cnt);
            return null;
        }
    }
}