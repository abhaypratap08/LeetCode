import java.util.List;

class Solution {
    static char[][] s = new char[100][100];
    static int n;
    static long[][][] dp = new long[100][100][2];
    static int modulo = (int)1e9+7;

    public int[] pathsWithMaxScore(List<String> board) {
        n = board.size();
        for (int i = 0; i < n; i++) {
            char[] a = board.get(i).toCharArray();
            for (int j = 0; j < n; j++) {
                s[i][j] = a[j];
                dp[i][j][0] = -1;
                dp[i][j][1] = 0;
            }
        }
        dp[n-1][n-1][0] = 0;
        dp[n-1][n-1][1] = 1;

        for (int i = n-2; i >= 0; i--) {
            if(s[n-1][i] == 'X')continue;
            if(dp[n-1][i+1][0] == -1)continue;
            dp[n-1][i][0] = dp[n-1][i+1][0]+(s[n-1][i]-'0');
            dp[n-1][i][1] = dp[n-1][i+1][1];
        }

        for (int i = n-2; i >= 0; i--) {
            if(s[i][n-1] == 'X')continue;
            if(dp[i+1][n-1][0] == -1)continue;
            dp[i][n-1][0] = dp[i+1][n-1][0]+(s[i][n-1]-'0');
            dp[i][n-1][1] = dp[i+1][n-1][1];
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                if(s[i][j] == 'X')continue;
                if(s[i][j] == 'E'){
                    long max = -1, path = 0;
                    if(dp[i+1][j][0] != -1){
                        max = dp[i+1][j][0];
                        path = dp[i+1][j][1]%modulo;
                    }
                    if(dp[i][j+1][0] != -1){
                        if(max <= dp[i][j+1][0]){
                            if(max == dp[i][j+1][0]){
                                path += dp[i][j+1][1]%modulo;
                            } else {
                                max = dp[i][j+1][0];
                                path = dp[i][j+1][1]%modulo;
                            }
                        }
                    }
                    if(dp[i+1][j+1][0] != -1){
                        if(max <= dp[i+1][j+1][0]){
                            if(max == dp[i+1][j+1][0]){
                                path += dp[i+1][j+1][1]%modulo;
                            } else {
                                max = dp[i+1][j+1][0];
                                path = dp[i+1][j+1][1]%modulo;
                            }
                        }
                    }
                    if(max == -1){
                        return new int[]{0,0};
                    }
                    dp[i][j][1] = dp[i+1][j][1]+dp[i][j+1][1]+dp[i+1][j+1][1];
                    return new int[]{(int) max, (int)(path%modulo)};
                } else {
                    long max = -1, path = 0;
                    if(dp[i+1][j][0] != -1){
                        max = dp[i+1][j][0];
                        path = dp[i+1][j][1]%modulo;
                    }
                    if(dp[i][j+1][0] != -1){
                        if(max <= dp[i][j+1][0]){
                            if(max == dp[i][j+1][0]){
                                path += dp[i][j+1][1]%modulo;
                            } else {
                                max = dp[i][j+1][0];
                                path = dp[i][j+1][1]%modulo;
                            }
                        }
                    }
                    if(dp[i+1][j+1][0] != -1){
                        if(max <= dp[i+1][j+1][0]){
                            if(max == dp[i+1][j+1][0]){
                                path += dp[i+1][j+1][1]%modulo;
                            } else {
                                max = dp[i+1][j+1][0];
                                path = dp[i+1][j+1][1]%modulo;
                            }
                        }
                    }
                    if(max == -1) continue;
                    dp[i][j][0] = max+(s[i][j]-'0');
                    dp[i][j][1] = path%modulo;
                }
            }
        }
        return null;
    }
}