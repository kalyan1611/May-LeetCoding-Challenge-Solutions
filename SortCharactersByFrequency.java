class Solution {

    public String frequencySort(String s) {

        int len = s.length();
        
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Character c = s.charAt(i);
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        }

        List<FreqCharPair> list = new ArrayList<>();
        for (Character character: charFreqMap.keySet()) {
            list.add(new FreqCharPair(charFreqMap.get(character), character));
        }
        Collections.sort(list);

        char[] ansInCharArray = new char[len];
        int charArrayIndex = 0;
        for (FreqCharPair freqCharPair: list) {
            for (int i = 0; i < freqCharPair.frequency; i++) {
                ansInCharArray[charArrayIndex++] = freqCharPair.character;
            }
        }
        
        return String.copyValueOf(ansInCharArray);
    }
}

class FreqCharPair implements Comparable < FreqCharPair > {

    Integer frequency;
    Character character;

    FreqCharPair(Integer frequency, Character character) {
        this.frequency = frequency;
        this.character = character;
    }

    @Override
    public int compareTo(FreqCharPair other) {
        return -1 * Integer.compare(this.frequency, other.frequency);
    }
}
