class Solution {

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int countSquares(int[][] matrix) {
        int squares = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i > 0 && j > 0 && matrix[i][j] > 0) {
                    matrix[i][j] += min(matrix[i - 1][j - 1], matrix[i - 1][j], matrix[i][j - 1]);
                }
                squares += matrix[i][j];
            }
        }
        return squares;
    }
}
