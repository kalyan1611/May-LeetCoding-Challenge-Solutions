class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int ar[] = new int[26];
        
        for(int i = 0; i < s1.length();i++) {
            ar[s1.charAt(i)-'a'] ++;
        }
        
        int br[] = new int[26];
        
        for(int i = 0; i < s1.length();i++) {
            br[s2.charAt(i)-'a'] ++;
        }
        if(compare(ar, br))
            return true;
        
        for(int i = s1.length(); i < s2.length();i ++) {
            br[s2.charAt(i) - 'a'] ++;
            br[s2.charAt(i - s1.length()) - 'a'] --;

            if(compare(ar, br))
                return true;
        }
        return false;
    }
    public boolean compare(int[] ar, int[] br) {
        for(int i = 0; i < 26;i++) {
            if(ar[i] != br[i])return false;
        }
        return true;
    }
}
