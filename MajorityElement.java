class Solution {
    public int majorityElement(int[] nums) {
        int leader = nums[0];
        int votes = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i]==leader) {
                votes++;
            } else {
                votes--;
            }
            if (votes==0) {
                leader = nums[i];
                votes = 1;
            }
        }
        return leader;
    }
}
