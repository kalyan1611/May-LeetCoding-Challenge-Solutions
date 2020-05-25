class Solution {

    public int maxUncrossedLines(int[] A, int[] B) {

        int a = A.length;
        int b = B.length;
        int[][] dp = new int[a + 1][b + 1];
        
        for (int i = 1, a_i = i - 1; a_i < a; i++, a_i++) {
            for (int j = 1, b_j = j - 1; b_j < b; j++, b_j++) {
                if (A[a_i] == B[b_j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[a][b];
    }
}
