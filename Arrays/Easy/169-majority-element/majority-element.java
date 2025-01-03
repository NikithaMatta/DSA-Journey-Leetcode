class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate = -1;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
    
        if (count > n / 2) {
            return candidate;
        } else {
            return -1;
        }
    }
}