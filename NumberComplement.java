class Solution {
    public int findComplement(int num) {
        int num2 = 0;
        int exponent = 0;
        while (num > 0) {
            num2 += ((num%2==0)?1:0)*(int)(Math.pow(2,exponent++));
            num /= 2;
        }
        return num2;
    }
}
