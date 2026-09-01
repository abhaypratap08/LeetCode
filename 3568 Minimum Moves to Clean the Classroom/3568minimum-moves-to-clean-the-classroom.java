// RECURSIVE APPROACH
// class Solution {
//     int m, n, maxEnergy, totalLitter;
//     int[][] litterId;
//     int[] dr = {-1, 1, 0, 0};
//     int[] dc = {0, 0, -1, 1};
//     boolean[][][][] visited;
//
//     public int minMoves(String[] classroom, int energy) {
//         m = classroom.length;
//         n = classroom[0].length();
//         maxEnergy = energy;
//         litterId = new int[m][n];
//
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 litterId[i][j] = -1;
//             }
//         }
//
//         int sr = 0, sc = 0;
//
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 char ch = classroom[i].charAt(j);
//
//                 if(ch == 'S') {
//                     sr = i;
//                     sc = j;
//                 } else if(ch == 'L') {
//                     litterId[i][j] = totalLitter++;
//                 }
//             }
//         }
//
//         if(totalLitter == 0) return 0;
//
//         visited = new boolean[m][n][1 << totalLitter][energy + 1];
//
//         int ans = fun(sr, sc, 0, energy, classroom);
//
//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
//
//     int fun(int r, int c, int mask, int energy, String[] classroom) {
//         if(mask == (1 << totalLitter) - 1) {
//             return 0;
//         }
//
//         if(visited[r][c][mask][energy]) {
//             return Integer.MAX_VALUE;
//         }
//
//         visited[r][c][mask][energy] = true;
//
//         int ans = Integer.MAX_VALUE;
//
//         if(energy > 0) {
//             for(int d = 0; d < 4; d++) {
//                 int nr = r + dr[d];
//                 int nc = c + dc[d];
//
//                 if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
//                 if(classroom[nr].charAt(nc) == 'X') continue;
//
//                 int newEnergy = energy - 1;
//                 int newMask = mask;
//                 char cell = classroom[nr].charAt(nc);
//
//                 if(cell == 'L') {
//                     newMask |= 1 << litterId[nr][nc];
//                 }
//
//                 if(cell == 'R') {
//                     newEnergy = maxEnergy;
//                 }
//
//                 int result = fun(nr, nc, newMask, newEnergy, classroom);
//
//                 if(result != Integer.MAX_VALUE) {
//                     ans = Math.min(ans, 1 + result);
//                 }
//             }
//         }
//
//         visited[r][c][mask][energy] = false;
//
//         return ans;
//     }
// }


// MEMOIZATION APPROACH
// class Solution {
//     int m, n, maxEnergy, totalLitter;
//     int[][] litterId;
//     int[] dr = {-1, 1, 0, 0};
//     int[] dc = {0, 0, -1, 1};
//     int[][][][] dp;
//     boolean[][][][] visiting;
//
//     public int minMoves(String[] classroom, int energy) {
//         m = classroom.length;
//         n = classroom[0].length();
//         maxEnergy = energy;
//         litterId = new int[m][n];
//
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 litterId[i][j] = -1;
//             }
//         }
//
//         int sr = 0, sc = 0;
//
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 char ch = classroom[i].charAt(j);
//
//                 if(ch == 'S') {
//                     sr = i;
//                     sc = j;
//                 } else if(ch == 'L') {
//                     litterId[i][j] = totalLitter++;
//                 }
//             }
//         }
//
//         if(totalLitter == 0) return 0;
//
//         int masks = 1 << totalLitter;
//
//         dp = new int[m][n][masks][energy + 1];
//         visiting = new boolean[m][n][masks][energy + 1];
//
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 for(int mask = 0; mask < masks; mask++) {
//                     java.util.Arrays.fill(dp[i][j][mask], -1);
//                 }
//             }
//         }
//
//         int ans = fun(sr, sc, 0, energy, classroom);
//
//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
//
//     int fun(int r, int c, int mask, int energy, String[] classroom) {
//         if(mask == (1 << totalLitter) - 1) {
//             return 0;
//         }
//
//         if(dp[r][c][mask][energy] != -1) {
//             return dp[r][c][mask][energy];
//         }
//
//         if(visiting[r][c][mask][energy]) {
//             return Integer.MAX_VALUE;
//         }
//
//         visiting[r][c][mask][energy] = true;
//
//         int ans = Integer.MAX_VALUE;
//
//         if(energy > 0) {
//             for(int d = 0; d < 4; d++) {
//                 int nr = r + dr[d];
//                 int nc = c + dc[d];
//
//                 if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
//                 if(classroom[nr].charAt(nc) == 'X') continue;
//
//                 int newEnergy = energy - 1;
//                 int newMask = mask;
//                 char cell = classroom[nr].charAt(nc);
//
//                 if(cell == 'L') {
//                     newMask |= 1 << litterId[nr][nc];
//                 }
//
//                 if(cell == 'R') {
//                     newEnergy = maxEnergy;
//                 }
//
//                 int result = fun(nr, nc, newMask, newEnergy, classroom);
//
//                 if(result != Integer.MAX_VALUE) {
//                     ans = Math.min(ans, 1 + result);
//                 }
//             }
//         }
//
//         visiting[r][c][mask][energy] = false;
//         dp[r][c][mask][energy] = ans;
//
//         return ans;
//     }
// }


// TABULATION / BFS APPROACH
import java.util.*;

class Solution {
    int m, n, maxEnergy, totalLitter;
    int[][] litterId;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int minMoves(String[] classroom, int energy) {
        m = classroom.length;
        n = classroom[0].length();
        maxEnergy = energy;
        litterId = new int[m][n];

        for(int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);
        }

        int sr = 0, sc = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if(ch == 'S') {
                    sr = i;
                    sc = j;
                } else if(ch == 'L') {
                    litterId[i][j] = totalLitter++;
                }
            }
        }

        if(totalLitter == 0) return 0;

        int masks = 1 << totalLitter;
        int allMask = masks - 1;

        boolean[][][][] visited =
            new boolean[m][n][masks][energy + 1];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sr, sc, 0, energy});
        visited[sr][sc][0][energy] = true;

        int moves = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                int[] state = q.poll();

                int r = state[0];
                int c = state[1];
                int mask = state[2];
                int currEnergy = state[3];

                if(mask == allMask) {
                    return moves;
                }

                if(currEnergy == 0) continue;

                for(int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if(classroom[nr].charAt(nc) == 'X') continue;

                    int newEnergy = currEnergy - 1;
                    int newMask = mask;
                    char cell = classroom[nr].charAt(nc);

                    if(cell == 'L') {
                        newMask |= 1 << litterId[nr][nc];
                    }

                    if(cell == 'R') {
                        newEnergy = maxEnergy;
                    }

                    if(!visited[nr][nc][newMask][newEnergy]) {
                        visited[nr][nc][newMask][newEnergy] = true;

                        q.offer(new int[]{
                            nr,
                            nc,
                            newMask,
                            newEnergy
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}