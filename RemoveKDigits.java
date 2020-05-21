class Solution {

    public String removeKdigits(String num, int k) {

        while (num.length() > 0 && k-- > 0) {
            boolean foundAtFront = false;
            for (int i = 0; i < num.length() - 1; i++) {
                if (num.charAt(i) > num.charAt(i + 1)) {
                    num = num.substring(0, i) + num.substring(i + 1);
                    foundAtFront = true;
                    break;
                }
            }
            if (!foundAtFront) {
                num = num.substring(0, num.length() - 1);
            }
            while (num.length() > 0 && num.charAt(0) == '0') {
                num = num.substring(1);
            }
        }
        
        return (num.length() == 0) ? "0" : num;
    }
}
