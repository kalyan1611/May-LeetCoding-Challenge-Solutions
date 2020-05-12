class Solution {
    public boolean isPerfectSquare(int num) {
        int carry = num%10;
        if (carry==2 || carry == 3 || carry == 7 || carry == 8) {
            return false;
        }
        return isPerfectSquare(0,num);
    }
    
    public boolean isPerfectSquare(int start, int num) {
        if (start*start==num) {
            return true;
        } else if (start*start > num) {
            return false;
        }
        int i = 1;
        while ((start+i)*(start+i) < num) {
            i = 3*i;
        }
        if ((start+i)*(start+i) == num) {
            return true;
        }
        if (i==1) {
            return false;
        }
        return isPerfectSquare(start+(i/3), num);
    }
}
