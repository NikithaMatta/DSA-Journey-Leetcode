class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int x1 = 0;
        int x2 = 0;

        if (len1 % 2 != 0) {
            for (int num : nums2) {
                x2 ^= num;
            }
        }
        if (len2 % 2 != 0) {
            for (int num : nums1) {
                x1 ^= num;
            }
        }
        return x1 ^ x2;
    }
}
