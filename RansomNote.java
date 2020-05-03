class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomNoteFrequency = new HashMap<>();
        HashMap<Character, Integer> magazineFrequency = new HashMap<>();
        for (int i=0; i<ransomNote.length(); i++) {
            Character ransomNoteChar = ransomNote.charAt(i);
            ransomNoteFrequency.put(ransomNoteChar, ransomNoteFrequency.getOrDefault(ransomNoteChar,0)+1);
        }
        for (int i=0; i<magazine.length(); i++) {
            Character magazineChar = magazine.charAt(i);
            magazineFrequency.put(magazineChar, magazineFrequency.getOrDefault(magazineChar,0)+1);
        }
        for (Character ranesomCharacter : ransomNoteFrequency.keySet()) {
            if (ransomNoteFrequency.get(ranesomCharacter) > magazineFrequency.getOrDefault(ranesomCharacter,0)) {
                return false;
            }
        }
        return true;
    }
}
