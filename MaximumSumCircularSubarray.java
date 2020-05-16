class Solution {

    public int kadaneSum(int[] A, int n) {
        
        int sumSoFar = 0;
        int maxSoFar = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            sumSoFar += A[i];
            if (sumSoFar < A[i]) {
                sumSoFar = A[i];
            }
            maxSoFar = Math.max(maxSoFar, sumSoFar);
        }
        
        return maxSoFar;
    }

    public int maxSubarraySumCircular(int[] A) {
        
        int length = A.length;
        int maxUnWrapped = kadaneSum(A, length);
        
        int totalSum = 0;
        for (int i = 0; i < length; i++) {
            totalSum += A[i];
            A[i] = -1 * A[i];
        }
        
        int maxWrapped = totalSum + kadaneSum(A, length);
        if (maxWrapped == 0) {
            maxWrapped = Integer.MIN_VALUE;
        }
        
        return Math.max(maxUnWrapped, maxWrapped);
    }
}
