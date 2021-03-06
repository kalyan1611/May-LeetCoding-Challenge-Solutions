class Solution {
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }
        int num2 = 0;
        int exponent = 0;
        while (num > 0) {
            num2 += (1-num%2)*(int)(Math.pow(2,exponent++));
            num /= 2;
        }
        return num2;
    }
}
