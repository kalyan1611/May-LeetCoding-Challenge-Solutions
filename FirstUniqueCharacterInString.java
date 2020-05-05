class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        int len = s.length();
        for (int i=0; i<len; i++) {
            Character c = s.charAt(i);
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c,0)+1);
        }
        for (int i=0; i<len; i++) {
            Character c = s.charAt(i);
            if (charFrequencyMap.get(c)==1) {
                return i;
            }
        }
        return -1;
    }
}
