class Solution {
    
    public int[] countBits(int num) {

        if (num == 0) {
            return new int[]{0};
        }

        int[] bits = new int[num + 1];
        int lastPowerOf2 = 1;
        int nextPowerOf2 = lastPowerOf2 * 2;
        
        bits[lastPowerOf2] = 1;

        for (int i = 2; i <= num; i++) {
            if (nextPowerOf2 == i) {
                bits[nextPowerOf2] = 1;
                lastPowerOf2 = nextPowerOf2;
                nextPowerOf2 *= 2;
            } else {
                bits[i] = bits[lastPowerOf2] + bits[i - lastPowerOf2];
            }
        }

        return bits;
    }
}
