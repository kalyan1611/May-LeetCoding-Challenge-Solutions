class Solution {
    
    public void increaseFrequency(Map<Character,Integer> freqMap, Character c) {
        freqMap.put(c, freqMap.getOrDefault(c,0)+1);
    }
    
    public void decreaseFrequency(Map<Character,Integer> freqMap, Character c) {
        freqMap.put(c, freqMap.getOrDefault(c,0)-1);
        if (freqMap.get(c)==0) {
            freqMap.remove(c);
        }
    }
    
    public boolean isAnagram(Map<Character,Integer> stringMap, 
                             Map<Character,Integer> patternMap) {
        

        for (Character patternChar : patternMap.keySet()) {
            if (!stringMap.containsKey(patternChar) || 
                patternMap.get(patternChar) != stringMap.get(patternChar)) {        
                return false;
            }
        }
        for (Character stringChar : stringMap.keySet()) {
            if (!patternMap.containsKey(stringChar) || 
                patternMap.get(stringChar) != stringMap.get(stringChar)) {
                return false;
            }
        }
        System.out.println("Hit");
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        int lengthN = s.length();
        int lengthP = p.length();
        Map<Character, Integer> stringMap = new HashMap<>();
        Map<Character, Integer> patternMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        if (lengthN==0 || lengthP==0 || lengthN < lengthP) {
            return ans;
        }
        for (int i = 0; i<lengthP; i++) {
            increaseFrequency(stringMap, s.charAt(i));
            increaseFrequency(patternMap, p.charAt(i));
        }
        if (isAnagram(stringMap, patternMap)) {
            System.out.println("I am here");
            ans.add(0);
        }
        for (int i = lengthP; i < lengthN; i++) {
            Character expiredChar = s.charAt(i-lengthP);
            Character bornChar = s.charAt(i);
            if (expiredChar!=bornChar) {
                increaseFrequency(stringMap, bornChar);
                decreaseFrequency(stringMap, expiredChar);
            }
            if (isAnagram(stringMap, patternMap)) {
                ans.add(i-lengthP+1);
            }
        }
        return ans;
    }
}
