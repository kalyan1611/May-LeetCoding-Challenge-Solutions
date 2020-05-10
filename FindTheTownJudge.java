class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if (N==1) {
            return 1;
        } else if (trust.length==0) {
            return -1;
        }
        
        // people who trust someone
        HashSet<Integer> trustees = new HashSet<>();
        // count of people who trust the person
        HashMap<Integer, Integer> trustCount = new HashMap<>();
        
        for (int i=0; i<trust.length; i++) {
            trustees.add(trust[i][0]);
            trustCount.put(trust[i][1], trustCount.getOrDefault(trust[i][1],0)+1);
        }
        if (trustees.size() != N-1) {
            return -1;
        }
        
        int judgeCandidate = 0;
        for (int i=1; i<=N; i++) {
            if (!trustees.contains(i)) {
                judgeCandidate = i;
            }
        }
        if (judgeCandidate==0 && trustCount.get(judgeCandidate)!=N-1) {
            return -1;
        }
        return judgeCandidate;
    }
}
